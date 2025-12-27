package org.example.level1

import java.util.*

/**
 * 햄버거만들기
 */
fun solution1227(ingredient: IntArray): Int {
    var answer = 0
    val stack = Stack<Int>()
    for (item in ingredient) {
        stack.push(item)
        if(stack.size >= 4 &&
            stack[stack.size-4] == 1 &&
            stack[stack.size-3] == 2 &&
            stack[stack.size-2] == 3 &&
            stack[stack.size-1] == 1
        ) {
            repeat(4) {stack.pop()}
            answer ++
        }
    }

    return answer
}
