import java.lang.StringBuilder

class BottlesC {
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
        return Round(n).toString()
    }
}

class Round(var bottles: Int) {
    private val beer = "beer"
    private val onWall = "on the wall"
    private val buyNewBeer = "Go to the store and buy some more"

    override fun toString(): String {
        return challenge() + response()
    }

    private fun challenge(): String {
        return bottleOfBeer().capitalize() + " " + onWall + ", " + bottleOfBeer() + ".\n"
    }

    private fun response(): String {
        return storeOrTake() + ", " + bottleOfBeer() + " " + onWall + ".\n"
    }

    private fun bottleOfBeer(): String {
        return "${anglicizedBottleCount()} ${pluralizedBottle()} of $beer"
    }

    private fun pluralizedBottle(): String {
        return if (lastBeer()) "bottle" else "bottles"
    }

    private fun anglicizedBottleCount(): String {
        return if (allOut()) "no more" else bottles.toString()
    }

    private fun storeOrTake(): String {
        var ret: String = ""
        if (allOut()) {
            ret = buyNewBeer
            bottles = 99
        } else {
            ret = drinkBeer()
            bottles--
        }

        return ret
    }

    private fun drinkBeer(): String {
        return "Take ${itOrOne()} down and pass it around"
    }

    private fun itOrOne(): String {
        return if (lastBeer()) "it" else "one"
    }

    private fun allOut(): Boolean {
        return bottles == 0
    }

    private fun lastBeer(): Boolean {
        return bottles == 1
    }
}
