class MyHashMap() {
    class Node(var key: Int, var value: Int) {
        var next: Node? = null
    }

    val nodes = arrayOfNulls<Node>(10007)

    fun put(key: Int, value: Int) {
        val idx = key % nodes.size

        if (nodes[idx] == null) {
            nodes[idx] = Node(key, value)
            return
        }

        var curr = nodes[idx]

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value
                return
            }

            if (curr.next == null) {
                curr.next = Node(key, value)
                return
            }

            curr = curr.next
        }
    }

    fun get(key: Int): Int {
        val idx = key % nodes.size
        var curr = nodes[idx]

        while (curr != null) {
            if (curr.key == key) {
                return curr.value
            }

            curr = curr.next
        }

        return -1
    }

    fun remove(key: Int) {
        val idx = key % nodes.size
        var curr = nodes[idx]
        var prev: Node? = null

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    nodes[idx] = curr.next
                } else {
                    prev.next = curr.next
                }
                return
            }

            prev = curr
            curr = curr.next
        }
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */