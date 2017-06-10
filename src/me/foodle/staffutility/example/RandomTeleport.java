package me.foodle.staffutility.example;

import me.foodle.staffutility.item.StaffItem;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class RandomTeleport extends StaffItem{

    public RandomTeleport() {
        super(new ItemStack(Material.COMPASS), "&cRandom Teleporter.", Arrays.asList("&6<]= &7Teleport to a random player. &6=[>"));
    }

    @Override
    public void execute(PlayerInteractEvent e, Player player) {
        if(e.getAction() == Action.RIGHT_CLICK_AIR){

            Player pl = getRandomPlayer(Bukkit.getOnlinePlayers());
            if(!pl.equals(player)){
                player.teleport(pl);
            }

        }
    }
    public Player getRandomPlayer(Collection<? extends Player> players) {
        Random random = new Random();
        int x = random.nextInt(players.size());

        return (Player) players.toArray()[x];

    }

}
