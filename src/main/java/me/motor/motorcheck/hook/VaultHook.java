package me.motor.motorcheck.hook;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultHook {
    public static VaultHook vaultHook = new VaultHook();
    private static Economy economy;

    public double getBalance(OfflinePlayer player) {
        return economy.getBalance(player);
    }


    public static boolean setupEconomy() {
        if (Bukkit.getPluginManager().getPlugin("Vault") == null) {
            Bukkit.getLogger().info("1");
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = Bukkit.getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            Bukkit.getLogger().info("2");
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }

    public static Economy getEconomy() {
        return economy;
    }


    public int getIntBalance(OfflinePlayer player) {
        return (int) getBalance(player);
    }

    public boolean deposit(OfflinePlayer player, double amount) {
        int intAmount = (int) amount;
        if (intAmount <= 0) {
            return false;
        }

        int balance = getIntBalance(player);
        economy.depositPlayer(player, amount);

        return true;

    }

    public boolean withdraw(OfflinePlayer player, double amount) {
        int intAmount = (int) amount;
        if (intAmount <= 0) {
            return false;
        }

        int balance = getIntBalance(player);
        if (balance < intAmount) {
            return false;
        }
        economy.withdrawPlayer(player, amount);
        Player to = (Player) player;

        to.sendMessage("§e" + intAmount + "§f원이 인출되었고 수표가 발행되었습니다.");
        return true;
    }

}
