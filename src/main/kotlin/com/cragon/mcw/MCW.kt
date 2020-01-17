package com.cragon.mcw

import com.cragon.mcw.manager.CommandManager
import com.cragon.mcw.manager.EventManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class MCW : JavaPlugin() {
    override fun onEnable() {
        val cm = CommandManager()
        getCommand("mcw")!!.setExecutor(cm)
        Bukkit.getPluginManager().registerEvents(EventManager(), this)
        // Plugin startup logic
    }

    override fun onDisable() { // Plugin shutdown logic
    }
}