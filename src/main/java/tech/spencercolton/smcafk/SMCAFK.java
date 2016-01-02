package tech.spencercolton.smcafk;

import org.bukkit.plugin.java.JavaPlugin;
import tech.spencercolton.smcafk.Listeners.PlayerFishListener;
import tech.spencercolton.smcafk.Listeners.PlayerJoinListener;
import tech.spencercolton.smcafk.Listeners.PlayerMoveListener;
import tech.spencercolton.smcafk.Listeners.PlayerQuitListener;
import tech.spencercolton.smcafk.Scheduler.AFKWarn;
import tech.spencercolton.smcafk.Util.AFKManager;
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
        this.getServer().getPluginManager().registerEvents(new PlayerQuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
    }

    public void onDisable() {
        AFKManager.clear();
    }

    public static SMCAFK getInstance() {
        return instance;
    }

    public void initAFKTimers() {
        getServer().getOnlinePlayers().stream().forEach(AFKWarn::new);
    }

}
