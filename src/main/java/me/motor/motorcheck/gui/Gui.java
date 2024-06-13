package me.motor.motorcheck.gui;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;

public class Gui {
    private Inventory createInv() {
        Inventory inv = Bukkit.createInventory(null, 27, ":offset_-26::input::offset_-180:");

        ItemStack glass = new ItemStack(Material.PAPER);
        ItemMeta meta = glass.getItemMeta();
        meta.setCustomModelData(103);
        meta.setDisplayName("§7클릭!");
        glass.setItemMeta(meta);

        inv.setItem(10, glass);
        inv.setItem(11, glass);
        inv.setItem(12, glass);
        inv.setItem(13, glass);
        inv.setItem(14, glass);

        inv.setItem(19, glass);
        inv.setItem(20, glass);
        inv.setItem(21, glass);
        inv.setItem(22, glass);
        inv.setItem(23, glass);
        inv.setItem(16, glass);
        inv.setItem(25, glass);
        return inv;
    }

    public static void openInv (Player player) {
        Gui gui = new Gui();
        Inventory inv = gui.createInv();
        player.openInventory(inv);
    }
}
