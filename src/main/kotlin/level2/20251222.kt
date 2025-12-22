package org.example.level2

/**
 * 타켓넘버
 */
fun solution(numbers: IntArray, target: Int): Int {

    var answer = 0
    fun calculate(current:Int, index:Int) {
        if(index == numbers.size) {
            if(current == target) answer++
            return
        }

        calculate(current + numbers[index], index+1)
        calculate(current - numbers[index], index+1)
    }

    calculate(0, 0)

    return answer
}
