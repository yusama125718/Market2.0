package yusama125718.man10market;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static yusama125718.man10market.Man10Market.*;

public class Commands implements CommandExecutor {

    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        if (!sender.hasPermission("mce.player")){
            sender.sendMessage("§c[MCE]権限がありません");
            return true;
        }
        switch (args.length){
            case 0:
                if (!system){
                    sender.sendMessage("§l[§a§lM§f§lC§d§lE§f§l]§rMCEは現在停止中です");
                }
                menu.TopMenu((Player) sender);
                return true;

            case 1:
                switch (args[0]) {
                    case "help":
                        sender.sendMessage("=====§a§lM§f§lC§d§lE§f§lHelp§r=====");
                        if (sender.hasPermission("mce.op")) {
                            sender.sendMessage("§7/mce on §fシステムを起動します");
                            sender.sendMessage("§7/mce of §fシステムを停止します");
                            sender.sendMessage("§7/mce reload §fconfigファイルをリロードします");
                        }
                        sender.sendMessage("§7/mce §fメニューを開きます");

                    case "on":
                        if (!sender.hasPermission("mce.op")){
                            sender.sendMessage("§c[MCE]権限がありません");
                            return true;
                        }
                        if (system) {
                            sender.sendMessage("§l[§a§lM§f§lC§d§lE§f§l]§rMCEは既にONです");
                            return true;
                        }
                        system = true;
                        mce.getConfig().set("system",system);
                        mce.saveConfig();
                        Bukkit.broadcast("mce.player","§l[§a§lM§f§lC§d§lE§f§l]§rMCEがONになりました");
                        return true;

                    case "off":
                        if (!sender.hasPermission("mce.op")){
                            sender.sendMessage("§c[MCE]権限がありません");
                            return true;
                        }
                        if (!system) {
                            sender.sendMessage("§l[§a§lM§f§lC§d§lE§f§l]§rMCEは既にOFFです");
                            return true;
                        }
                        system = false;
                        mce.getConfig().set("system",system);
                        mce.saveConfig();
                        Bukkit.broadcast("mce.player","§l[§a§lM§f§lC§d§lE§f§l]§rMCEがOFFになりました");
                        return true;

                    case "reload":
                        if (!sender.hasPermission("mce.op")){
                            sender.sendMessage("§c[MCE]権限がありません");
                            return true;
                        }
                        func.ReRoadconfig();
                        return true;

                    default:
                        sender.sendMessage("§l[§a§lM§f§lC§d§lE§f§l]§7/mce でGUIを開く");
                        return true;
                }


            default:
                sender.sendMessage("§l[§a§lM§f§lC§d§lE§f§l]§7/mce でGUIを開く");
                return true;
        }
    }
}
