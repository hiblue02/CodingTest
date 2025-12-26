package org.example.level2

import java.util.*

/**
 * 큰 수 만들기
 */
fun solution(number: String, k: Int): String {
    val stack = Stack<Char>()
    var removeCount = 0

    for (digit in number) {
        while (
            stack.isNotEmpty() &&
            stack.peek() < digit &&
            removeCount < k
        ) {
            stack.pop()
            removeCount++
        }
        stack.push(digit)

    }

    while(removeCount < k) {
        stack.pop()
        removeCount++
    }
    return stack.joinToString("")
}
