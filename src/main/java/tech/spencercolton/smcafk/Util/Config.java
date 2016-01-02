package tech.spencercolton.smcafk.Util;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.File;

/**
 * @author Spencer Colton
 */
public class Config {

    private static FileConfiguration f;

    public static void initConfig(FileConfiguration g) {
        f = g;
    }

    public static Integer getInt(String path) {
        return (Integer)f.get(path);
    }

}
