import java.lang.StringBuilder

class BottlesA {
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
        return "${ if(n == 0) "No more" else n} bottle${ if (n != 1) "s" else  ""}" +
            " of beer on the wall, " +
            "${if(n == 0) "no more" else n} bottle${if (n != 1) "s" else ""} of beer.\n" +
            "${if(n > 0) "Take ${if(n > 1) "one" else "it"} down and pass it around" else "Go to the store and buy some more"}, " +
            "${if((n-1) < 0)  99 else if(n-1 == 0) "no more" else n-1} bottle${if (n-1 != 1) "s" else  ""}"+
            " of beer on the wall.\n"
    }
}