package tech.spencercolton.smcafk.Scheduler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import tech.spencercolton.smcafk.SMCAFK;
import tech.spencercolton.smcafk.Util.AFKManager;
import tech.spencercolton.smcafk.Util.Config;
/**
 * @author Spencer Colton
 */
public class AFKWarn extends BukkitRunnable {

    private Player p;
    private String add = "";
    private int time;
    private int latentTime;

    private static final int TICKS_IN_MINUTE = 1200;
    private static final int TICKS_IN_SECOND = 20;

    public AFKWarn(Player p, int time) {
        this.p = p;
        this.time = time;
        this.latentTime = Config.getInt("afk-warning");
        if(latentTime != 1)
            this.add = "s";

        AFKManager.addPlayer(p, this.runTaskLater(SMCAFK.getInstance(), time));
    }

    public AFKWarn(Player p) {
        this(p, Config.getInt("afk-timeout") * TICKS_IN_MINUTE - Config.getInt("afk-warning") * TICKS_IN_SECOND);
    }

    @Override
    public void run() {
        this.p.sendMessage(ChatColor.DARK_PURPLE + "[SMCAFK] You will be kicked for inactivity in " + latentTime + " second" + add + ".  Move to cancel.");
        int del = Config.getInt("afk-warning") * TICKS_IN_SECOND;
        new AFKKick(p, del);
    }

}
