package yusama125718.man10market;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Material.*;
import static yusama125718.man10market.Man10Market.*;

public class Function {
    public void ReRoadconfig(){
        system = false;
        Bukkit.broadcast("mce.op","§l[§a§lM§f§lC§d§lE§f§l]§rDBロード開始");
        mysql.execute("create table if not exists mce_buy(id int auto_increment,itemid int,item varchar(30),time varchar(19),mcid varchar(50),uuid varchar(50),price int,quantity int)");
        mysql.execute("create table if not exists mce_sell(id int auto_increment,itemid int,item varchar(30),time varchar(19),mcid varchar(50),uuid varchar(50),price int,quantity int)");
        mysql.execute("create table if not exists mce_log(id int auto_increment,itemid int,item varchar(30),time varchar(19),type varchar(4),mcid varchar(50),uuid varchar(50),price int,quantity int)");
        Bukkit.broadcast("mce.op","§l[§a§lM§f§lC§d§lE§f§l]§rDBロード完了");
        Bukkit.broadcast("mce.op","§l[§a§lM§f§lC§d§lE§f§l]§rconfigロード開始");
        mce.saveDefaultConfig();
        system = mce.getConfig().getBoolean("system");
        Bukkit.broadcast("mce.op","§l[§a§lM§f§lC§d§lE§f§l]§rconfigロード完了");
    }

    public ItemStack ItemCreate(int amount, Material mate, String name, int cmd){
        ItemStack item = new ItemStack(mate,amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        if (cmd != 0){
            meta.setCustomModelData(cmd);
        }
        item.setItemMeta(meta);
        return item;
    }

    public Inventory SetBase(Inventory inv){
        for (int i = 0; i < inv.getSize(); i++){
            inv.setItem(i,ItemCreate(1, WHITE_STAINED_GLASS_PANE,"",0));
        }
        return inv;
    }
}
