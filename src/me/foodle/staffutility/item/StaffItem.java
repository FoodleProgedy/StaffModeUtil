package me.foodle.staffutility.item;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/*

I realized i can use generics for the execute method.
Just put an abstract method like so:

public abstract <T extends PlayerEvent> void execute(T event), and in classes that extend it, proceed to check if the instance of that event is the event you want.


something like this:

public <T extends PlayerEvent> void execute(T event) {
     if(event instanceof PlayerInteractEvent) {
        PlayerInteractEvent e = (PlayerInteractEvent) event;
        e.getPlayer().sendMessage("Yalla deedle doo");
     }
}

Also, this is written in github's edit, so i dunno if this will show any errors while compiling, but it's a simple example.

Yalla deedle doo.

*/
@Getter
public abstract class StaffItem {

    private ItemStack stack;

    private String name,permission;
    private List<String> lore;


    public StaffItem(ItemStack stack, String name, List<String> lore) {
        this.stack = stack;
        this.name = ChatColor.translateAlternateColorCodes('&',name);
        for (int i = 0; i < lore.size(); i++) {
            lore.set(i,ChatColor.translateAlternateColorCodes('&',lore.get(i)));
        }
        this.lore = lore;


    }
    public ItemStack getStaffItem(Player player){
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
    }

    public void execute(PlayerInteractEvent e, Player player){}
    public void execute(PlayerInteractEntityEvent e, Player player){}
    public void execute(InventoryCloseEvent e, Player player){}
    public void execute(BlockPlaceEvent e, Player player){}
}
