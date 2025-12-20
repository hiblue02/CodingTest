package org.example.level2

/**
 * 다리를 지나는 트럭
 */
fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {

    data class Bridge(val queue: ArrayDeque<Int>, val weight: Int, val length: Int, var time: Int = 0) {

        fun push(truckWeight: Int): Boolean {
            time++
            queue.removeFirst()
            if (queue.size == length || queue.sum() + truckWeight > weight) {
                queue.add(0)
                return false
            }
            queue.add(truckWeight)
            return true
        }

        fun isEmpty(): Boolean {
            return !queue.any { it > 0 }
        }

    }

    val bridge = Bridge(
        ArrayDeque(List(bridge_length) { 0 }),
        weight,
        bridge_length,
        0
    )

    for (truck in truck_weights) {
        while (bridge.push(truck).not()) {
        }
    }

    while (bridge.isEmpty().not()) {
        bridge.push(0)
    }
    return bridge.time
}

fun solution2(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    val bridge = ArrayDeque<Int>(); repeat(bridge_length) { bridge.add(0) }

    var currentWeight = 0
    var time = 0
    var truckIndex = 0

    while (truckIndex < truck_weights.size) {
        time++

        currentWeight -=  bridge.removeFirst()

        val newTruck = truck_weights[truckIndex]
        if (newTruck + currentWeight <= weight) {
            currentWeight += newTruck
            bridge.add(newTruck)
            truckIndex++
        } else {
            bridge.add(0)
        }
    }

    return time + bridge_length

}
