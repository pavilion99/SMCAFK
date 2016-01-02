package tech.spencercolton.smcafk.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import tech.spencercolton.smcafk.Util.AFKManager;

/**
 * @author Spencer Colton
 */
public class PlayerFishListener implements Listener {

    @EventHandler
    public void onEvent(PlayerFishEvent e) {
        if(e.getState() == PlayerFishEvent.State.FISHING)
            AFKManager.exempt.add(e.getPlayer());
        else
            AFKManager.exempt.remove(e.getPlayer());
    }

}
