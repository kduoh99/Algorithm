class MyStack() {
    val q = LinkedList<Int>()

    fun push(x: Int) {
        q.addLast(x)

        repeat(q.size - 1) {
            q.addLast(q.removeFirst())
        }
    }

    fun pop(): Int = q.removeFirst()

    fun top(): Int = q.first()

    fun empty(): Boolean = q.isEmpty()
}

/**
 * Your MyStack object will be instantiated and called as such:
 * var obj = MyStack()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.empty()
 */