package org.example.level1

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
