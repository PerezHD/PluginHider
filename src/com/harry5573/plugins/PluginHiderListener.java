/*Copyright (C) Harry5573 2013-14

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.*/

package com.harry5573.plugins;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

/**
 *
 * @author Harry5573
 */
public class PluginHiderListener implements Listener {

    public static PluginHider plugin;
    
    public PluginHiderListener(PluginHider instance) {
        this.plugin = instance;
    }
    
    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onCommandProcess(PlayerCommandPreprocessEvent evt) {
        String commandpre = evt.getMessage();     
        String[] finalcommand = commandpre.split(" ");
        String command = finalcommand[0].replaceAll("/", "");      
        Player player = evt.getPlayer();
        
        for (String message : plugin.getConfig().getStringList("blockedcmds")) {

            if (command.equalsIgnoreCase(message)) {
                player.sendMessage(plugin.hidemessage);
                evt.setCancelled(true);
                return;
            }
            
        }
    }
}
