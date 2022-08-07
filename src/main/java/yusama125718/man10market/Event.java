package yusama125718.man10market;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static org.bukkit.Material.LECTERN;
import static yusama125718.man10market.Man10Market.func;

public class Event implements Listener {
    public Event(Man10Market plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void ClickGUI(InventoryClickEvent e){
        switch (e.getView().getTitle()){
            case "Man10CentralExchange":
                e.setCancelled(true);
                if (e.getCurrentItem() == null) return;
                if (e.getCurrentItem().equals(func.ItemCreate(1,LECTERN,"§lアイテムの売買",0))){
                    Menu.MarketMain((Player) e.getWhoClicked(),1);
                }
                return;

            case "[MCE]アイテムを選択":
                e.setCancelled(true);
                if (e.getCurrentItem() == null) return;
        }
    }
}
