package org.example.level2


/**
 * 구명보트
 */
fun solution1227_1(people: IntArray, limit: Int): Int {
    var answer = 0
    var left = 0
    var right = people.size - 1

    people.sort()

    while (left <= right) {
        if (people[left] + people[right] <= limit) {
            left++
        }
        right--
        answer++
    }

    return answer
}
