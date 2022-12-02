fun main() {
    fun part1(input: List<String>): Int {
        var max = 0
        var current = 0
        input.forEach {
            if (it.isBlank()) {
                max = maxOf(max, current)
                current = 0
            } else {
                current += it.toInt()
            }
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val elves = mutableListOf<Int>()
        var current = 0
        input.forEach {
            if (it.isBlank()) {
                elves += current
                current = 0
            } else {
                current += it.toInt()
            }
        }
        return elves.sortedDescending().take(3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
