import java.lang.StringBuilder

class BottlesB {
    private val noMore = { verse: Verse ->
        "No more bottles of beer on the wall, " +
        "no more bottles of beer.\n" +
        "Go to the store and buy some more, " +
        "99 bottles of beer on the wall.\n"
    }

    private val lastOne = { verse: Verse ->
        "1 bottle of beer on the wall, " +
        "1 bottle of beer.\n" +
        "Take it down and pass it around, " +
        "no more bottles of beer on the wall.\n"
    }

    private val penultimate = { verse: Verse ->
        "2 bottles of beer on the wall, " +
        "2 bottles of beer.\n" +
        "Take one down and pass it around, " +
        "1 bottle of beer on the wall.\n"
    }

    private val default = { verse: Verse ->
        "${verse.number} bottles of beer on the wall, " +
        "${verse.number} bottles of beer.\n" +
        "Take one down and pass it around, " +
        "${verse.number - 1} bottles of beer on the wall.\n"
    }

    fun song(): String {
        return verses(99,0)
    }

    private fun verses(hi: Int, lo: Int): String {
        val sb = StringBuilder()

        for (n in (lo..hi).reversed()) {
            sb.append(verse(n))
            sb.append("\n")
        }

        return sb.toString()
    }

    private fun verse(n: Int): String {
        return when(n) {
            0 -> Verse(0, noMore).text()
            1 -> Verse(1, lastOne).text()
            2 -> Verse(2, penultimate).text()
            else -> Verse(n, default).text()
        }
    }
}

class Verse(val number: Int, private val lyrics: (Verse) -> String) {
    fun text(): String {
        return lyrics(this)
    }
}