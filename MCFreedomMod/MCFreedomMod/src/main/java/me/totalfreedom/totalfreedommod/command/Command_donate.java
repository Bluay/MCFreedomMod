package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.BOTH)
@CommandParameters(description = "Donation info", usage = "/<command>", aliases = "buy")
public class Command_donate extends FreedomCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "Can you donate for the server?");
        sender.sendMessage(ChatColor.GOLD + "Donations go only towards MCFreedom");
        sender.sendMessage(ChatColor.AQUA + "Donations ranks will soon be added but,");
        sender.sendMessage(ChatColor.GOLD + "if you donate you get added to whitelist.");
        sender.sendMessage(ChatColor.AQUA + "and to the adminworld plus other perks.");
        sender.sendMessage(ChatColor.GOLD + "Donating will help the server stay alive.");
        sender.sendMessage(ChatColor.AQUA + "If you have donated we thank you so much!");
        sender.sendMessage(ChatColor.YELLOW + "https://server.pro/server/3207327/donate/");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "Thanks for your help! -MCFreedom Team");
        return true;
    }
}