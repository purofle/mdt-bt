package com.github.purofle.mdtbt.bot

import net.mamoe.mirai.console.command.CommandManager.INSTANCE.register
import net.mamoe.mirai.console.permission.PermissionId
import net.mamoe.mirai.console.permission.PermissionService
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.console.plugin.loader.PluginLoadException
import java.io.File

object MainBot : KotlinPlugin(
    JvmPluginDescription(
        id = "com.github.purofle.mdtbt.bot",
        version = "1.0.0",
    ) {
        name("mdtbt")
    }
) {

    override fun onEnable() {
        if (!File("../Mindustry").isDirectory) {
            throw PluginLoadException("找不到mindustry源码")
        }
        MdtbtCommand.register()
    }
}
