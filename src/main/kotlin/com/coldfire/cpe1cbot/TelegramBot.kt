package com.coldfire.cpe1cbot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.extensions.filters.Filter


fun main() {

    val swearDetector = SwearDetector()


    val bot = bot {
        this.token = Constants.TOKEN

        dispatch {

            command("credits") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it, BotMessages.creditsMessage,
                        disableWebPagePreview = true,
                        parseMode = ParseMode.HTML
                    )
                }
            }

            command("start") { bot, update ->
                // TODO migrate to BotMessages
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

                when (message.text?.toLowerCase()) {
                    "goodmorning", "ohaiyo" -> {
                        bot.sendMessage(message.chat.id, "Goodmorning!! Start your day with a cup of coffee!")
                    }
                    else -> {
                        if (swearDetector.hasSwear(message.text)) {
                            bot.sendMessage(message.chat.id, "Don't say bad words God is watching you")
                        }
                    }
                }
            }

        }
    }
    bot.startPolling()

}



