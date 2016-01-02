package tech.spencercolton.smcafk.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import tech.spencercolton.smcafk.Scheduler.AFKWarn;

/**
 * @author Spencer Colton
 */
public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onEvent(PlayerJoinEvent e) {
        new AFKWarn(e.getPlayer());
    }

}
