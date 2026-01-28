class MyCircularDeque(k: Int) {
    class Node(var `val`: Int) {
        var prev: Node? = null
        var next: Node? = null
    }

    val head = Node(0)
    val tail = Node(0)
    var count = 0
    var k = k

    init {
        head.next = tail
        tail.prev = head
    }

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false

        val node = Node(value)
        node.next = head.next
        node.prev = head
        head.next!!.prev = node
        head.next = node
        count++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false

        val node = Node(value)
        node.prev = tail.prev
        node.next = tail
        tail.prev!!.next = node
        tail.prev = node
        count++
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false

        head.next = head.next!!.next
        head.next!!.prev = head
        count--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false

        tail.prev = tail.prev!!.prev
        tail.prev!!.next = tail
        count--
        return true
    }

    fun getFront(): Int {
        return if (isEmpty()) -1 else head.next!!.`val`
    }

    fun getRear(): Int {
        return if (isEmpty()) -1 else tail.prev!!.`val`
    }

    fun isEmpty(): Boolean = count == 0

    fun isFull(): Boolean = count == k
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * var obj = MyCircularDeque(k)
 * var param_1 = obj.insertFront(value)
 * var param_2 = obj.insertLast(value)
 * var param_3 = obj.deleteFront()
 * var param_4 = obj.deleteLast()
 * var param_5 = obj.getFront()
 * var param_6 = obj.getRear()
 * var param_7 = obj.isEmpty()
 * var param_8 = obj.isFull()
 */