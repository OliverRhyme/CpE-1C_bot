package com.coldfire.cpe1cbot

import com.elbekD.bot.Bot

fun main(args: Array<String>) {
    val token = "1360445525:AAHqvf4oHVFf2sw1GBvqJCg22BOBS95JGF0"
    val username = "@OliverRhyme_bot"
    val bot = Bot.createPolling(username, token)
    bot.onCommand("/start") { msg, _ ->
        bot.sendMessage(msg.chat.id, "Hello mga bobo!")

    }

    bot.onMessage {
        if (it.text!!.contentEquals("kinsay pro?")) {
            bot.sendMessage(it.chat.id, "Si oliver opcors alang man si leomar na talapungo mana")
        }

    }
    bot.onCommand("/weak") {msg, _ ->
        bot.sendMessage(msg.chat.id, "Si Leomar")
    }
    bot.onCommand("/master") {msg, _ ->
        bot.sendMessage(msg.chat.id, "Si Oliver")
    }
    bot.start()
}