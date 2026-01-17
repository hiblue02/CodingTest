package org.example.level2

import java.util.*

/**
 * 택배상자
 */
fun solution0116(order: IntArray): Int {

    var answer: Int = 0
    val subBelt = Stack<Int>()
    var main = 1
    var orderIndex = 0

    while (orderIndex < order.size) {
        // 서브벨트에서 원하는 상자를 꺼내어 싣는다
        if (subBelt.isNotEmpty() && subBelt.peek() == order[orderIndex]) {
            answer ++
            orderIndex++
            subBelt.pop()
        }
        // 메인 벨트에서 원하는 상자가 나오면 바로 싣는다
        else if (main <= order.size && main == order[orderIndex]) {
            answer ++
            orderIndex ++
            main ++
        }
        // 메인 벨트에서 보조 벨트로 이동한다
        else if (main <= order.size && main < order[orderIndex]) {
            subBelt.add(main)
            main++
        } else {
            break
        }
    }

    return answer
}

fun main() {
//    println(solution0116(intArrayOf(4,3,1,2,5)))
    println(solution0116(intArrayOf(5,4,3,2,1)))
}
