const val FORWARD: Char = 'f'
const val UP: Char = 'u'
const val DOWN: Char = 'd'
fun main() {


    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        input.forEach {
            val movement = it.filter { it.isDigit() }.toInt()
            when(it.first()) {
                FORWARD -> {
                    horizontalPosition += movement
                }
                UP -> {
                    depth -= movement
                }
                DOWN -> {
                    depth += movement
                }

            }
        }
        return horizontalPosition * depth
    }

    fun part2(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        input.forEach {
            val movement = it.filter { it.isDigit() }.toInt()
            when(it.first()) {
                FORWARD -> {
                    horizontalPosition += movement
                    depth += (aim * movement)
                }
                UP -> {
                    aim -= movement
                }
                DOWN -> {
                    aim += movement
                }
            }
        }
        return horizontalPosition * depth
    }

    fun part1Solution(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        val operations = input.map { it.split(' ') }
        for ((direction, amountString) in operations) {
            val amount = amountString.toInt()
            when(direction) {
                "up" -> depth -= amount
                "down" -> depth += amount
                "forward" -> horizontalPosition += amount
            }
        }
        return horizontalPosition * depth
    }

    data class Operation(val direction: String, val amount: Int)

    fun part2Solution(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0
        var aim = 0
        val operations = input.map { it.split(' ') }.map { Operation(it[0], it[1].toInt())  }
        for ((direction, amount) in operations) {
            when(direction) {
                "up" -> aim -= amount
                "down" -> aim += amount
                "forward" -> {
                    horizontalPosition += amount
                    depth += (aim * amount)
                }
            }
        }
        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 150)
    check(part1Solution(testInput) == 150)

    val testInput2 = readInput("Day02_test")
    println(part2(testInput2))
    check(part2(testInput2) == 900)
    check(part2Solution(testInput2) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part1Solution(input))
    println(part2(input))
    println(part2Solution(input))
}
