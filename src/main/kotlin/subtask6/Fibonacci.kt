package subtask6

class Fibonacci {


    fun productFibonacciSequenceFor(n: Int): IntArray {
        var n0 = 0
        var n1 = 1
        var next = 0
        while (n0*n1 <= n){
            if(n0*n1 == n) {
                return intArrayOf(n0, n1 , 1)
            }
            next = n0 + n1
            n0 = n1
            n1 = next
        }
        return intArrayOf(n0, n1 , 0)
    }
}
