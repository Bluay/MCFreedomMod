package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "Become admin!", usage = "/<command>")
public class Command_admin extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        FUtil.adminAction(sender.getName(), "Adding " + sender.getName() + " to the NOOB list", true);
        sender.sendMessage(ChatColor.DARK_RED + "Did you think that would really work...");      
        return true;
    }
}