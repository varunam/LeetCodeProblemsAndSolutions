fun main() {
    val stringOne = "anagram"
    val stringTwo = "nagrama"

    print(".isValidAnagram? ${isValidAnagram(stringOne, stringTwo)}")
}

fun isValidAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val charArray = s.toCharArray()
    val charMap = hashMapOf<Char, Int>()
    for (char in charArray) {
        charMap[char] = charMap.getOrDefault(char, 0) + 1
    }
    val charArrayTwo = t.toCharArray()
    for (char in charArrayTwo) {
        if (charMap.contains(char)) {
            val value = charMap.getOrDefault(char, 0)
            if (value > 1) {
                charMap[char] = value - 1
            } else {
                charMap.remove(char)
            }
        }
    }
    return charMap.isEmpty()
}