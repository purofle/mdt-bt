package com.github.purofle.mdtbt.bot

import arc.files.Fi
import mindustry.game.Schematics
import net.mamoe.mirai.console.command.CommandSender
import net.mamoe.mirai.console.command.SimpleCommand
import net.mamoe.mirai.utils.ExternalResource.Companion.uploadAsImage
import java.awt.image.BufferedImage
import java.io.File
import java.util.*
import javax.imageio.ImageIO

object MdtbtCommand : SimpleCommand(
    MainBot, "bt"
) {

    @Handler
    suspend fun CommandSender.handle(bt: String) {
        bot?.logger?.info("started ${bt}")
        if (bt.startsWith(ContentHandler.schemHeader)) {
            ContentHandler(MainBot.configFolder)
            val schem = ContentHandler().parseSchematic(bt)
            val preview: BufferedImage = ContentHandler().previewSchematic(schem)
            val sname = schem.name().replace("/", "_").replace(" ", "_")

            File("cache").mkdir()
            val preview_file = File("cache/" + UUID.randomUUID().toString() + ".png")
            Schematics.write(schem, Fi(preview_file))
            ImageIO.write(preview, "png", preview_file)
            user?.let { sendMessage(preview_file.uploadAsImage(it)) }
        }
    }
}
