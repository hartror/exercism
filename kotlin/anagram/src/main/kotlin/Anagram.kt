internal fun sortString(str: String): String = str.toCharArray().sorted().joinToString("")

class Anagram(val word: String) {

    val sortedWord = sortString(word.toLowerCase())

    fun match(anagrams: Collection<String>): Set<String> {
        return anagrams
            .filter { it.toLowerCase() != word.toLowerCase() }
            .filter { sortString(it.toLowerCase()) == sortedWord }.toSet()
    }
}
