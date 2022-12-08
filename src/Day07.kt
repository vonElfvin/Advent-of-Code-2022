import kotlin.math.abs

fun main() {
    data class Directory(
        val name: String,
        val parent: String,
        val childDirs: MutableSet<String> = mutableSetOf(),
        var filesSize: Long = 0,
        var totalSize: Long = 0,
    )

    fun part1(input: List<String>): Long {
        val dirTree: MutableMap<String, Directory> = mutableMapOf(
            "/" to Directory("/", "/")
        )

        var current = "/"
        var candidate = "/"
        input.drop(1).forEach { line ->
            when {
                line == "$ cd .." -> current = dirTree[current]!!.parent
                line.startsWith("$ cd") -> candidate = current + line.split(' ')[2] + "/"
                line == "$ ls" -> {
                    current = candidate
                    dirTree[current]!!.filesSize = 0
                }

                line.startsWith("dir") -> {
                    val directory = line.split(' ')[1]
                    val dirPath = "$current$directory/"
                    if (dirTree[dirPath] == null) dirTree[dirPath] =
                        Directory(name = dirPath, parent = current)
                    dirTree[current]!!.childDirs += dirPath
                }

                else -> {
                    dirTree[current]!!.filesSize += line.split(' ')[0].toLong()
                }
            }
        }

        val sortedDirectories = dirTree.values.sortedByDescending { it.name.split('/').size }
        sortedDirectories.forEachIndexed { currentIndex, currentDir ->
            currentDir.totalSize += currentDir.filesSize
            sortedDirectories
                .filterIndexed { index, dir -> index != currentIndex && dir.childDirs.contains(currentDir.name) }
                .forEach { it.totalSize += currentDir.totalSize }
        }

        val currentSize = dirTree.values.sumOf { it.filesSize }

        val sizeNeed = abs(70000000 - 30000000 - currentSize)

        return dirTree.values.filter { it.totalSize >= sizeNeed }.minOf { it.totalSize }
    }

    fun part2(input: List<String>): Int {
        return 0
    }

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}