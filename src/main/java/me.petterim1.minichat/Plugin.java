package me.petterim1.minichat;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.plugin.PluginBase;

public class Plugin extends PluginBase implements Listener {

    private static String format;

    public void onEnable() {
        saveDefaultConfig();
        format = getConfig().getString("format", "<%player%> %message%");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onChat(PlayerChatEvent e) {
        e.setFormat(format.replace("%player%", e.getPlayer().getName()).replace("%message%", e.getMessage()));
    }
}
