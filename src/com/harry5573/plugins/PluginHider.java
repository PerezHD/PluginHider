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

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Harry5573
 */
public class PluginHider extends JavaPlugin {

    public static PluginHider plugin;
    
    public String hidemessage;

    @Override
    public void onEnable() {
        plugin = this;
        
        Bukkit.getServer().getPluginManager().registerEvents(new PluginHiderListener(this), this);
        this.loadConfigs();
        this.log("Enabled");
    }

    @Override
    public void onDisable() {
        this.log("Disabled");
    }

    public void log(String msg) {
        this.getLogger().info(msg);
    }

    public String translateToColorCode(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
    
    public void loadConfigs() {
        this.saveDefaultConfig();
        
        this.hidemessage = this.translateToColorCode(this.getConfig().getString("hidemessage"));
    }
}
