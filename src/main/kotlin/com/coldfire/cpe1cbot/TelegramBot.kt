package com.coldfire.cpe1cbot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.extensions.filters.Filter


fun main() {
    val token = "1389196479:AAECgubxkPmS8bf3QKn-WeGnuf3STjd2TFw"

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

                    """.trimIndent()

    val bot = bot {
        this.token = token

        dispatch {

            command("credits") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it, creditsMessage,
                        disableWebPagePreview = true,
                        parseMode = ParseMode.HTML
                    )
                }
            }

            command("start") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it, """
                        Welcome this bot will answer you FAQ
                        please refer to commands you can try below
                        
                    """.trimIndent()
                    )
                }
            }
            message(Filter.Text and Filter.Group) { bot, update ->

                val message = update.message ?: return@message

                when (val matcher = message.text?.toLowerCase()) {
                    "goodmorning", "ohaiyo" -> {
                        bot.sendMessage(message.chat.id, "Goodmorning!! Start your day with a cup of coffee!")
                    }
                    else -> {
                        matcher?.let { swear ->
                            if (Regex("(y([a@])w[a@]|p[0o][t+][a@])").containsMatchIn(swear)) {
                                bot.sendMessage(message.chat.id, "Don't say bad words God is watching you")
                            }
                        }

                    }
                }
            }

        }
    }
    bot.startPolling()

}



