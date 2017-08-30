package com.japaricraft.japaricraftmod.command;

import net.minecraft.command.*;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;


public class SandStarStructureCommand extends CommandBase {
    public String getName()
    {
        return "sandstarlocate";
    }

    /**
     * Return the required permission level for this command.
     */
    public int getRequiredPermissionLevel()
    {
        return 2;
    }

    /**
     * Gets the usage string for the command.
     */
    public String getUsage(ICommandSender sender)
    {
        return "commands.sandstarlocate.usage";
    }

    /**
     * Callback for when the command is executed
     */
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length != 1)
        {
            throw new WrongUsageException("commands.locate.usage", new Object[0]);
        }
        else
        {
            String s = args[0];
            BlockPos blockpos = sender.getEntityWorld().findNearestStructure(s, sender.getPosition(), false);

            if (blockpos != null)
            {
                sender.sendMessage(new TextComponentTranslation("commands.locate.success", new Object[] {s, blockpos.getX(), blockpos.getZ()}));
            }
            else
            {
                throw new CommandException("commands.locate.failure", new Object[] {s});
            }
        }
    }

    /**
     * Get a list of options for when the user presses the TAB key
     */
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos)
    {
        return args.length == 1 ? getListOfStringsMatchingLastWord(args, new String[] {"SandStarDungeon"}) : Collections.emptyList();
    }
}