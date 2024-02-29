
class Stack {
    private val stack = java.util.Stack<Int>()
    private val min = java.util.Stack<Int>()
    private var size = 0
    fun push(elem: Int) {
        stack.push(elem)
        if (size == 0 || elem < min.peek()) {
            min.push(elem)
        } else {
            min.push(min.peek())
        }
        size++
    }

    fun pop() {
        stack.pop()
        min.pop()
        size--
    }

    fun getMin() : Int {
        return min.peek()
    }
}

// LOL kotlin solution TL, same CPP solution OK
fun main () {
    val stack = Stack()
    val n = readln().toInt()
    var input: String

    repeat(n) {
        input = readln()
        if (input.split(' ').size == 2) {
            stack.push(input.split(' ').last().toInt())
        } else if (input == "2") {
            stack.pop()
        } else if (input == "3") {
            println(stack.getMin())
        }
    }
}