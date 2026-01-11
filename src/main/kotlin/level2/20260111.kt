package org.example.level2


/**
 * 우박수열 정적분
 */
fun solution_260111(k: Int, ranges: Array<IntArray>): DoubleArray {

    /**
     * 우박수열
     */
    fun collatz(k:Int): List<Int> = buildList {
        var current = k
        add(current)
        while(current > 1) {
            current = if(current%2 == 0) current / 2 else current * 3  + 1
            add(current)
        }
    }

    /**
     * 너비구하기
     */
    fun calculateArea(start:Int, end:Int, sequence:List<Int>): Double =
        (start until end).sumOf { i ->
            (sequence[i] + sequence[i+1]).toDouble() / 2
        }

    val sequence = collatz(k)

    return ranges. map { range ->
        val start = range[0]; val end = sequence.size + range[1] - 1;
        println("${start}, ${end}")
        if(start > end ) -1.0 else calculateArea(start, end, sequence )
    }.toDoubleArray()
}

fun main() {
    val testCases = listOf(
        5 to arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, -1),
            intArrayOf(2, -3),
            intArrayOf(3, -3)
        )
    )

    testCases.forEachIndexed { index, (k, ranges) ->

        val result = solution_260111(k, ranges)
        println("result: ${result.contentToString()}")
        println()
    }
}
fun solution_260111_2(k: Int, ranges: Array<IntArray>): DoubleArray {
    /**
     * 우박수열
     */
    fun collatz(k:Int): List<Int> = buildList {
        var current = k
        add(current)
        while(current > 1) {
            current = if(current%2 == 0) current / 2 else current * 3  + 1
            add(current)
        }
    }

    /**
     * 너비구하기
     */
    fun calculateArea(start:Int, end:Int, sequence:List<Int>): Double =
        (start until end).sumOf { i ->
            (sequence[i] + sequence[i+1]).toDouble() / 2
        }

    val sequence = collatz(k)

    return ranges. map { range ->
        val start = range[0]; val end = sequence.size + range[1] - 1;
        println("${start}, ${end}")
        if(start > end ) -1.0 else calculateArea(start, end, sequence )
    }.toDoubleArray()
}


/**
 * 양과 늑대 후보 집한 기반 백트래킹
 */
fun solution260111(info: IntArray, edges: Array<IntArray>): Int {

    val graph = Array(info.size) { mutableListOf<Int>() }

    for (edge in edges) {
        graph[edge[0]].add(edge[1])
    }

    var answer = 0

    fun pass(sheep: Int, wolf: Int, candidates: MutableList<Int>) {
        if (sheep > answer) answer = sheep
        for (i in candidates.indices.toList()) {
            val node = candidates[i]
            val nextSheep = sheep + if (info[node] == 0) 1 else 0
            val nextWolf = wolf + if (info[node] == 1) 1 else 0
            if(nextSheep <= nextWolf) continue

            val next = candidates.toMutableList()
            next.removeAt(i)
            next.addAll(graph[node])
            pass(nextSheep, nextWolf,  next)


        }
    }

    pass(1,0,graph[0].toMutableList())

    return answer
}
