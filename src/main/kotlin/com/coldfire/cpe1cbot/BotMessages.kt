package com.coldfire.cpe1cbot

import java.util.*

object BotMessages {
    val creditsMessage by lazy {
        """
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
    }

    val startMessage by lazy {
        """
        Welcome this bot will answer you FAQ
        please refer to commands you can try below
                        
                        
        """.trimIndent()
    }

    val announcementMessage by lazy {
        """
        There are currently no announcement please stay tuned for updates.
                        
        """.trimIndent()
    }

    val newMemberMessage by lazy {
        """
        Welcome to CpE-1C group chat <a href="tg://user?id=%d">%s</a>.
        Please adhere to this group chat rules and regulation.
                                
        """.trimIndent()
    }
    val adviceMessage by lazy {
        """
        Drink 8 glass of water.
        Stay hydrated and don't forget to always smile :)
        """.trimIndent()
    }

    val swearMessage by lazy { "Don't say bad words God is watching you" }

    val morningMessage by lazy { "Goodmorning %s!! Start your day with a cup of coffee!" }

    private fun getVersion(): String {
        val properties = Properties()
        properties.load(javaClass.classLoader.getResourceAsStream("version.properties"))

        return properties.getProperty("version")
    }
}