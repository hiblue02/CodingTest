package level1

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/258712
 */

fun solution(friends: Array<String>, gifts: Array<String>): Int {

    val friendContainer = friends.map { Friend(it) }
    val record = Array(friends.size) { IntArray(friends.size) }
    val nameIndex = friends.withIndex().associate { it.value to it.index }

    for (gift in gifts) {
        val giverName = gift.substringBefore(" ")
        val receiverName = gift.substringAfter(" ")
        val giveIndex = nameIndex[giverName]!!
        val receiverIndex = nameIndex[receiverName]!!

        friendContainer[giveIndex].give += 1
        friendContainer[receiverIndex].receive += 1

        record[giveIndex][receiverIndex]++
    }

    var answer = 0

    for (friend in friends) {
        val index = nameIndex[friend]!!
        var giftCount = 0
        for (friendIndex: Int in friends.indices) {
            if (record[index][friendIndex] > record[friendIndex][index]) {
                giftCount++
            } else if (record[index][friendIndex] == record[friendIndex][index] && friendContainer[index].giftIndex > friendContainer[friendIndex].giftIndex) {
                giftCount++
            }
        }
        if (giftCount > answer) answer = giftCount
    }

    return answer
}

data class Friend(
    val name: String,
    var give: Int = 0,
    var receive: Int = 0
) {
    val giftIndex: Int
        get() = give - receive
}

