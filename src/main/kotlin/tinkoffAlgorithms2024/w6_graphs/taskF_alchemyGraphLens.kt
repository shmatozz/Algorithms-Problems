package tinkoffAlgorithms2024.w6_graphs


/*
m = int(input())
graph = {}
lens = {}

for i in range(m):
    edge = input().split()
    if not graph.get(edge[0], []):
        graph[edge[0]] = []
    graph[edge[0]].append(edge[2])

    if edge[0] not in lens.keys():
        lens[edge[0]] = -1
    if edge[2] not in lens.keys():
        lens[edge[2]] = -1

start = input()
end = input()

lens[start] = 0
queue = [start]

while len(queue) != 0:
    cur = queue[0]
    del queue[0]
    for n in graph.get(cur, []):
        if lens[n] == -1:
            queue.append(n)
            lens[n] = lens[cur] + 1

print(lens.get(end, -1))
 */

fun main() {
    val m  = readln().toInt()
    val graph = mutableMapOf<String, MutableList<String>>()
    val lens = mutableMapOf<String, Int>()

    repeat(m) {
        val (from, sp, to) = readln().split(' ')

        if (graph.getOrDefault(from, 0) == 0) {
            graph[from] = mutableListOf()
        }
        graph[from]?.add(to)

        if (!lens.keys.contains(from)) {
            lens[from] = -1
        }
        if (!lens.keys.contains(to)) {
            lens[to] = -1
        }
    }

    val start = readln()
    val end = readln()
    lens[start] = 0
    val queue = mutableListOf<String>()
    queue.add(start)

    while (queue.isNotEmpty()) {
        val cur = queue[0]
        queue.removeFirst()
        for (v in graph.getOrDefault(cur, mutableListOf())) {
            if (lens[v] == -1) {
                queue.add(v)
                lens[v] = lens.getOrDefault(cur, 0) + 1
            }
        }
    }

    println(lens.getOrDefault(end, -1))
}