package com.cragon.mcw

import com.cragon.mcw.manager.CommandManager
import com.cragon.mcw.manager.EventManager
import com.cragon.mcw.manager.SkillBase
import com.cragon.mcw.manager.SkillManager
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class MCW: JavaPlugin() {
    companion object {
        lateinit var instance: MCW
    }
    override fun onEnable() {
        instance = this
        getCommand("mcw")!!.setExecutor(CommandManager())
        SkillBase.initSkillBase(this)
        SkillManager
        Bukkit.getPluginManager().registerEvents(EventManager(), this)
    }

    override fun onDisable() {

    }
}