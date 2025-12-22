package org.example.level2

/**
 * K번째 수
 */
fun solution(array: IntArray, commands: Array<IntArray>): IntArray {

    return commands.map {
        array.sliceArray(it[0] - 1..it[1] - 1)
            .sorted()[it[2] - 1]
    }.toIntArray()

}

/**
 * 가장 큰 수
 */
fun solution_1(numbers: IntArray): String {
    val visited = BooleanArray(numbers.size) {false}
    var answer:Long = 0

    fun makeNumber(current:String, depth:Int, maxDepth:Int) {
        if(depth == maxDepth) {
            answer = maxOf(answer, current.toLong())
            return
        }
        for(number in numbers.indices) {
            if(!visited[number]) {
                visited[number] = true
                makeNumber(current+numbers[number], depth+1, maxDepth )
                visited[number] = false
            }
        }


    }

    makeNumber("", 0, numbers.size)
    return answer.toString()
}

fun solution_2(numbers:IntArray): String {
   val answer =  numbers.map{it.toString()}
        .sortedWith {
            a, b -> (b+a).compareTo(a+b)
        }.joinToString ("")

    return if(answer.all{it == '0'}) "0" else answer
}

