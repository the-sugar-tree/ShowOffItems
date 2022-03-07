package com.sugar_tree.showoffitems;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class ShowOffItems extends JavaPlugin {

    public static ItemStack glass;
    public static final String PREFIX = ChatColor.LIGHT_PURPLE + "[" + ChatColor.AQUA + "ShowOffItems" + ChatColor.LIGHT_PURPLE + "] " + ChatColor.RESET;

    @SuppressWarnings("ConstantConditions")
    @Override
    public void onEnable() {
        getCommand("자랑하기").setExecutor(new Commands());
        getCommand("자랑하기").setTabCompleter(new Commands());
        Bukkit.getPluginManager().registerEvents(new Listeners(), this);
        glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta itemMeta = glass.getItemMeta();
        itemMeta.displayName(Component.text(""));
        glass.setItemMeta(itemMeta);
    }

    @Override
    public void onDisable() {
    }

    public static void showOff(Player p) {
        Inventory inventory = Bukkit.createInventory(null, 9, Component.text(ChatColor.GREEN + "자랑 할 아이템을 올려주세요!"));
        inventory.setItem(0, glass);
        inventory.setItem(1, glass);
        inventory.setItem(2, glass);
        inventory.setItem(3, glass);
        inventory.setItem(5, glass);
        inventory.setItem(6, glass);
        inventory.setItem(7, glass);
        inventory.setItem(8, glass);
        p.openInventory(inventory);
    }
}
