package org.example.level0

/**
 * 정수 배열 arr와 query가 주어집니다.
 *
 * query를 순회하면서 다음 작업을 반복합니다.
 *
 * 짝수 인덱스에서는 arr에서 query[i]번 인덱스를 제외하고 배열의 query[i]번 인덱스 뒷부분을 잘라서 버립니다.
 * 홀수 인덱스에서는 arr에서 query[i]번 인덱스는 제외하고 배열의 query[i]번 인덱스 앞부분을 잘라서 버립니다.
 * 위 작업을 마친 후 남은 arr의 부분 배열을 return 하는 solution 함수를 완성해 주세요.
 *
 *
 */
fun 배열_나열하기(arr: IntArray, query: IntArray): IntArray {

    var result = arr.toMutableList()
    query.forEachIndexed { index, value ->
        if (index % 2 == 0) { // 짝수
            result = result.subList(0, value + 1);
        } else { // 홀수
            result = result.subList(value, result.size)
        }
    }
    return result.toIntArray()
}

/**
 * 0과 5로만 이루어진 모든 정수
 */
fun 배열_만들기2(l: Int, r: Int): IntArray {
    return (l..r).filter { it -> it.toString().all { it == '0' || it == '5' } }.ifEmpty { listOf(-1) }.toIntArray()
}

/**
 * 정사각형 만들기
 */
fun 정사각형_만들기(arr: Array<IntArray>): Array<IntArray> {
    val maxSize = maxOf(arr.size, arr[0].size)
    return Array(maxSize) { row ->
        IntArray(maxSize) { col ->
            arr.getOrNull(row)?.getOrNull(col)?: 0
        }

    }
}
