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
