package com.sugar_tree.showoffitems;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

import static com.sugar_tree.showoffitems.ShowOffItems.PREFIX;
import static com.sugar_tree.showoffitems.ShowOffItems.showOff;

public class Commands implements TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("자랑하기")) {
            if (sender instanceof Player p) {
                showOff(p);
            }
            else {
                sender.sendMessage(PREFIX + ChatColor.RED + "플레이어만 이 커맨드를 이용 할 수 있습니다!");
            }
            return true;
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("자랑하기")) {
            return new ArrayList<>();
        }
        return null;
    }
}
