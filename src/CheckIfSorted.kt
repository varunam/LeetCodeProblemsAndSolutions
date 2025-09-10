fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Array is sorted? ${isSorted(array)}")
}

fun isSorted(array: IntArray): Boolean {
    for(i in 0 until array.size - 1) {
        if(array[i] > array[i + 1]) return false
    }
    return true
}