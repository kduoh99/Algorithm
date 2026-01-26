class MyCircularQueue(k: Int) {
    val q = IntArray(k)
    var front = 0
    var rear = -1
    var count = 0

    fun enQueue(value: Int): Boolean {
        if (this.isFull()) return false

        this.rear = (this.rear + 1) % this.q.size
        this.q[rear] = value
        this.count++
        return true
    }

    fun deQueue(): Boolean {
        if (this.isEmpty()) return false

        this.front = (this.front + 1) % this.q.size
        this.count--
        return true;
    }

    fun Front(): Int = if (this.isEmpty()) -1 else this.q[this.front]

    fun Rear(): Int = if (this.isEmpty()) -1 else this.q[this.rear]

    fun isEmpty(): Boolean = this.count == 0

    fun isFull(): Boolean = this.count == this.q.size
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * var obj = MyCircularQueue(k)
 * var param_1 = obj.enQueue(value)
 * var param_2 = obj.deQueue()
 * var param_3 = obj.Front()
 * var param_4 = obj.Rear()
 * var param_5 = obj.isEmpty()
 * var param_6 = obj.isFull()
 */