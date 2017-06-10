package me.foodle.staffutility.item;

import org.bukkit.inventory.ItemStack;

public class ItemChecks {

    public static boolean isNull(ItemStack stack){
        return stack == null;
    }
    public static boolean hasName(ItemStack stack){
        if(!isNull(stack) && stack.hasItemMeta()){
            return stack.getItemMeta().hasDisplayName();
        }
        return false;
    }
    public static boolean hasLore(ItemStack stack){
        if(!isNull(stack) && stack.hasItemMeta()){
            return stack.getItemMeta().hasLore();
        }
        return false;
    }

}
