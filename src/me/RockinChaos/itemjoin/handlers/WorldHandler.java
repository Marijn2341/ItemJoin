package me.RockinChaos.itemjoin.handlers;

import org.bukkit.configuration.ConfigurationSection;

public class WorldHandler {
	
	public static Boolean inWorld(ConfigurationSection items, String world) {
		if (items.getString(".enabled-worlds") != null) {
			String worldlist = items.getString(".enabled-worlds").replace(" ", "");
			String[] compareWorlds = worldlist.split(",");
			for (String compareWorld: compareWorlds) {
				if (compareWorld.equalsIgnoreCase(world) 
						|| compareWorld.equalsIgnoreCase("all") 
						|| compareWorld.equalsIgnoreCase("global")) {
					return true;
				}
			}
		} else if (items.getString(".enabled-worlds") == null) {
			return true;
		}
		return false;
	}
	
	public static Boolean inGlobalWorld(String world) {
		if (ConfigHandler.getConfig("config.yml").getString("enabled-worlds") != null) {
			String worldlist = ConfigHandler.getConfig("config.yml").getString("enabled-worlds").replace(" ", "");
			String[] compareWorlds = worldlist.split(",");
			for (String compareWorld: compareWorlds) {
				if (compareWorld.equalsIgnoreCase(world) 
						|| compareWorld.equalsIgnoreCase("all") 
						|| compareWorld.equalsIgnoreCase("global")) {
					return true;
				}
			}
		} else if (ConfigHandler.getConfig("config.yml").getString("enabled-worlds") == null) {
			return true;
		}
		return false;
	}
}