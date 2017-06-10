package me.foodle.staffutility.item;

import me.foodle.staffutility.StaffUtility;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class StaffItemManager implements Listener{

    private static HashMap<String,StaffItem> staffItems = new HashMap<>();
    private StaffUtility staffPlugin;

    public StaffItemManager(StaffUtility staffPlugin){
        this.staffPlugin = staffPlugin;


    }


    public static void addStaffItem(String identifier,StaffItem item){
        staffItems.put(identifier,item);
    }

    public static void deactivateStaffItem(String identifier){
        staffItems.remove(identifier);
    }

    public StaffItem getStaffItemByName(String name){
        return staffItems.get(name);
    }
    public StaffItem getStaffItemByItemStack(ItemStack is) {
        for (StaffItem staffItem : staffItems.values()) {
            if (staffItem.getStack().equals(is)) {
                return staffItem;
            }
        }
        return null;
    }
    private boolean isStaffItem(ItemStack is){
        return (getStaffItemByItemStack(is) == null);
    }

    @EventHandler
    public void interact(PlayerInteractEvent e){
        Player player = e.getPlayer();
        if(!ItemChecks.isNull(player.getItemInHand())) {
            if (getStaffItemByItemStack(player.getItemInHand()) != null) {
                getStaffItemByItemStack(player.getItemInHand()).execute(e, player);
            }
        }
    }
    @EventHandler
    public void interactEntity(PlayerInteractEntityEvent e){
        Player player = e.getPlayer();
        if(!ItemChecks.isNull(player.getItemInHand())) {
            if (getStaffItemByItemStack(player.getItemInHand()) != null) {
                getStaffItemByItemStack(player.getItemInHand()).execute(e, player);
            }
        }
    }
    @EventHandler
    public void interact(BlockPlaceEvent e){
        Player player = e.getPlayer();
        if(!ItemChecks.isNull(player.getItemInHand())) {
            if (getStaffItemByItemStack(player.getItemInHand()) != null) {
                getStaffItemByItemStack(player.getItemInHand()).execute(e, player);
            }
        }
    }
    @EventHandler
    public void close(InventoryCloseEvent e){
        Player player = (Player)e.getPlayer();
        if(!ItemChecks.isNull(player.getItemInHand()))
            if(getStaffItemByItemStack(player.getItemInHand()) != null){
                getStaffItemByItemStack(player.getItemInHand()).execute(e,player);
            }
    }

}
