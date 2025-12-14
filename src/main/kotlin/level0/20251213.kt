package org.example.level0

/**
 * 양의 정수 n이 매개변수로 주어질 때,
 * n이 홀수라면 n 이하의 홀수인 모든 양의 정수의 합을 return 하고
 * n이 짝수라면 n 이하의 짝수인 모든 양의 정수의 제곱의 합을 return 하는 solution 함수를 작성해 주세요.
 */
fun solution1(n: Int): Int {
    return if (n % 2 == 1) {
        (1..n step 2).sum()
    } else {
        (2..n step 2).sumOf { it * it }
    }
}

/**
 * 문자열에 따라 다음과 같이 두 수의 크기를 비교하려고 합니다.
 * ineq는 "<"와 ">"중 하나고, eq는 "="와 "!"중 하나입니다.
 */
fun solution2(ineq: String, eq: String, n: Int, m: Int): Int {
    when (ineq to eq) {
        "<" to "=" -> return if (n <= m) 1 else 0
        "<" to "!" -> return if (n < m) 1 else 0
        ">" to "=" -> return if (n >= m) 1 else 0
        ">" to "!" -> return if (n > m) 1 else 0
        else -> return -1
    }
}

fun solution3(a: Int, b: Int, flag: Boolean): Int {
    return when (flag) {
        true -> a + b
        false -> a - b
    }
}

fun solution4(code: String): String {
    var mode = false
    return code.filterIndexed { index, c ->
        when {
            c == '1' -> {
                mode = !mode; false
            }

            mode -> index % 2 == 1 // mode 1이고 index 홀수면 문자 추가
            else -> index % 2 == 0 // mode 0이고 index 짝수면 문자 추가
        }
    }.ifEmpty { "EMPTY" }
}

fun solution5(a: Int, d: Int, included: BooleanArray): Int {
    return included.withIndex().filter { it.value }.sumOf { a + it.index * d }
}

fun solution6(a: Int, b: Int, c: Int): Int {
    var distincNumberCount = arrayOf(a, b, c).distinct().size
    return when (distincNumberCount) {
        1 -> (a + b + c) * (a * a + b * b + c * c) * (a * a * a + b * b * b + c * c * c)
        2 -> (a + b + c) * (a * a + b * b + c * c)
        else -> a + b + c
    }
}


fun solution7(num_list: IntArray): Int {
    val sumOfAll = num_list.sum()
    val multipleOfAll = num_list.reduce() { acc, i -> acc * i }

    return if (multipleOfAll < sumOfAll * sumOfAll) 1 else 0
}

fun solution8(num_list: IntArray): Int {
    val odd = num_list.filter { it % 2 == 1 }.joinToString("").toInt()
    val even = num_list.filter { it % 2 == 0 }.joinToString("").toInt()
    return odd + even
}

fun solution9(a: Int, b: Int, c: Int, d: Int): Int {
    val numberGroup = listOf(a, b, c, d).groupingBy { it }.eachCount();
    return when {
        numberGroup.containsValue(4) -> 1111 * a
        numberGroup.containsValue(3) -> {
            val triple = numberGroup.filterValues { it == 3 }.keys.first()
            val single = numberGroup.filterValues { it == 1 }.keys.first()
            return (10 * triple + single) * (10 * triple + single)
        }

        numberGroup.values.count { it == 2 } == 2 -> {
            val pairs = numberGroup.filterValues { it == 2 }.keys.toList()
            val pair1 = pairs[0]
            val pair2 = pairs[1]
            return (pair1 + pair2) * Math.abs(pair1 - pair2)
        }

        numberGroup.containsValue(2) -> {
            val pair = numberGroup.filterValues { it == 2 }.keys.first()
            val singles = numberGroup.filterValues { it == 1 }.keys.toList()
            return singles[0] * singles[1]
        }

        else -> minOf(a, b, c, d)
    }

}

fun main() {
    val solution9 = solution9(2, 2, 2, 2)
    println(solution9)
}

