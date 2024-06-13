package me.motor.motorcheck.listner;

import me.motor.motorcheck.manage.MotorCheckManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static me.motor.motorcheck.hook.VaultHook.vaultHook;

public class InvClick implements Listener {
    @EventHandler
    public void onInvClick(InventoryClickEvent event) {
        String invName = event.getView().getTitle();
        if (invName.contains(":input:")) {
            event.setCancelled(true);
            Player player = (Player) event.getWhoClicked();
            Inventory inv = event.getInventory();


            int slot =  event.getRawSlot();
            switch (slot) {
                case 10:
                    event.getView().setTitle(invName + "1");
                    return;
                case 11:
                    event.getView().setTitle(invName + "2");
                    return;
                case 12:
                    event.getView().setTitle(invName + "3");
                    return;
                case 13:
                    event.getView().setTitle(invName + "4");
                    return;
                case 14:
                    event.getView().setTitle(invName + "5");
                    return;
                case 19:
                    event.getView().setTitle(invName + "6");
                    return;
                case 20:
                    event.getView().setTitle(invName + "7");
                    return;
                case 21:
                    event.getView().setTitle(invName + "8");
                    return;
                case 22:
                    event.getView().setTitle(invName + "9");
                    return;
                case 23:
                    event.getView().setTitle(invName + "0");
                    return;
                case 16:
                    if (invName.endsWith(":"))
                        return;
                    event.getView().setTitle(invName.substring(0, invName.length() - 1));
                    return;
                case 25:
                    String newInvName = invName.replace(":offset_-26::input::offset_-180:", "");
                    double amount;
                    int amountint;
                    try {
                        amount = Double.parseDouble(newInvName);
                        amountint = Integer.parseInt(newInvName);
                    } catch (NumberFormatException e) {
                        player.sendMessage("§c§l× §c정수만 입력해주세요.");
                        return;
                    }
                    if (!vaultHook.withdraw((OfflinePlayer) player, amount)) {
                        player.sendMessage("§c§l× §c보유 금액이 부족합니다.");
                        return;
                    }
                    MotorCheckManager.giveCheck(player, amountint);
                    return;
            }
        }

    }
}
