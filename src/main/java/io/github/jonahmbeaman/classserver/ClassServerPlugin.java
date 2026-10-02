package io.github.jonahmbeaman.classserver;

import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
            case "speed" -> {
                if (!(sender instanceof Player player)) {
                    sender.sendMessage(Component.text("Use /speed while playing on the server."));
                    return true;
                }
                // Minecraft measures effect duration in ticks: 20 ticks per second.
                int durationTicks = 5 * 60 * 60 * 20;
                // Amplifiers start at 0, so 2 means level III.
                int amplifier = 2;
                player.addPotionEffect(new PotionEffect(
                    PotionEffectType.SPEED, durationTicks, amplifier));
                player.sendMessage(Component.text("Speed III applied for 5 hours of game time."));
            }
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
