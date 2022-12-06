fun main() {
    fun solve(input: List<String>, reversed: Boolean): String {
        val boxRegex = "[A-Z]".toRegex()
        val boxes: MutableMap<Int, List<Pair<Int, Char>>> = mutableMapOf()
        var row = 0
        do {
            val rowBoxes = boxRegex.findAll(input[row]).toList().map { Pair((it.range.first - 1) / 4 + 1, it.value[0]) }
            if (rowBoxes.isNotEmpty()) boxes[row] = rowBoxes
            row += 1
        } while (input[row] != "")
        row += 1
        val piles: MutableMap<Int, List<Char>> = mutableMapOf()
        boxes.entries.reversed().forEach { (_, row) ->
            row.forEach { (pileNumber, letter) ->
                piles[pileNumber] = (piles[pileNumber] ?: emptyList()) + letter
            }
        }
        do {
            val instruction = input[row]
            val numbers = "\\d+".toRegex().findAll(instruction).toList().map { it.value.toInt() }
            val (quantity, from, to) = numbers
            val move = piles[from]!!.takeLast(quantity)
            piles[to] = piles[to]!! + if (reversed) move.reversed() else move
            piles[from] = piles[from]!!.dropLast(quantity)
            row += 1
        } while (row < input.size)
        return piles.values.map { it.last() }.joinToString("")
    }

    val input = readInput("Day05")
    println(solve(input, true))
    println(solve(input, false))
}