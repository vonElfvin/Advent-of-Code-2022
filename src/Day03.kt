const val UPPER = 65 - 27
const val LOWER = 96

fun main() {
    fun part1(input: List<String>): Int = input.sumOf { row ->
        val (left, right) = listOf(
            row.substring(0, row.length / 2),
            row.substring(row.length / 2)
        ).map(String::toCharArray)
        val both = left.first { right.contains(it) }
        if (both.isUpperCase()) both.code - UPPER else both.code - LOWER
    }

    fun part2(input: List<String>): Int = input.chunked(3).sumOf { group ->
        val (first, second, third) = group
        val all = first.first { second.contains(it) && third.contains(it) }
        if (all.isUpperCase()) all.code - UPPER else all.code - LOWER
    }

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}