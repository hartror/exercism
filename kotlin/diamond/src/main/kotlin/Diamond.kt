class DiamondPrinter {

    fun printToList(c: Char) : List<String> {
        return (('A'..c) + (c - 1 downTo 'A'))
            .map {
                when (it) {
                    'A' -> "${" ".repeat(c - 'A')}A${" ".repeat(c - 'A')}"
                    else -> " ".repeat(c - it) +
                            it +
                            " ".repeat( (c - 'A') * 2 - (c - it) * 2 - 1) +
                            it +
                            " ".repeat(c - it)
                }
            }
    }
}
