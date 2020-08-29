package com.coldfire.cpe1cbot

import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.extensions.filters.Filter


fun main() {

    val swearDetector = SwearDetector(Constants.swearList)

    val bot = bot {
        this.token = Constants.TOKEN

        dispatch {

            command("credits") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it,
                        BotMessages.creditsMessage,
                        disableWebPagePreview = true,
                        parseMode = ParseMode.HTML
                    )
                }
            }

            command("start") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it, BotMessages.startMessage
                    )
                }
            }

            command("announcement") { bot, update ->
                update.message?.chat?.id?.let {
                    bot.sendMessage(
                        it, BotMessages.announcementMessage
                    )
                }
            }
            message(Filter.Text and Filter.Group) { bot, update ->

                val message = update.message ?: return@message

                when (message.text?.toLowerCase()) {
                    "goodmorning", "ohayo" -> {
                        bot.sendMessage(
                            message.chat.id, String.format(
                                BotMessages.morningMessage, message.from?.firstName ?: "po"
                            )
                        )
                    }
                    else -> {
                        if (swearDetector.hasSwear(message.text)) {
                            bot.sendMessage(message.chat.id, BotMessages.swearMessage)
                        }
                    }
                }
            }

            message(Filter.Group and Filter.Custom { newChatMember != null }) { bot, update ->
                val message = update.message ?: return@message

                message.newChatMember?.let {
                    if (it.isBot) return@let

                    bot.sendMessage(
                        message.chat.id, String.format(
                            BotMessages.newMemberMessage, it.id, "${it.firstName} ${it.lastName}"
                        ),
                        parseMode = ParseMode.HTML
                    )
                }
            }

        }
    }
    bot.startPolling()

}



