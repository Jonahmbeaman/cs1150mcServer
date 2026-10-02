package io.github.jonahmbeaman.classserver;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ClassServerPlugin extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("ClassServer examples loaded.");
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // A private welcome for the joining player, not chat spam for everyone.
        event.getPlayer().sendMessage(Component.text(
            BeginnerExamples.welcome(event.getPlayer().getName())));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,
                             String label, String[] args) {
        switch (command.getName().toLowerCase(java.util.Locale.ROOT)) {
            case "hello" -> sender.sendMessage(Component.text(
                BeginnerExamples.hello(sender.getName())));
            case "dice" -> sender.sendMessage(Component.text(
                "You rolled " + BeginnerExamples.rollDice() + "."));
            case "count" -> {
                for (int number = 1; number <= 5; number++) {
                    sender.sendMessage(Component.text("Number: " + number));
                }
            }
            default -> { return false; }
        }
        return true;
    }
}
