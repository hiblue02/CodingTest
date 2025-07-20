package level1

import kotlin.test.Test
import kotlin.test.assertEquals

class Level1Test {

    @Test
    fun `없는 숫자 더하기`() {
    }


    companion object {
        val intArray = setOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
    }

    fun 없는_숫자_더하기(numbers: IntArray): Int {
        return (intArray - numbers.toSet()).sum()
    }

    fun 최소_직사각형(sizes: Array<IntArray>): Int {
        var width = 0
        var height = 0
        for (it in sizes) {
            val width_temp = if (it[0] >= it[1]) it[0] else it[1]
            val heightTemp = if (it[0] > it[1]) it[1] else it[0]

            if (width_temp > width) width = width_temp
            if (heightTemp > height) height = heightTemp
        }

        return width * height
    }

    fun 숫자_짝궁(X: String, Y: String): String {
        val countX = IntArray(10)
        val countY = IntArray(10)
        X.forEach { countX[it.digitToInt()]++ }
        Y.forEach { countY[it.digitToInt()]++ }

        var resultString = StringBuilder()
        for (digit in 9 downTo 0) {
            val repeatCount = minOf(countX[digit], countY[digit])
            repeat(repeatCount) { resultString.append(digit) }
        }
        return when {
            resultString.isBlank() -> "-1"
            resultString.all { it == '0' } -> "0"
            resultString.all { it == '0' } -> "0"
            else -> resultString.toString()
        }

    }

    @Test
    fun `숫자_짝궁_Test1`() {
//        assertEquals("-1", 숫자_짝궁("100", "2345") )
//        assertEquals("0", 숫자_짝궁("100", "203045") )
        assertEquals("522", 숫자_짝궁("5525", "1255"))
    }
}


