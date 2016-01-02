package tech.spencercolton.smcafk.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import tech.spencercolton.smcafk.Util.AFKManager;

/**
 * @author Spencer Colton
 */
public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onEvent(PlayerQuitEvent e) {
        AFKManager.removePlayer(e.getPlayer());
    }

}
