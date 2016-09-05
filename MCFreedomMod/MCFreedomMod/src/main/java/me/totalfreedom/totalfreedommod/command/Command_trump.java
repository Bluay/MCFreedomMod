package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH)
@CommandParameters(description = "Someone know too much about politics?", usage = "/<command> <player>")
public class Command_trump extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }

        final Player player = getPlayer(args[0]);


        if (player == null)
        {
            msg(FreedomCommand.PLAYER_NOT_FOUND);
            return true;
        }

        smite(player);
        return true;
    }

    public static void smite(Player player)
    {
        smite(player, null);
    }

    public static void smite(Player player, String reason)
    {
        FUtil.bcastMsg(player.getName() + " is going to try to climb a tower", ChatColor.RED);
        FUtil.bcastMsg("What tower? A very special one indeed", ChatColor.RED);
        FUtil.bcastMsg(player.getName() + " is climibing Trumps Tower!", ChatColor.RED);
        FUtil.bcastMsg(player.getName() + " is almost there!", ChatColor.RED);
        FUtil.bcastMsg("But they fell, too bad", ChatColor.RED);
        
        // Deop
        player.setOp(false);

        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.getInventory().clear();
        
        // Kill
        player.setHealth(0.0);
        
        FUtil.bcastMsg(player.getName() + " will be nicer next time.", ChatColor.RED);
    }
}
