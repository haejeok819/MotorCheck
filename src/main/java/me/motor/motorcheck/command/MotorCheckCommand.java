package me.motor.motorcheck.command;

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
        if (args.length == 0) {
            sender.sendMessage("§a§l수표 [금액]");
            sender.sendMessage("§aㄴ 1~100 코인 101~1000 지폐 1001~ 지폐 뭉치");
            return false;
        }
        double amount;
        int amountint;
        Player player = (Player) sender;
        OfflinePlayer offlinePlayer = (Player) sender;
        try {
            amount = Double.parseDouble(args[0]);
            amountint = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            sender.sendMessage("§c§l× §c정수만 입력해주세요.");
            return false;
        }
        if (!vaultHook.withdraw(offlinePlayer, amount)) {
            player.sendMessage("§c§l× §c보유 금액이 부족합니다.");
            return false;
        }
        MotorCheckManager.giveCheck(player, amountint);
        return true;
    }
}
