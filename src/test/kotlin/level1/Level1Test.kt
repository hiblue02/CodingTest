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

    fun 전국대회선발고사(rank: IntArray, attendance: BooleanArray): Int {

        val rankWithAttendance = rank
            .mapIndexed { index, value -> if (attendance[index]) index to value else null }.filterNotNull()
            .sortedBy { it.second }
        return rankWithAttendance[0].first * 10000 + rankWithAttendance[1].first * 100 + rankWithAttendance[2].first

    }

    fun `문자열 나누기`(s: String):Int {
        var count = 0

        data class Pot(var x: Char = '-', var xCount: Int = 0, var otherCount: Int = 0) {

            fun isEmpty() = x == '-'

        }

        var pot = Pot()

        for (x in s.toCharArray()) {
            if (pot.isEmpty()) pot = Pot(x)
            if (x == pot.x) pot.xCount++ else pot.otherCount++
            if (pot.xCount == pot.otherCount) {
                count++; pot = Pot()
            }
        }

        return if(pot.isEmpty()) count else count+1



    }

    @Test
    fun `전국대회선발고사`() {
//        전국대회선발고사(intArrayOf(3, 7, 2, 5, 4, 6, 1), booleanArrayOf(false, true, true, true, true, false, false))
        `문자열 나누기`("abracadabra")
    }

    @Test
    fun `숫자_짝궁_Test1`() {
//        assertEquals("-1", 숫자_짝궁("100", "2345") )
//        assertEquals("0", 숫자_짝궁("100", "203045") )
        assertEquals("522", 숫자_짝궁("5525", "1255"))
    }

}


