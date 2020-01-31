package com.cragon.mcw

import com.cragon.mcw.manager.CommandManager
import com.cragon.mcw.manager.EventManager
import com.cragon.mcw.manager.SkillBase
import com.cragon.mcw.manager.SkillManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class MCW: JavaPlugin() {
    override fun onEnable() {
        getCommand("mcw")!!.setExecutor(CommandManager())
        SkillBase.initSkillBase(this)
        Bukkit.getPluginManager().registerEvents(EventManager(), this)
    }

    override fun onDisable() {

    }
}