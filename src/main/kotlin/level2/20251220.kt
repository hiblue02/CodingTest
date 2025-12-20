package org.example.level2

import java.util.*


/**
 * 더 맵게
 */
fun solution1220(scoville: IntArray, k: Int): Int {
    fun mix(a: Int, b: Int) = minOf(a, b) + (maxOf(a, b) * 2)

    val queue = PriorityQueue<Int>()
    scoville.forEach { queue.add(it) }

    var count = 0
    while (queue.peek() < k && queue.size >= 2) {
        count++
        val first = queue.poll()
        val second = queue.poll()
        queue.add(mix(first, second))
    }

    return if (queue.peek() >= k) count else -1
}

