package tech.spencercolton.smcafk.Scheduler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import tech.spencercolton.smcafk.SMCAFK;
import tech.spencercolton.smcafk.Util.Config;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class AFKTimer extends BukkitRunnable {

    private static Map<Player, BukkitTask> timers = new HashMap<>();

    private Player p;
    private String add = "";
    private int time;

    private static final int TICKS_IN_MINUTE = 1200;

    public AFKTimer(Player p, int time) {
        this.p = p;
        if(time != 1)
            this.add = "s";
        this.time = time;

        timers.put(p, this.runTaskLater(SMCAFK.getInstance(), time * TICKS_IN_MINUTE));
    }

    public AFKTimer(Player p) {
        this(p, Config.getInt("afk-timeout"));
    }

    @Override
    public void run() {
        this.p.kickPlayer(ChatColor.DARK_PURPLE + "You were AFK for " + time + " minute" + add + ".");
    }

    public static void resetAFKTimer(Player p) {
        if(timers.get(p) != null)
            timers.remove(p);

        new AFKTimer(p);
    }

    public static void clear() {
        timers.clear();
    }

}
