package level1

import org.junit.jupiter.api.Test
import java.time.LocalTime
import kotlin.math.abs

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388351
 */
fun solution(schedules: IntArray, timelogs: Array<IntArray>, startday: Int): Int {

    val sundayIndex = abs(7 - startday)
    val saturdayIndex = if (startday == 7) {6} else {6 - startday}

    var answer: Int = 0

    for (i in timelogs.indices) {
        val isSuccess = timelogs[i]
            .withIndex()
            .all { (index, time) ->
                if (index == sundayIndex || index == saturdayIndex) {
                     true
                } else {
                    val scheduleTime = parseTime(schedules[i]).plusMinutes(10)
                        parseTime(time) <= scheduleTime
                }
            }
        if (isSuccess) {
            answer++
        }
    }

    return answer
}

fun parseTime(time: Int): LocalTime {
    val hour = time / 100
    val minute = time % 100
    return LocalTime.of(hour, minute)
}

class Test {
    @Test
    fun parseTimeTest(){
        val time = 700
        val parsedTime = parseTime(time).plusMinutes(10)
        println(parsedTime)
    }
    @Test
    fun calculateIndex() {
        val startday = 7
        val sundayIndex = abs(7 - startday)
        val saturdayIndex = if (startday == 7) {1} else {6 - startday}

        println("saturdayIndex: $saturdayIndex sundayIndex: $sundayIndex")
    }
}
