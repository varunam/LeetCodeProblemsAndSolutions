fun main() {
    var startTime = System.currentTimeMillis()
    val n = 45L
    var fib = fib(n)
    var end = System.currentTimeMillis()
    println("Fib of $n is $fib, calculated in ${(end - startTime)} milliseconds")

    startTime = System.currentTimeMillis()
    fib = fibDp(n)
    end = System.currentTimeMillis()
    println("Fib[dp] of $n is $fib, calculated in ${(end - startTime)} milliseconds")
}

fun fib(n: Long): Long {
    if (n <= 1) return n
    return fib(n - 1) + fib(n - 2)
}

fun fibDp(n: Long, map: MutableMap<Long, Long> = mutableMapOf<Long, Long>()): Long {
    if (n <= 1) return n
    if (map.containsKey(n)) return map[n]!!
    val result = fibDp(n - 1, map) + fibDp(n - 2, map)
    map[n] = result
    return result
}