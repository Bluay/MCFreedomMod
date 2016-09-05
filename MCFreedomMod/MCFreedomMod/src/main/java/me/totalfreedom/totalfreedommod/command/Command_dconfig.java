package me.totalfreedom.totalfreedommod.command;
 
import java.util.Date;
import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.player.FPlayer;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import net.pravian.aero.util.Ips;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
 
@CommandPermissions(level = Rank.OP, source = SourceType.BOTH)
@CommandParameters(description = "Manage admins.", usage = "/<command> <list | clean | reload | | setrank <username> <rank> | <add | remove | info> <username>>")
public class Command_dconfig extends FreedomCommand
{
 
    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length < 1)
        {
            return false;
        }
 
        switch (args[0])
        {
            case "test":
            {
                msg("Donors: " + StringUtils.join(plugin.al.getAdminNames(), ", "), ChatColor.GREEN);
 
                return true;
            }
        }
 
        return false;
    }
}