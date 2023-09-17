package org.example;

import org.example.config.ConfigManager;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;;

public class Main {
    public static ConfigManager configManager = new ConfigManager();
    public static Logger getLogger = LoggerFactory.getLogger("jda-examplebot");
    public static void main(String[] args) {
        configManager.init();

        String token = configManager.getConfigValue("token");
        JDABuilder builder = JDABuilder.createDefault(token);
        builder.setActivity(Activity.watching("JDA - Example Bot"));
        builder.build();
    }

}