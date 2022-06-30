package net.syobonoon.plugin.miclospunish;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class MicLoSPunish extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("onEnable");
	}

	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if (!sender.hasPermission("miclospunish.dainai")) return false;
		if(cmd.getName().equalsIgnoreCase("dainai")) {
			Player target = (Player) sender;
			if (!(sender instanceof Player)) return false;
			if (args.length > 1) {
		        sender.sendMessage(ChatColor.RED + "There are too many parameters.");
		        return false;
		    }
			if (args.length == 1) target = Bukkit.getPlayerExact(args[0]);
		    if (target == null) {
		        sender.sendMessage(ChatColor.RED + args[0] + "is not on the server.");
		        return false;
		    }

		    Location t_loc = target.getLocation();
		    target.getWorld().strikeLightningEffect(t_loc);
		    target.getWorld().createExplosion(t_loc, 0);
		    target.getWorld().spawnParticle(Particle.CLOUD, t_loc, 500, 10, 10, 10, 0.1);
		    target.setHealth(0.0D);
		    return true;
        }
		return false;
	}
}
