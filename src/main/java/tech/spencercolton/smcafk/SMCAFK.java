package tech.spencercolton.smcafk;

import org.bukkit.plugin.java.JavaPlugin;
import tech.spencercolton.smcafk.Listeners.PlayerMoveListener;
import tech.spencercolton.smcafk.Scheduler.AFKTimer;
import tech.spencercolton.smcafk.Util.Config;

/**
 * @author Spencer Colton
 */
public class SMCAFK extends JavaPlugin {

    private static SMCAFK instance;

    @Override
    public void onEnable() {
        instance = this;

        this.saveDefaultConfig();

        Config.initConfig(this.getConfig());

        initListeners();
        initAFKTimers();
    }

    private void initListeners() {
        this.getServer().getPluginManager().registerEvents(new PlayerMoveListener(), this);
    }

    public void onDisable() {
        AFKTimer.clear();
    }

    public static SMCAFK getInstance() {
        return instance;
    }

    public void initAFKTimers() {
        getServer().getOnlinePlayers().stream().forEach(AFKTimer::new);
    }

}
