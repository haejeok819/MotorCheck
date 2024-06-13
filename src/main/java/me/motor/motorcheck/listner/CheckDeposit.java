package me.motor.motorcheck.listner;

import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

import static me.motor.motorcheck.hook.VaultHook.vaultHook;

public class CheckDeposit implements Listener {

    @EventHandler
    public void checkDeposit(PlayerInteractEvent event) {

        Action action = event.getAction();
        Player player = event.getPlayer();
        ItemStack mainHand = player.getInventory().getItemInMainHand();
        if (event.getHand() != EquipmentSlot.HAND)
            return;
        if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getType() == Material.PAPER && player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains("§f§l[ §e수표 §f§l]§e ")) {
                String itemName = (String) player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
                String newName = itemName.replace("§f§l[ §e수표 §f§l]§e ", "").replace("§f원 수표", "");
                double amount;
                int amountint;
                OfflinePlayer offlinePlayer = (OfflinePlayer) player;
                try {
                    amount = Double.parseDouble(newName);
                    amountint = Integer.parseInt(newName);
                } catch (NumberFormatException e) {
                    return;
                }
                if (vaultHook.deposit(offlinePlayer, amount)) {
                    player.getInventory().removeItem(player.getInventory().getItemInMainHand());
                    player.sendMessage("§e" + amountint + "§f원짜리 수표가 계좌에 입금되었습니다");
                    return;
                }

            }
        }


    }
}
