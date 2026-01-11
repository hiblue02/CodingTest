package org.example.level2

/**
 * 연속 수열 부분의 합
 */
fun solution_sequence(elements: IntArray): Int {

    fun right(start: Int, length: Int): Int {
        var sum = 0
        for (i in 0 until length) {
            val index = start + i % elements.size
            sum += elements[index]
        }
        return sum
    }

    fun left(start: Int, length: Int): Int {
        var sum = 0
        for (i in 0 until length) {
            val index = if (start - i < 0) elements.size + (start - i) else start - i
            sum += elements[index]
        }
        return sum
    }

    val set = mutableSetOf<Int>();

    for (i in 0 until elements.size) {
        for (j in 0 until elements.size) {
            set.add(right(i, j))
            set.add(left(i, j))
        }
    }

    return set.size
}

fun solution_sequence2(elements: IntArray): Int {
    val set = mutableSetOf<Int>()
    val doubled = elements + elements

    for (start in elements.indices) {
        var sum = 0
        for (length in 0..elements.size) {
            sum += doubled[start + length]
        }
        set.add(sum)
    }
    return set.size
}

