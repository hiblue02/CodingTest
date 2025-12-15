package org.example.level1

import kotlin.math.max

/**
 * 지갑만들기
 */
fun solution(sizes: Array<IntArray>): Int {
    var maxWidth = 0
    var maxHeight = 0
    sizes.forEach {
        val (width, height) = it.sorted()
        maxWidth = maxOf(maxWidth, width)
        maxHeight = maxOf(maxHeight, height)
    }
    return maxHeight * maxWidth
}


/**
 * 모의고사
 */
fun solution(answers: IntArray): IntArray {
    val person1Answers = intArrayOf(1, 2, 3, 4, 5)
    val person2Answers = intArrayOf(2, 1, 2, 3, 2, 4, 2, 5)
    val person3Answers = intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)

    fun countCorrectAnswers(personAnswers: IntArray, answers: IntArray): Int {
        return answers.withIndex().count { (index, answer) ->
            personAnswers[index % personAnswers.size] == answer
        }
    }

   val scores =  mutableMapOf<Int, Int>();
    scores.put(1, countCorrectAnswers(person1Answers, answers))
    scores.put(2, countCorrectAnswers(person2Answers, answers))
    scores.put(3, countCorrectAnswers(person3Answers, answers))

    val maxScore = scores.values.maxOrNull()!!;

    return scores.filter { it.value == maxScore }.keys.sorted().toIntArray()

}
