import java.lang.StringBuilder

class BottlesD {
    fun song(): String {
        return verses(99 ,0)
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
            0 -> "No more bottles of beer on the wall, " +
                "no more bottles of beer.\n" +
                "Go to the store and buy some more, " +
                "99 bottles of beer on the wall.\n"
            1 -> "1 bottle of beer on the wall, " +
                "1 bottle of beer.\n" +
                "Take it down and pass it around, " +
                "no more bottles of beer on the wall.\n"
            2 -> "2 bottles of beer on the wall, " +
                "2 bottles of beer.\n" +
                "Take one down and pass it around, " +
                "1 bottle of beer on the wall.\n"
            else -> "$n bottles of beer on the wall, " +
                    "$n bottles of beer.\n" +
                    "Take one down and pass it around, " +
                    "${n-1} bottles of beer on the wall.\n"
        }
    }
}