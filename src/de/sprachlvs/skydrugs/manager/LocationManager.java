package de.sprachlvs.skydrugs.manager;

import de.sprachlvs.skydrugs.apis.ConfigAPI;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;

public class LocationManager {
    public static ConfigAPI locationConfig;

    public LocationManager() {
    }

    static {
        locationConfig = new ConfigAPI("plugins/System/", "locations.yml");
    }

    public static ArrayList<String> all_locations = new ArrayList<>();

    public static void setLocation(Location location, String name) {
        Validate.notNull(location, "Location cannot be null");
        Validate.notNull(name, "Name cannot be null");
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".world", location.getWorld().getName());
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".x", location.getX());
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".y", location.getY());
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".z", location.getZ());
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".yaw", location.getYaw());
        locationConfig.getConfig().set("location." + name.toLowerCase() + ".pitch", location.getPitch());

        if(!all_locations.contains(name)) {
            all_locations.add(name);
        }

        locationConfig.getConfig().set(".AllLocations", all_locations);



        locationConfig.saveConfig();
    }

    public static ArrayList<String> getAllLocation() {
        return (ArrayList<String>) locationConfig.getConfig().getStringList(".AllLocations");
    }

    public static void remLocation(String name) {
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);
        locationConfig.getConfig().set("location." + name.toLowerCase(), null);


        if(all_locations.contains(name)) {
            all_locations.remove(name);
        }

        locationConfig.getConfig().set(".AllLocations", all_locations);

        locationConfig.saveConfig();
    }

    public static Location getLocation(String name) {
        Validate.notNull(name, "Name cannot be null");
        String world = locationConfig.getConfig().getString("location." + name + ".world");
        Double x = locationConfig.getConfig().getDouble("location." + name + ".x");
        Double y = locationConfig.getConfig().getDouble("location." + name + ".y");
        Double z = locationConfig.getConfig().getDouble("location." + name + ".z");
        Float yaw = (float) locationConfig.getConfig().getDouble("location." + name + ".yaw");
        Float pitch = (float) locationConfig.getConfig().getDouble("location." + name + ".pitch");
        return new Location(Bukkit.getWorld(world), x, y, z, yaw, pitch);
    }
}
