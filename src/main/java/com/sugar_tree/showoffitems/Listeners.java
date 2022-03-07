package com.sugar_tree.showoffitems;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.Objects;

public class Listeners implements Listener {

    @SuppressWarnings("ConstantConditions")
    @EventHandler
    public void onInventoryClose(InventoryCloseEvent event) {
        if (event.getView().title().equals(Component.text(ChatColor.GREEN + "자랑 할 아이템을 올려주세요!"))) {
            if (!(event.getInventory().getItem(4) == null)) {
                if (!(event.getInventory().getItem(4).getType().isAir())) {
                    Bukkit.broadcast(((Player) event.getPlayer()).displayName().append(Component.text("님이 ").append(event.getInventory().getItem(4).displayName()).append(Component.text("x" + event.getInventory().getItem(4).getAmount() + "을(를) 지랑합니다!"))));
                    event.getPlayer().getInventory().addItem(Objects.requireNonNull(event.getInventory().getItem(4)));
                }
            }
        }
    }

    @EventHandler
    public void showOffEvent(InventoryClickEvent event) {
        if (event.getWhoClicked().getOpenInventory().title().equals(Component.text(ChatColor.GREEN + "자랑 할 아이템을 올려주세요!"))) {
            if (event.getClick().equals(ClickType.NUMBER_KEY)) {
                event.setCancelled(true);
                return;
            }
            if (!(event.getClickedInventory() == null)) {
                if ((event.getClickedInventory()).getType().equals(InventoryType.CHEST)) {
                    if (event.getSlot() != 4 || event.getClick().equals(ClickType.DROP) || event.getClick().equals(ClickType.CONTROL_DROP)) {
                        event.setCancelled(true);
                    }
                }
            }
        }
    }
}
