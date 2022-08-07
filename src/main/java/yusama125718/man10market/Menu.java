package yusama125718.man10market;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Material.*;
import static yusama125718.man10market.Man10Market.*;

public class Menu {
    public void TopMenu(Player target){
        Inventory inv = Bukkit.createInventory(null,9, "Man10CentralExchange");
        inv = func.SetBase(inv);
        inv.setItem(4,func.ItemCreate(1,LECTERN,"§lアイテムの売買",0));
        target.openInventory(inv);
    }

    public static void MarketMain(Player target,int page){
        Inventory inv = Bukkit.createInventory(null,54, "[MCE]アイテムを選択");
        target.openInventory(inv);
    }
}
