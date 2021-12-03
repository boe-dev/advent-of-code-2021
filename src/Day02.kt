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
//                    depth -= movement
                    aim -= movement
                }
                DOWN -> {
//                    depth += movement
                    aim += movement
                }
            }
        }
        return horizontalPosition * depth
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    println(part1(testInput))
    check(part1(testInput) == 150)

    val testInput2 = readInput("Day02_test")
    println(part2(testInput2))
    check(part2(testInput2) == 900)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
