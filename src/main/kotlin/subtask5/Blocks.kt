package subtask5

import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.reflect.KClass

class Blocks {

    fun getData(blockA: Array<*>, blockB: KClass<*>): Any {
        return when(blockB) {
            String::class -> blockA.filterIsInstance<String>().reduce { arg1, arg2 -> arg1 + arg2}
            Int::class -> blockA.filterIsInstance<Int>().reduce { arg1, arg2 -> arg1 + arg2}
            LocalDate::class -> (blockA.filterIsInstance<LocalDate>().max() as LocalDate)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"))
            else -> throw NotImplementedError("Not implemented")
        }
    }
}
