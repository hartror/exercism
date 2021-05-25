class DiamondPrinter {

    fun printToList(c: Char) : List<String> {
        return listOf(('A'..c).toList(), (c - 1 downTo 'A').toList())
            .flatten()
            .map {
                when (it) {
                    'A' -> " ".repeat(c - 'A') + "A" + " ".repeat(c - 'A')
                    else -> " ".repeat(c - it) +
                            it.toString() +
                            " ".repeat( (c - 'A')*2 - (c - it)*2 - 1) +
                            it.toString() +
                            " ".repeat(c - it)
                }
            }
    }
}
