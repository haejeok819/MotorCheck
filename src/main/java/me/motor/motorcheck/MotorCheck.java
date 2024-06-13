package me.motor.motorcheck;

import me.motor.motorcheck.command.CommandTab;
import me.motor.motorcheck.command.MotorCheckCommand;
import me.motor.motorcheck.hook.VaultHook;
import me.motor.motorcheck.listner.CheckDeposit;
import me.motor.motorcheck.listner.InvClick;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class MotorCheck extends JavaPlugin {

    @Override
    public void onEnable() {
        if (!VaultHook.setupEconomy()) {
            getLogger().severe("Vault를 찾을 수 없습니다. 플러그인이 종료됩니다.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getLogger().info("[수표] Vault 연동이 완료되었습니다.");
        getCommand("수표").setExecutor(new MotorCheckCommand());
        getCommand("수표").setTabCompleter(new CommandTab());
        getServer().getPluginManager().registerEvents((Listener) new CheckDeposit(), (Plugin) this);
        getServer().getPluginManager().registerEvents((Listener) new InvClick(), (Plugin) this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("[수표] 플러그인이 비활성화되었습니다.");
    }
}
