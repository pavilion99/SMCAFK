package tech.spencercolton.smcafk.Util;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;
import tech.spencercolton.smcafk.Scheduler.AFKWarn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Spencer Colton
 */
public class AFKManager {

    private static Map<Player, BukkitTask> warns = new HashMap<>();
    private static Map<Player, BukkitTask> kicks = new HashMap<>();

    public static void resetAFK(Player p) {
        if(warns.containsKey(p)) {
            warns.get(p).cancel();
            warns.remove(p);
            new AFKWarn(p);
        }

        if(kicks.containsKey(p)) {
            kicks.get(p).cancel();
            kicks.remove(p);
        }
    }

    public static void addPlayer(Player p, BukkitTask b) {
        warns.put(p, b);
    }

    public static void prepKick(Player p, BukkitTask b) {
        kicks.put(p, b);
    }

    public static void removePlayer(Player p) {
        if(warns.get(p) != null)
            warns.get(p).cancel();
        warns.remove(p);

        if(kicks.get(p) != null)
            kicks.get(p).cancel();
        kicks.remove(p);
    }

    public static void clear() {
        warns.clear();
        kicks.clear();
    }

}
