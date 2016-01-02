package tech.spencercolton.smcafk.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import tech.spencercolton.smcafk.Scheduler.AFKTimer;

/**
 * @author Spencer Colton
 */
public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onEvent(PlayerMoveEvent e) {
        AFKTimer.resetAFKTimer(e.getPlayer());
    }

}
