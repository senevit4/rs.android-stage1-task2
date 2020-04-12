package subtask3

class Abbreviation {

    fun abbreviationFromA(a: String, b: String): String {
        var result = ""
        for(i in a.indices) {
           for (j in b.indices) {
               if(a[i].toUpperCase() == b[j]) {
                   result += a[i].toUpperCase()
               }
           }
        }
        return if(result == b) {
            "YES"
        } else {
            "NO"
        }
    }
}
