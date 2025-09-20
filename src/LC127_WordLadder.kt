fun main() {
    val wordsList = listOf("hot", "dog", "dot", "lot", "log", "cog")
    println(ladderLength("hit", "cog", wordsList))
}

private fun ladderLength(firstWord: String, lastWord: String, wordsList: List<String>): Int {
    val wordSet = wordsList.toHashSet()
    if (wordSet.contains(lastWord).not()) return 0

    val queue = ArrayDeque<Pair<String, Int>>()
    queue.add(Pair(firstWord, 1))

    while (queue.isNotEmpty()) {
        val (word, length) = queue.removeFirst()
        if (word == lastWord) return length

        val wordArray = word.toCharArray()
        for (i in wordArray.indices) {
            val originalChar = wordArray[i]
            for (c in 'a'..'z') {
                wordArray[i] = c
                val newWord = String(wordArray)
                if (newWord in wordSet) {
                    queue.add(Pair(newWord, length + 1))
                    wordSet.remove(newWord)
                }
            }
            wordArray[i] = originalChar
        }
    }
    return 0
}