object Bob {
    fun hey(input: String): String {
        val cleanInput = input.trim()
        val nothing = cleanInput.isBlank()
        val letters = """^.*[A-Za-z].*$""".toRegex().containsMatchIn(cleanInput)
        val shouting = letters && """^[^a-z]*$""".toRegex().containsMatchIn(cleanInput)
        val question = cleanInput.endsWith('?')

        return if(nothing) {
            "Fine. Be that way!"
        } else if (shouting && question) {
            "Calm down, I know what I'm doing!"
        } else if (shouting) {
            "Whoa, chill out!"
        } else if (question) {
            "Sure."
        } else {
            "Whatever."
        }
    }
}
