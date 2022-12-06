fun main() {
    fun solve(input: List<String>, all: Boolean): Long = input.sumOf { row ->
        row.split(',')
            .map { sections -> sections.split('-').map(String::toInt) }
            .map { (start, stop) -> start..stop }
            .let { (left, right) ->
                when (all) {
                    true -> left.all { right.contains(it) } || right.all { left.contains(it) }
                    false -> left.intersect(right).isNotEmpty()
                }
            }.let { if (it) 1L else 0L }
    }

    fun part1(input: List<String>): Long = input.sumOf { row ->
        row.split(',')
            .map { sections -> sections.split('-').map(String::toInt) }
            .map { (start, stop) -> start..stop }
            .let { (left, right) -> if (left.all { right.contains(it) } || right.all { left.contains(it) }) 1L else 0L }
    }


    fun part2(input: List<String>): Long = input.sumOf { row ->
        row.split(',')
            .map { sections -> sections.split('-').map(String::toInt) }
            .map { (start, stop) -> start..stop }
            .let { (left, right) -> if (left.intersect(right).isNotEmpty()) 1L else 0L }
    }

    val input = readInput("Day04")
    println(solve(input, true))
    println(solve(input, false))
}