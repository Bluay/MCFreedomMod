package me.totalfreedom.totalfreedommod.command;

import me.totalfreedom.totalfreedommod.admin.Admin;
import me.totalfreedom.totalfreedommod.banning.Ban;
import me.totalfreedom.totalfreedommod.rank.Rank;
import me.totalfreedom.totalfreedommod.util.FUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

@CommandPermissions(level = Rank.EXECUTIVE, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "For the VERY bad admins", usage = "/<command> <playername>")
public class Command_epichammer extends FreedomCommand
{

    @Override
    public boolean run(final CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (sender.getName().equalsIgnoreCase("Epic_Face32301"))
    {
    }
      else
      {
          FUtil.adminAction("WARNING: " + sender.getName(), " Has attempted to use the Epic Hammer!", true);
          
          return true;
      }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(ChatColor.RED + "Player not found");
      return true;
    }

        FUtil.adminAction(sender.getName(), "Destroying " + player.getName(), true);
        FUtil.bcastMsg(player.getName() + " was being mean to Epic_Face32301", ChatColor.RED);
        FUtil.bcastMsg(player.getName() + " will be completely DESTORYED!", ChatColor.RED);

        final String ip = player.getAddress().getAddress().getHostAddress().trim();

        // Remove from superadmin
        Admin admin = getAdmin(player);
        if (admin != null)
        {
            FUtil.adminAction(sender.getName(), "Ripping " + player.getName() + " from the superadmin list", true);
            plugin.al.removeAdmin(admin);
        }

        // Remove from whitelist
        player.setWhitelisted(false);

        // Deop
        player.setOp(false);

        // Ban player
        Ban ban = Ban.forPlayer(player, sender);
        ban.setReason("&cNext time don't be a bitch to Epic_Face32301");
        for (String playerIp : plugin.pl.getData(player).getIps())
        {
            ban.addIp(playerIp);
        }
        plugin.bm.addBan(ban);

        // Set gamemode to survival
        player.setGameMode(GameMode.SURVIVAL);

        // Clear inventory
        player.closeInventory();
        player.getInventory().clear();

        // Ignite player
        player.setFireTicks(10000);


        // Shoot the player in the sky
        player.setVelocity(player.getVelocity().clone().add(new Vector(0, 20, 0)));

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // strike lightning
                player.getWorld().strikeLightning(player.getLocation());

                // kill (if not done already)
                player.setHealth(0.0);
            }
        }.runTaskLater(plugin, 2L * 20L);

        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                // message
                FUtil.adminAction(sender.getName(), "Eviscerating " + player.getName() + ", IP: " + ip, true);

                // generate explosion
                player.getWorld().createExplosion(player.getLocation(), 4F);

                // kick player
                player.kickPlayer(ChatColor.RED + "Next time don't be a bitch to Epic_Face32301");
            }
        }.runTaskLater(plugin, 3L * 20L);

        return true;
    }
}
