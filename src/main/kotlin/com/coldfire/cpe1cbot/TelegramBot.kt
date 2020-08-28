package com.coldfire.cpe1cbot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.extensions.filters.Filter

fun main() {
    val token = "1360445525:AAHqvf4oHVFf2sw1GBvqJCg22BOBS95JGF0"
    val username = "@OliverRhyme_bot"

    val bot = bot {
        this.token = token

        dispatch {
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
                            if (Regex("\\b(y([a@])w[a@]|p[0o][t+][a@])\\b").containsMatchIn(swear)) {
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



