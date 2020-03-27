package me.inamine.ChatFilter;
 
import org.bukkit.entity.Player;
 
import net.md_5.bungee.api.ChatColor;
 
public class Tools
{
    public void sendMsg(Player player, String msgKey)
    {
        String msgNoColor = FileManager.getMsg().getString(msgKey);
        String msg = ChatColor.translateAlternateColorCodes('&', msgNoColor);
        player.sendMessage(msg);
        return;
    }
       
}