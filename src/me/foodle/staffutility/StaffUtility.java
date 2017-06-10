package me.foodle.staffutility;

import me.foodle.staffutility.item.StaffItemManager;
import org.bukkit.plugin.java.JavaPlugin;

public class StaffUtility {

    private StaffItemManager staffItemManager;
    private JavaPlugin plugin;

    public StaffUtility(JavaPlugin plugin){
        this.plugin = plugin;
        enable();
    }

    public void enable() {

        staffItemManager = new StaffItemManager(this);
        plugin.getServer().getPluginManager().registerEvents(staffItemManager,plugin);

    }

}
