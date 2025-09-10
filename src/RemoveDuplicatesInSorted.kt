fun main() {
    val array = intArrayOf(1, 2, 2, 3, 3, 6, 6, 9, 9, 10)
    val k = removeDuplicates(array)
    println(k)
    array.forEach {
        print(it)
    }
}

fun removeDuplicates(array: IntArray): Int {
    var index = 1
    for (i in 1 until array.size) {
        if (array[i] != array[i - 1]) {
            array[index] = array[i]
            index++
        }
    }
    return index
}