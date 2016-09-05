package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SUPER_ADMIN, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Duty!", usage = "/<command>", aliases = "du")
public class Command_duty extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

    	if(args.length==0)
    	{
        FPlayer playerdata = plugin.pl.getPlayer(playerSender);
        playerdata.setDuty();
        FUtil.bcastMsg(sender.getName() + " - has set themself as" + (playerdata.onDuty() ? " off duty" : " on duty"), ChatColor.RED);

        return true;
    	}

    	switch(args[0])
    	{
    	case"debug":
    	{
    		msg("Getting PlayerData & FPlayer");
    		FPlayer playerdata = plugin.pl.getPlayer(playerSender);
    		msg("Playerdata: " + playerdata);
    		msg("Testing Broadcast");
    		FUtil.bcastMsg(sender.getName() + " - has set themself as" + (playerdata.onDuty() ? " off duty" : " on duty"), ChatColor.RED);

    		return true;
    	}
    	}

    	msg("Usage = /<command>");
    	return false;
    }
}