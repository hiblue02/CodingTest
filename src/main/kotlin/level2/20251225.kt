package org.example.level2

/**
 * 조이스틱
 */
fun solution1225(name: String): Int {

    val completed = BooleanArray(name.length) { index ->
        name[index] == 'A'
    }

    var answer = 0
    var nowIndex = 0
    while (completed.any { it == false }) {
        // 1. 현재 알파벳 변경 (위아래)
        val upDown = name[nowIndex] - 'A'
        answer += minOf(upDown, 26 - upDown)
        completed[nowIndex] = true

        if (completed.all { it == true }) break

        // 2. 옆 이동 오른쪽,왼쪽 중 더 짧은 것 고르기
        var rightStep = 0
        var right = nowIndex
        while (completed[right]) {
            rightStep++
            right = (right + 1) % name.length
        }

        var leftStep = 0
        var left = nowIndex
        while (completed[left]) {
            leftStep++
            left = if (left - 1 < 0) name.length - 1 else left - 1
        }

        if (rightStep <= leftStep) {
            nowIndex = right
            answer += rightStep

        } else {
            nowIndex = left
            answer += leftStep
        }
    }
    return answer
}

/**
 * 조이스틱 2 가다가 꺽어서 방향 유지
 */
fun solution1225_1(name: String): Int {
    // 상하이동 횟수
    var updown = 0
    for (name in name.toCharArray()) {
        val down = name - 'A'
        updown += minOf(down, 26 - down)
    }
    // 좌우이동 횟수
    var leftRight = name.length - 1
    for (i in 0 until name.length) {
        var next = i + 1
        while (next < name.length && name[next] == 'A') {
            next++
        }
        val case1 = i * 2 + (name.length - next)
        val case2 = (name.length - next) * 2 + i
        println("${case1}, ${case2}")
        leftRight = minOf(leftRight, minOf(case1, case2))
    }
    return updown + leftRight
}
