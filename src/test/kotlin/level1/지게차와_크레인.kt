package level1

import org.junit.jupiter.api.Test

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/388353
 */
class `지게차와 크레인` {
    fun solution(storage: Array<String>, requests: Array<String>): Int {
        var storageArray = Array(storage.size) { i ->
            storage[i].map { it.toString() }.toTypedArray()
        }

        for (request in requests) {
            if (request.length == 2) {
                carryAll(storageArray, request.substring(0, 1))
            } else {
                carryAttachedWall(storageArray, request)
            }
        }

        return storageArray.sumOf { row ->
            row.count { item ->
                item != " "
            }
        }

    }

    fun carryAll(storage: Array<Array<String>>, request: String) {
        for (row in storage.indices) {
            for (col in storage[row].indices) {
                if (storage[row][col] == request) {
                    storage[row][col] = " "
                }
            }
        }

    }

    fun carryAttachedWall(storage: Array<Array<String>>, request: String) {

        val copy = storage.map { it.clone() }.toTypedArray()
        val m = storage[0].size
        val n = storage.size

        for (row in copy.indices) {
            for (col in copy[row].indices) {
                if (copy[row][col] == request && isOpen(copy, row, col)) {
                    storage[row][col] = " "
                }
            }
        }
    }

        fun isOpen(storage: Array<Array<String>>, startRow: Int, startCol: Int): Boolean {
            val n = storage.size
            val m = storage[0].size
            var visited = Array(n) { BooleanArray(m) }

            fun dfs(row: Int, col: Int): Boolean {
                if (visited[row][col]) return false // 이미 방문 → 막혀있음으로 처리

                visited[row][col] = true

                // 빈 공간이 아니면 막혀 있음
                if (storage[row][col] != " ") return false

                // 배열 경계에 닿으면 뚫려 있음
                if (row == 0 || row == n - 1 || col == 0 || col == m - 1) return true

                // 상하좌우 탐색
                val directions = listOf(
                    row + 1 to col,
                    row - 1 to col,
                    row to col + 1,
                    row to col - 1
                )

                for ((r, c) in directions) {
                    if (dfs(r, c)) return true // 한쪽이라도 벽에 닿으면 뚫려 있음
                }

                return false // 모든 방향 막혀 있음
            }

            return dfs(startRow, startCol)
        }



    @Test
    fun test() {
        val storage = arrayOf("AZWQY", "CAABX", "BBDDA", "ACACA")
        val requests = arrayOf("A", "BB", "A")

        val answer = solution(storage, requests)
        println(answer)
    }
}

