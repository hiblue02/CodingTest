package level1

import kotlin.test.*

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

    fun `문자열 나누기`(s: String): Int {
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

        return if (pot.isEmpty()) count else count + 1


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

    // 속도 문제
    fun `나머지가 1이 되는 숫자 찾기`(n: Int): Int {
        return generateSequence(2) { it + 1 }.first { n % it == 1 }
    }

    /** [LEVEL 1 삼총사](https://school.programmers.co.kr/learn/courses/30/lessons/131705) */
    fun `삼총사`(number: IntArray): Int {
        var count = 0
        for (a in 0 until number.size - 2) {
            for (b in a + 1 until number.size - 1) {
                for (c in b + 1 until number.size) {
                    if (number[a] + number[b] + number[c] == 0) count++
                }
            }
        }
        return count
    }

    /** [LEVEL 1 콜라문제](https://school.programmers.co.kr/learn/courses/30/lessons/132267)
     * @param a 콜라를 받기 위해 마트에 주어야 하는 병 수
     * @param b 마트에서 주는 새로운 병 수
     * @param c 상빈이가 가지고 있는 병 수
     * */
    fun `콜라문제`(a: Int, b: Int, n: Int): Int {
        var now = n
        var receivedTotal = 0
        while (now >= a) {
            var remained = now % a
            var received = (now / a) * b

            receivedTotal += received
            now = received + remained

        }
        return receivedTotal
    }

    @Test
    fun 콜라문제_테스트() {
        var answer = `콜라문제`(2, 1, 20)
    }

    fun `신규 아이디 추천`(new_id: String): String {
        val step1
//        1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
                = new_id.lowercase()
//        2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
            .replace(Regex("^a-z0-9._-"), "")
//        3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
            .replace(Regex(".{2,}"), ".")
//        4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
            .replace(Regex("(^\\.)|(\\.$)"), "")
//        5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
            .ifBlank { "a" };
//        6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
//        만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
        var step6 = (step1.takeIf { it.length > 16 }?.substring(0, 15) ?: step1).replace(Regex("(^\\.)|(\\.$)"), "")
//        7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
        return step6.takeIf { step6.length <= 2 } ?: (step6 + step6.last().toString().repeat(3 - step6.length))
    }

    fun `옹알이`(babbling: Array<String>): Int {
        return babbling.count { avaliable(it) }
    }

    data class State(val prefix: String, val remain: String)

    fun avaliable(s: String): Boolean {
        var now = State("", s)
        while (true) {
            val next = getStartIndex(now.remain)
            if (next.prefix == now.prefix) return false // 중복
            if (next.prefix == "") return false
            if (next.remain == "") return true
            now = next
        }
    }

    val avaliableSound = arrayOf("aya", "ye", "woo", "ma")
    fun getStartIndex(s: String): State {
        for (sound in avaliableSound) {
            if (s.startsWith(sound)) return State(sound, s.substring(sound.length))
        }
        return State("", s)
    }

    fun 이차원배열_자르기(n: Int, left: Long, right: Long): IntArray {
        val leftInt = left.toInt()
        val rightInt = right.toInt();

        val answer = IntArray(rightInt - leftInt + 1)

        for(i in leftInt .. rightInt) {
            val a = i / n
            val b = i % n
            answer[i - leftInt] = (maxOf(a,b) + 1)
        }


        return answer
    }

    fun makeArray(n:Int):Array<IntArray> {
        val array = Array(n) {IntArray(n)}
        for (a in 0 until  n){
            for(b in 0 until n) {
                array[a][b] = maxOf(a, b) + 1
            }
        }
        return array
    }

    @Test
    fun `옹알이 테스트`() {
//        assertFalse(avaliable("yeyeye"))
//        assertFalse(avaliable("uuu"))
        assertFalse(avaliable("u"))
        assertTrue(avaliable("yemawoo"))
        assertTrue(avaliable("ayaye"))
    }
}


