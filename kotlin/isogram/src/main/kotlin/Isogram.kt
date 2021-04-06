object Isogram {

    fun isIsogram(input: String): Boolean {
        val letters = HashSet<Char>()
        for (l in input.toLowerCase().replace(" ", "").replace("-", "")) {
            if (letters.contains(l)) {
                return false
            } else {
                letters.add(l)
            }
        }
        return true
    }
}
