fun main() {

    fun checkVisible(x: Int, y: Int, trees: List<String>): Boolean {
        val current = trees[y][x]
        for (left in 0 until x) {
            if (trees[y][left] >= current) break
            if (left == x - 1) return true
        }
        for (right in x + 1 until trees[0].length) {
            if (trees[y][right] >= current) break
            if (right == trees[0].length - 1) return true
        }
        for (up in 0 until y) {
            if (trees[up][x] >= current) break
            if (up == y - 1) return true
        }
        for (down in y + 1 until trees.size) {
            if (trees[down][x] >= current) break
            if (down == trees.size - 1) return true
        }
        return false
    }

    fun checkScore(x: Int, y: Int, trees: List<String>): Int {
        val current = trees[y][x]
        var leftScore = 0
        for (left in x - 1 downTo 0) {
            leftScore++
            if (trees[y][left] >= current) break
        }
        var rightScore = 0
        for (right in x + 1 until trees[0].length) {
            rightScore++
            if (trees[y][right] >= current) break
        }
        var upScore = 0
        for (up in y - 1 downTo 0) {
            upScore++
            if (trees[up][x] >= current) break
        }
        var downScore = 0
        for (down in y + 1 until trees.size) {
            downScore++
            if (trees[down][x] >= current) break
        }
        return leftScore * rightScore * upScore * downScore
    }

    fun part1(trees: List<String>): Int {
        val height = trees.size
        val width = trees[0].length
        var visible = width * 2 + height * 2 - 4
        for (y in 1 until height - 1) {
            for (x in 1 until width - 1) {
                if (checkVisible(x, y, trees)) visible++
            }
        }
        return visible
    }

    fun part2(trees: List<String>): Int {
        val height = trees.size
        val width = trees[0].length
        var score = 0
        for (y in 1 until height - 1) {
            for (x in 1 until width - 1) {
                score = maxOf(score, checkScore(x, y, trees))
            }
        }
        return score
    }

    val input = readInput("Day08")
    println(part1(input))
    println(part2(input))
}