package me.motor.motorcheck.command;

import me.motor.motorcheck.gui.Gui;
import me.motor.motorcheck.manage.MotorCheckManager;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.motor.motorcheck.hook.VaultHook.vaultHook;


public class MotorCheckCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        OfflinePlayer offlinePlayer = (Player) sender;

        Gui.openInv(player);
        return true;


    }
}
