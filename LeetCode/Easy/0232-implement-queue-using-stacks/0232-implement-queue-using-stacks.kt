class MyQueue() {
    val s1 = ArrayDeque<Int>()
    val s2 = ArrayDeque<Int>()

    fun push(x: Int) = s1.addFirst(x)

    fun pop(): Int {
        peek()
        return s2.removeFirst()
    }

    fun peek(): Int {
        if (s2.isEmpty()) {
            while (s1.isNotEmpty()) {
                s2.addFirst(s1.removeFirst())
            }
        }

        return s2.first()
    }

    fun empty(): Boolean = s1.isEmpty() && s2.isEmpty()
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */