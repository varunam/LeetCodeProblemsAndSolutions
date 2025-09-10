//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val array = arrayOf(1,2,3,4)
    val result = containsDuplicate(array)
    println(result)
}

fun containsDuplicate(array: Array<Int>): Boolean {
    val hashMap = hashMapOf<Int, Boolean>()
    for(i in array) {
        if(hashMap.contains(i)){
            return true
        }
        hashMap[i] = true
    }
    return false
}