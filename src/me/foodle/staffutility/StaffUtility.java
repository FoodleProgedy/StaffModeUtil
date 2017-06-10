package me.foodle.staffutility;

import lombok.Getter;
import me.foodle.staffutility.example.RandomTeleport;
import me.foodle.staffutility.item.StaffItemManager;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class StaffUtility {

    private StaffItemManager staffItemManager;
    private JavaPlugin plugin;

    public StaffUtility(JavaPlugin plugin){
        this.plugin = plugin;
        enable();
    }

    public void enable() {

        staffItemManager = new StaffItemManager(this);
       StaffItemManager.addStaffItem("randomteleport", new RandomTeleport());
        plugin.getServer().getPluginManager().registerEvents(staffItemManager,plugin);

    }

}
