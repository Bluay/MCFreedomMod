package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.BOTH)
@CommandParameters(description = "Voting", usage = "/<command>", aliases = "voting")
public class Command_vote extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "Can you vote for the server?");
        sender.sendMessage(ChatColor.RED + "Voting will help the server grow!");
        sender.sendMessage(ChatColor.BLUE + "If you can and we encourage, links below:");
        sender.sendMessage(ChatColor.DARK_PURPLE + "http://www.minestatus.net/148485-mcfreedom-free-op");
        sender.sendMessage(ChatColor.GOLD + "http://minecraftservers.org/server/375801");
        sender.sendMessage(ChatColor.DARK_GRAY + "THANKS FOR VOTING!!");
        sender.sendMessage(ChatColor.YELLOW + "Owner: Epic_Face32301");         
        return true;
    }
}