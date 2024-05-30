package tinkoffAlgorithms2024.w13_final_exam

data class Position(val x: Int, val y: Int)

fun bfs(field: Array<CharArray>, visited: Array<BooleanArray>, startX: Int, startY: Int): List<Position> {
    val queue = ArrayDeque<Position>()
    val shipCells = mutableListOf<Position>()
    queue.add(Position(startX, startY))

    while (queue.isNotEmpty()) {
        val (cx, cy) = queue.removeFirst()
        if (visited[cx][cy]) continue
        visited[cx][cy] = true
        shipCells.add(Position(cx, cy))

        val directions = listOf(
            Position(-1, 0), Position(1, 0),
            Position(0, -1), Position(0, 1)
        )

        for (dir in directions) {
            val nx = cx + dir.x
            val ny = cy + dir.y
            if (nx in field.indices && ny in 0 until field[0].size && !visited[nx][ny] && (field[nx][ny] == '#' || field[nx][ny] == 'X')) {
                queue.add(Position(nx, ny))
            }
        }
    }

    return shipCells
}

fun main() {
    val (n, m) = readln().split(' ').map { it.toInt() }
    val field = Array(n) { CharArray(m) }

    repeat(n) {
        field[it] = readln().toCharArray()
    }

    val visited = Array(n) { BooleanArray(m) }
    var okShips = 0
    var damagedShips = 0
    var destroyedShips = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if ((field[i][j] == '#' || field[i][j] == 'X') && !visited[i][j]) {
                val shipCells = bfs(field, visited, i, j)
                val hasIntact = shipCells.any { field[it.x][it.y] == '#' }
                val hasDestroyed = shipCells.any { field[it.x][it.y] == 'X' }

                when {
                    hasIntact && !hasDestroyed -> okShips++
                    !hasIntact && hasDestroyed -> destroyedShips++
                    else -> damagedShips++
                }
            }
        }
    }

    println("$okShips $damagedShips $destroyedShips")
}