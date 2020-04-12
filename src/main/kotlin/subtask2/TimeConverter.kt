package subtask2

class TimeConverter {

    private val numbers = arrayOf(
        "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
        "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen", "twenty", "twenty one",
        "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",
        "twenty nine"
    )
    fun toTextFormat(hour: String, minute: String): String {
        val currentHourWord = numbers[hour.toInt()]
        val nextHourWord = numbers[hour.toInt() + 1]
        val minuteInt = minute.toInt()
        if (minuteInt > 59) {
            return ""
        }
        when(minuteInt) {
            0 -> return "$currentHourWord o' clock"
            15 -> return "quarter past $currentHourWord"
            30 -> return "half past $currentHourWord"
            45 -> return "quarter to $nextHourWord"
        }
        if (minuteInt < 30) {
            return "${numbers[minuteInt]} minutes past $currentHourWord"
        }

        if (minuteInt > 30) {
            return "${numbers[60 - minuteInt]} minutes to $nextHourWord"
        }
        return ""
    }
}
