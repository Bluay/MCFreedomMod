package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.SENIOR_ADMIN, source = SourceType.BOTH, blockHostConsole = true)
@CommandParameters(description = "Enable system mode.", usage = "/<command> [on | off]")
public class Command_systemmode extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("off"))
        {
            ConfigEntry.SYSTEM_ONLY_MODE.setBoolean(false);
            FUtil.adminAction(sender.getName(), "Disabling System Mode.", true);
            return true;
        }
        else if (args[0].equalsIgnoreCase("on"))
        {
            ConfigEntry.SYSTEM_ONLY_MODE.setBoolean(true);
            FUtil.adminAction(sender.getName(), "Enabling System Mode.", true);
            for (Player player : server.getOnlinePlayers())
            {
                Rank rank = Rank.findRank(args[2]);
                if (!rank.isAtLeast(Rank.EXECUTIVE))
                {
                    player.kickPlayer("Server is now system mode.");
                }
            }
            return true;
        }

        return false;
    }
}
