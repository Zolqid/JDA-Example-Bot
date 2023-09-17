package org.example.config;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import org.example.Main;
import org.example.utils.file.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ConfigManager {

    // Init app objects
    public FileUtils fileUtils = new FileUtils();

    // Init config system
    public void init() {
        Main.getLogger.info("CONFIG MANAGER - INITIALIZING...");
        if (!fileUtils.checkFileExist("config.yml")) {

            // Print info to console
            Main.getLogger.info("Creating default config file...");

            // Create config file
            createConfigFile();

        } else {
            // Print info
            Main.getLogger.info("Config file is successfully loaded!");
        }
    }


    // Create config file if not exist
    public void createConfigFile() {
        if (!fileUtils.checkFileExist("config.yml")) {

            // Create config file
            fileUtils.createFile("config.yml");

            // Get config resource
            InputStream is = getClass().getClassLoader().getResourceAsStream("config-sample.yml");

            // Read and write data to config file from resources
            try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);
                 BufferedReader reader = new BufferedReader(streamReader)) {
                String line;
                while ((line = reader.readLine()) != null) {
                    try(PrintWriter output = new PrintWriter(new FileWriter("config.yml",true))) {
                        output.printf("%s\r\n", line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Print msg if file created
            if (fileUtils.checkFileExist("config.yml")) {
                Main.getLogger.info("Default config file created, please check config and run app again");
                System.exit(0);
            } else {
                Main.getLogger.info("Error creating default config, try reinstall application or check config manager");
                System.exit(0);
            }
        }
    }

    // Get value from config file by name
    public String getConfigValue(String value) {

        YamlReader reader = null;
        try {
            reader = new YamlReader(new FileReader("config.yml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Object object = null;
        try {
            object = reader.read();
        } catch (YamlException e) {
            e.printStackTrace();
        }
        Map map = (Map)object;

        return (String) map.get(value);
    }

    // Get boolean value from config
    public boolean getConfigBolValue(String value) {
        if (getConfigValue(value).equalsIgnoreCase("true")) {
            return true;
        } else if (getConfigValue(value).equalsIgnoreCase("false")) {
            return false;
        } else {
            Main.getLogger.info("Error '" + value + "' is not boolean value!");
            System.exit(0);
        }
        return false;
    }

    // Get app name
    public String getBotName() {

        String name = getConfigValue("BotName");

        if (name == null) {
            name = "BOT";
        }

        return name;
    }
}

