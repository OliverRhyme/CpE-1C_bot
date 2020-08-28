package com.coldfire.cpe1cbot

class SwearDetector(swearList: List<String>) {

    private val swearRegex: Regex

    init {
        swearRegex = getProcessedRegex(swearList)
    }

//    private fun getProcessedSwearList(): List<String> {
//
//        val tempList = mutableListOf<String>()
//
//        for (swear in Constants.swearList) {
//
//            val tempWord = StringBuilder()
//
//            for (s in swear) {
//
//                val converted = Constants.leetMap.getValue(s)
//
//                if (converted.length > 1) tempWord.append("[$converted]")
//                else tempWord.append(s)
//
//            }
//
//            tempList.add(tempWord.toString())
//        }
//
//        return tempList
//    }


    private fun getProcessedRegex(swearList: List<String>): Regex {
//        val swearList = getProcessedSwearList()
//        val swearList = Constants.swearList

        val regexPattern = swearList.joinToString(
            prefix = "(",
            separator = "|",
            postfix = ")",
            transform = {
                val tempWord = StringBuilder()

                for (s in it) {

                    val converted = Constants.leetMap.getValue(s)

                    if (converted.length > 1) tempWord.append("[$converted]")
                    else tempWord.append(s)

                }
                return@joinToString tempWord
            }
        )
        return regexPattern.toRegex()


    }

    // TODO decouple and incorporate leet
    fun hasSwear(text: String?): Boolean {
        return if (text.isNullOrBlank()) false
        else swearRegex.containsMatchIn(text)
    }
}