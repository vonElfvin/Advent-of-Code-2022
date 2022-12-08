fun main() {
    fun solve(input: List<String>, length: Int = 4): Int {
        val signal = input[0]
        signal.forEachIndexed { index, _ ->
            if (index < length - 1) return@forEachIndexed
            val lastFour = signal.substring(index - length + 1..index)
            val distinctFour = lastFour.toSet().joinToString("")
            if (lastFour == distinctFour) return index + 1
        }
        return 0
    }

    val input = readInput("Day06")
    println(solve(input, 4))
    println(solve(input, 14))
}