package me.motor.motorcheck.manage;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class MotorCheckManager {
    ItemStack item = new ItemStack(Material.PAPER);
    ItemMeta meta = item.getItemMeta();
    public ItemStack createCheck(int amount) {
        if (amount <= 100) {
            meta.setDisplayName("§f§l[ §e수표 §f§l]§e " + amount + "§f원 수표");
            meta.setLore(Collections.singletonList("§7손에 들고 우클릭 시 계좌로 입금됩니다."));
            meta.setCustomModelData(100);
            item.setItemMeta(meta);
            return item;
        }
        if (amount <= 1000) {
            meta.setDisplayName("§f§l[ §e수표 §f§l]§e " + amount + "§f원 수표");
            meta.setLore(Collections.singletonList("§7손에 들고 우클릭 시 계좌로 입금됩니다."));
            meta.setCustomModelData(101);
            item.setItemMeta(meta);
            return item;
        }
        meta.setDisplayName("§f§l[ §e수표 §f§l]§e " + amount + "§f원 수표");
        meta.setLore(Collections.singletonList("§7손에 들고 우클릭 시 계좌로 입금됩니다."));
        meta.setCustomModelData(102);
        item.setItemMeta(meta);
        return item;
    }

    public static void giveCheck(Player player, int amount) {
        MotorCheckManager motorCheckManager = new MotorCheckManager();
        ItemStack check = motorCheckManager.createCheck(amount);
        player.getInventory().addItem(check);
    }
}
