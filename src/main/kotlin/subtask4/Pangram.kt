package subtask4

import java.util.regex.Pattern

class Pangram {

    private val vowels = listOf('a', 'e', 'i', 'o', 'u', 'y')
    private val consonants = listOf('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z')
    private val counterSeparator = "_"

    fun getResult(inputString: String): String {
        return transform(inputString, isPangram(inputString))
    }

    private fun transform(inputString: String, isPanagram: Boolean):String {
        val lettersToTransform = if (isPanagram) vowels else consonants
        val listOfWords = inputString.trim().split(Pattern.compile("[ \n\t\r]+")).toMutableList()
        for (i in listOfWords.indices) {
            var lettersCounter = 0
            val word = listOfWords[i].toCharArray()
            if (word.isNotEmpty()) {
                for (j in word.indices) {
                    if (lettersToTransform.contains(word[j].toLowerCase())) {
                        word[j] = word[j].toUpperCase()
                        lettersCounter++
                    }
                }

                listOfWords[i] = "$lettersCounter$counterSeparator${word.joinToString(separator = "")}"
            }
        }
        return listOfWords.sortedWith(compareBy {it.substringBefore(counterSeparator).toInt()})
            .joinToString(separator = " ").replace(counterSeparator,"")
    }

    private fun isPangram(inputString: String):Boolean {
        val text = inputString.toLowerCase()
        ('a'..'z').forEach { letter ->
            if(letter !in text){
                return false
            }
        }
        return true
    }
}
