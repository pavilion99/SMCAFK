package tech.spencercolton.smcafk.Scheduler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tech.spencercolton.smcafk.SMCAFK;
import tech.spencercolton.smcafk.Util.AFKManager;

/**
 * @author Spencer Colton
 */
public class AFKKick extends BukkitRunnable {

    private Player p;
    private String add = "";
    private int time;

    public AFKKick(Player p, int time) {
        this.p = p;
        if(time != 1)
            this.add = "s";
        this.time = time;

        AFKManager.prepKick(p, this.runTaskLater(SMCAFK.getInstance(), time));
    }

    @Override
    public void run() {
        this.p.kickPlayer(ChatColor.DARK_PURPLE + "You were AFK for " + this.time + " minute" + add + ".");
    }

}
