package com.coldfire.cpe1cbot

import java.util.*

object BotMessages {
    val creditsMessage = """
                        This bot is written by:
                        
                        Oliver Rhyme G. Añasco
                        
                        📧 oliverrhyme.anasco@g.msuiit.edu.ph
                        <a href = "https://fb.me/oliver.rhyme">Facebook</a>
                        <a href="tg://user?id=640358656">Telegram</a>
                        <a href="https://github.com/OliverRhyme">Github</a>
                        
                        Leomar T. Villaruel
                        
                        📧 leomart.villaruel@gmail.com
                        <a href = "https://fb.me/leomar.villareal.1">Facebook</a>
                        <a href="tg://user?id=1302941940">Telegram</a>
                        <a href="https://github.com/LeomarVillaruel">Github</a>

                        
                        100% written in Kotlin with 💖
                        
                        Library used:
                        <a href = "https://github.com/kotlin-telegram-bot/kotlin-telegram-bot">Kotlin Telegram Bot</a>
                        
                        CpE-1C Telegram Bot V${getVersion()}

                    """.trimIndent()

    val startMessage = """
                        Welcome this bot will answer you FAQ
                        please refer to commands you can try below
                        
                            """.trimIndent()

    val announcementMessage = """
                                        There are currently no announcement please stay tuned for updates.
                        
                                    """.trimIndent()

    val newMemberMessage = """
                                Welcome to CpE-1C group chat <a href="tg://user?id=%d">%s</a>.
                                Please adhere to this group chat rules and regulation.
                                
                                """.trimIndent()
    val adviceMessage = """
                                Drink 8 glass of water.
                                Stay hydrated.
    """.trimIndent()
    const val swearMessage = "Don't say bad words God is watching you"
    const val morningMessage = "Goodmorning %s!! Start your day with a cup of coffee!"

    private fun getVersion(): String {
        val properties = Properties()
        properties.load(javaClass.classLoader.getResourceAsStream("version.properties"))

        return properties.getProperty("version")
    }
}