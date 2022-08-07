package yusama125718.man10market;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;

public final class Man10Market extends JavaPlugin {

    public static Menu menu = new Menu();
    public static Function func = new Function();
    public static boolean system;
    public static JavaPlugin mce;
    public static List<Data.MarketItem> items;
    public static MySQLManager mysql;

    @Override
    public void onEnable() {
        mce = this;
        mysql = new MySQLManager(mce,"mce");
        func.ReRoadconfig();
        getCommand("mce").setExecutor(new Commands());
        new Event(this);
    }
}
