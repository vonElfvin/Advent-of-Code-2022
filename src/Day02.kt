fun main() {
    fun part1(input: List<String>): Int = input.sumOf {
        val (opponent, me) = it.split(' ')
        when (me) {
            "X" -> 1 + when (opponent) {
                "A" -> 3
                "B" -> 0
                else -> 6
            }

            "Y" -> 2 + when (opponent) {
                "A" -> 6
                "B" -> 3
                else -> 0
            }

            else -> 3 + when (opponent) {
                "A" -> 0
                "B" -> 6
                else -> 3
            }
        }
    }

    fun part2(input: List<String>) = input.sumOf {
        val (opponent, me) = it.split(' ')
        when (opponent) {
            "A" -> when (me) {
                "X" -> 0 + 3
                "Y" -> 3 + 1
                else -> 6 + 2
            }

            "B" -> when (me) {
                "X" -> 0 + 1
                "Y" -> 3 + 2
                else -> 6 + 3
            }

            else -> when (me) {
                "X" -> 0 + 2
                "Y" -> 3 + 3
                else -> 6 + 1
            }
        }.toInt()
    }

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}