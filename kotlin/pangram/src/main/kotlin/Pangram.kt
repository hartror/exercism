object Pangram {

    private const val ALPHABET_LENGTH = 26

    fun isPangram(input: String): Boolean {
        return input.toLowerCase().filter{ it.isLetter() }.toList().toSet().size == ALPHABET_LENGTH
    }
}
