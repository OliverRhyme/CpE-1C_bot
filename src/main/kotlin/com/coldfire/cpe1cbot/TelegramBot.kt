package com.coldfire.cpe1cbot

import com.elbekD.bot.Bot
import java.util.regex.Pattern


fun main(args: Array<String>) {
    val token = "1360445525:AAHqvf4oHVFf2sw1GBvqJCg22BOBS95JGF0"
    val username = "@OliverRhyme_bot"
    val bot = Bot.createPolling(username, token)
    bot.onCommand("/start") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Hello mga maderpaker!")
    }
    bot.onCommand("/weak") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Si Leomar")
    }
//    bot.onCommand("/Leomar? unsay ass?ignment") {msg, _ ->
//        bot.sendMessage(msg.chat.id, "SIBAT PA YAWAA KA!")
//    }
    bot.onMessage {
//        val pattern: Pattern = Pattern.compile("\\b(yawa)\\b")
        val matcher = it.text?.toLowerCase()
        when (matcher) {
//            "yawa", "pota" -> {
//                bot.sendMessage(it.chat.id, "Don't say bad words God is watching you")
//            }
            "goodmorning", "ohaiyo" -> {
                bot.sendMessage(it.chat.id, "Goodmorning!! Start your day with a cup of coffee!")
            }
            else -> {
                matcher?.let { swear ->
                    if (Regex("\\b(yawa|pota)\\b").containsMatchIn(swear)) {
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


