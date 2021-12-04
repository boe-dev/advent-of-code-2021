fun main() {
    fun part1(input: List<String>): Int {
        var gamma = String()
        var epsilon = String()
        for(i in 0 until input.first().length) {
            gamma += if (input.count { it[i] == '0' } > input.count { it[i] == '1' }) 0 else 1
            epsilon += if (input.count { it[i] == '0' } > input.count { it[i] == '1' }) 1 else 0
        }
        return gamma.toInt(2) * epsilon.toInt(2)
    }

    fun part2(input: List<String>): Int {

        var oxygenList = input
        for(i in 0 until oxygenList.first().length) {
            val filterChar = if (oxygenList.count { it[i] == '0' } > oxygenList.count { it[i] == '1' }) '0' else '1'
            oxygenList = oxygenList.filter { it[i] == filterChar }
        }
        var c02List = input
        for(i in 0 until c02List.first().length) {
            val filterChar = if (c02List.count { it[i] == '0' } > c02List.count { it[i] == '1' }) '1' else '0'
            c02List = c02List.filter { it[i] == filterChar }
            if (c02List.size == 1) {
                break
            }
        }
        return oxygenList.first().toInt(2) * c02List.first().toInt(2)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    println(part1(testInput))
    check(part1(testInput) == 198)
    println(part2(testInput))

    val input = readInput("Day03")
    println(part1(input))
    check(part1(input) == 2595824)
    println(part2(input))
    check(part2(input) == 2135254)
}
