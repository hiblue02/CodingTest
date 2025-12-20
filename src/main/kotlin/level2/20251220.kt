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


/**
 * 디스크 컨트롤러
 */
fun solution1220_1(jobs: Array<IntArray>): Int {
    data class Job(
        val requestTime: Int,
        val workTime: Int,
        var endTime: Int = Integer.MAX_VALUE,
        var startTime: Int = Integer.MAX_VALUE
    ) : Comparable<Job> {
        override fun compareTo(other: Job): Int {
            // 작업시간이 짧으면 우선순위가 높다.
            // 작업시간 같다면, 요청시간이 빠르면 우선순위가 높다
            return when {
                this.workTime != other.workTime -> this.workTime.compareTo(other.workTime)
                else -> this.requestTime.compareTo(other.requestTime)
            }
        }

        fun turnaroundTime(): Int = endTime - requestTime
         fun start(currentTime: Int) {
            this.startTime = currentTime
            this.endTime = currentTime + workTime
        }
    }

    val waiting = jobs.map { Job(it[0], it[1]) }.sortedBy{it.requestTime}.toMutableList()
    val queue = PriorityQueue<Job>()
    val completed = mutableListOf<Job>()
    var currentTime = 0

    while (completed.size < jobs.size) {
        // 작업 추가
        while (waiting.isNotEmpty() && waiting.first().requestTime <= currentTime) {
            queue.offer(waiting.removeFirst())
        }
        // queue가 비어있으면 작업시간 이동
        if(queue.isEmpty()) {
            currentTime = waiting.first().requestTime
            continue
        }
        // 작업수행
        val job = queue.poll()
        job.start(currentTime)
        currentTime = job.endTime
        completed.add(job)
    }

    return completed.map { it.turnaroundTime() }.average().toInt()
}
