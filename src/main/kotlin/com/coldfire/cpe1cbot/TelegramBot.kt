package com.coldfire.cpe1cbot

import com.elbekD.bot.Bot
import com.elbekD.bot.server


fun main() {
    val token = "1360445525:AAHqvf4oHVFf2sw1GBvqJCg22BOBS95JGF0"
    val username = "@OliverRhyme_bot"
    val bot = Bot.createWebhook(username, token) {
        this.url = "https://cpe1c-bot.herokuapp.com/"
        server {
            val portNumber = System.getenv("PORT")
            portNumber?.let {
                port = Integer.parseInt(portNumber)
            }
            this.host = "localhost"
        }
    }


    bot.onCommand("/start") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Hello mga maderpaker!")
    }
    bot.onCommand("/weak") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Si Leomar")
    }
    bot.onMessage {
        when (val matcher = it.text?.toLowerCase()) {
            "goodmorning", "ohaiyo" -> {
                bot.sendMessage(it.chat.id, "Goodmorning!! Start your day with a cup of coffee!")
            }
            else -> {
                matcher?.let { swear ->
                    if (Regex("\\b(y([a@])wa|p[0o][t+][a@])\\b").containsMatchIn(swear)) {
                        bot.sendMessage(it.chat.id, "Don't say bad words God is watching you")
                    }
                }

            }
        }
    }

    bot.onCommand("/master") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Si Oliver and Leomar")
    }
    bot.start()
}



