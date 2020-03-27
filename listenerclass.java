package me.inamine.ChatFilter;
 
import java.util.List;
 
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
 
public class ListenerClass implements Listener
{
    Tools t = new Tools();
   
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        Player player = event.getPlayer();
        if (player.hasPermission("filter.bypass")) return;
       
        String message = event.getMessage();
        String[] words = message.split(" ");
       
        List<String> bannedWords = Main.getInst().getConfig().getStringList("banned-words");
        List<String> veryBadWords = Main.getInst().getConfig().getStringList("very-bad-words");
       
        for (String word : words)
        {
            for (String bWord : bannedWords)
            {
                if (word.equalsIgnoreCase(bWord))
                {
                    event.setCancelled(true);
                    t.sendMsg(player, "output.bad-word");
                    return;
                }
               
            }
        }
       
        for (String vbWord : veryBadWords)
        {
            if (message.contains(vbWord))
            {
                event.setCancelled(true);
                t.sendMsg(player, "output.bad-word");
                return;
            }
        }
       
    }
   
 
}
