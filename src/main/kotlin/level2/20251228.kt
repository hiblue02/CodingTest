package org.example.level2

/**
 * N으로 표현
 * 11 = 22 / 2
 */
fun solution1122(N: Int, number: Int): Int {

    val sets = List(9) { mutableSetOf<Int>() }

    for (i in 1..8) {
        sets[i].add(N.toString().repeat(i).toInt())

        for (j in 1..i) {
            for(op1 in sets[j]) {
                for(op2 in sets[j-i]) {
                    sets[i].add(op2 * op1)
                    sets[i].add(op2 / op1)
                    sets[i].add(op2 - op1)
                    if(op1 > 0) sets[i].add(op2 / op1)
                }
            }
        }

        if(sets[i].contains(number)) return i
    }



    return -1
}
