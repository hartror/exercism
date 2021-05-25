fun transcribeToRna(dna: String): String {
    return dna.toCharArray()
        .map {
            when (it) {
                'G' -> 'C'
                'C' -> 'G'
                'T' -> 'A'
                'A' -> 'U'
                else -> ' '
            }
        }
        .joinToString("")
}


