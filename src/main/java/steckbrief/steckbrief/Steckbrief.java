package steckbrief.steckbrief;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.yaml.snakeyaml.Yaml;
import steckbrief.steckbrief.Commands.getSteckbrief;
import steckbrief.steckbrief.Commands.setSteckbrief;
import steckbrief.steckbrief.Commands.DataHolder;
import java.io.IOException;
import java.io.FileWriter;
import java.io.File;
import java.util.ArrayList;

public final class Steckbrief extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("setSteckbrief").setExecutor(new setSteckbrief());
        getCommand("Steckbrief").setExecutor(new getSteckbrief());

        File file = new File("data.yml");
        if(!(file.exists())) { //falls keine existiert wird eine neue .yml Datei angelegt,
            //die einen Dataholder mit zwei leeren Listen enthält
            Yaml yaml = new Yaml();
            DataHolder dataHolder = new DataHolder(new ArrayList<String[]>(), new ArrayList<String>());
            // Save the data to a .yml file
            try (FileWriter writer = new FileWriter("data.yml")) {
                yaml.dump(dataHolder, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Bukkit.getLogger().info("Steckbrief Initialisiert");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
