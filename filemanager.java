package me.inamine.ChatFilter;
 
import java.io.File;
 
import org.bukkit.configuration.file.YamlConfiguration;
 
public class FileManager {
 
    private static YamlConfiguration msg;
   
    public static void checkFiles(){
        if(!Main.getInst().getDataFolder().exists()){
            Main.getInst().getDataFolder().mkdir();
        }
        if(!new File(Main.getInst().getDataFolder(), "config.yml").exists()){
            Main.getInst().saveDefaultConfig();
        }
        File m = new File(Main.getInst().getDataFolder(), "messages.yml");
        if(!m.exists()){
            Main.getInst().saveResource("messages.yml", true);
        }
        msg = YamlConfiguration.loadConfiguration(m);
    }
   
    public static YamlConfiguration getMsg(){
        return msg;
    }
 
}