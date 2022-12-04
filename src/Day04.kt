fun main() {
    fun part1(input: List<String>): Long = input.sumOf { row ->
        val (left, right) = row.split(',').map { it.split('-').map(String::toInt) }.map { it[0]..it[1] }
        if (left.all { right.contains(it) } || right.all { left.contains(it) }) 1L else 0L
    }

    fun part2(input: List<String>): Long = input.sumOf { row ->
        val (left, right) = row.split(',').map { it.split('-').map(String::toInt) }.map { it[0]..it[1] }
        if (left.intersect(right).isNotEmpty()) 1L else 0L
    }

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}