package com.coldfire.cpe1cbot

class SwearDetector {

    // TODO decouple and incorporate leet
    fun hasSwear(text: String?): Boolean {
        return if (text.isNullOrBlank()) false
        else Regex("(y([a@])w[a@]|p[0o][t+][a@])").containsMatchIn(text)
    }
}