object PigLatin {

    val consonantsStr = "bcdfghjklmnpqrstvwxyz"

    val consonants: Array<String> =
        arrayOf("thr", "sch", "ch", "qu", "th") + consonantsStr.toCharArray().map { it.toString() }
            .toTypedArray()
    val vowels = arrayOf("yt", "xr", "a", "e", "i", "o", "u")

    fun translateIfMatches(
        matcher: (phrase: String) -> Boolean,
        translator: (phrase: String) -> String
    ): (phrase: String) -> String? {
        return { phrase: String -> if (matcher(phrase)) translator(phrase) else null }
    }

    val vowelStrategies =
        vowels.map { translateIfMatches({ phrase -> phrase.startsWith(it) }, { phrase -> phrase + "ay" }) }
    val consonantStrategies = consonants.map {
        translateIfMatches(
            { phrase -> phrase.startsWith(it) },
            { phrase -> phrase.substring(it.length) + it + "ay" })
    }

    val consonantQuRegex = Regex("^[bcdfghjklmnpqrstvwxyz]qu.*$")
    val consonantClusterYRegex = Regex("^([bcdfghjklmnpqrstvwxyz]{2,})(y.*)")

    val miscStrategies =
        // word starting with a consonant sound followed by "qu"
        arrayOf(
            translateIfMatches(
                { phrase -> consonantQuRegex.matches(phrase) },
                { phrase -> phrase.substring(3) + phrase.substring(0..2) + "ay" }),
            translateIfMatches(
                { phrase -> consonantClusterYRegex.matches(phrase) },
                { phrase -> consonantClusterYRegex.replace(phrase, "$2$1ay") })
        )

    val translationStrategies = (miscStrategies + vowelStrategies + consonantStrategies).asSequence()

    fun translate(phrase: String): String {
        return phrase.split(" ").map { p: String -> translationStrategies.map { it(p) }.filterNotNull().firstOrNull() }
            .filterNotNull().reduce { acc: String, s: String -> acc + " " + s }
    }
}
