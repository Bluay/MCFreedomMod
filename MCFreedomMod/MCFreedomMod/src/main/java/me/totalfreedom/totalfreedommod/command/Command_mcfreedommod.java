package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.TotalFreedomMod;
import me.totalfreedom.totalfreedommod.config.ConfigEntry;
import me.totalfreedom.totalfreedommod.config.MainConfig;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FLog;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.BOTH)
@CommandParameters(description = "Shows information about MCFreedomMod or reloads it", usage = "/<command> [reload]", aliases = "mcfm,mfm")
public class Command_mcfreedommod extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 1)
        {
            if (!args[0].equals("reload"))
            {
                return false;
            }

            if (!plugin.al.isAdmin(sender))
            {
                noPerms();
                return true;
            }

            plugin.config.load();
            plugin.services.stop();
            plugin.services.start();

            final String message = String.format("%s v%s reloaded.",
                    TotalFreedomMod.pluginName,
                    TotalFreedomMod.pluginVersion);

            msg(message);
            FLog.info(message);
            return true;
        }

        TotalFreedomMod.BuildProperties build = TotalFreedomMod.build;
        msg("MCFreedomMod for 'MC Freedom', an all-op server.", ChatColor.GOLD);
        msg("Running on " + ConfigEntry.SERVER_NAME.getString() + ".", ChatColor.GOLD);
        msg("Created by Epic_Face32301.", ChatColor.GOLD);
        msg("Modified by BearzRAwesome and Vigasaurus.", ChatColor.GOLD);
        msg(String.format("Version "
                + ChatColor.BLUE + "%s %s.%s " + ChatColor.GOLD + "("
                + ChatColor.BLUE + "%s" + ChatColor.GOLD + ")",
                build.codename,
                build.version,
                build.number,
                build.head), ChatColor.GOLD);
        msg(String.format("Compiled "
                + ChatColor.BLUE + "8/27/2016" + ChatColor.GOLD + " by "
                + ChatColor.BLUE + "Epic_Face32301",
                build.date,
                build.author), ChatColor.GOLD);
        msg("Visit " + ChatColor.AQUA + "http://mcfreedom.tk/"
                + ChatColor.GREEN + " for more information.", ChatColor.GREEN);

        return true;
    }
}
