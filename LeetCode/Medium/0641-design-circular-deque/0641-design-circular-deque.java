class MyCircularDeque {
    static class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head, tail;
    int count, k;

    public MyCircularDeque(int k) {
        this.count = 0;
        this.k = k;
        head = new Node(0);
        tail = new Node(0);
        // 연결
        head.next = tail;
        tail.prev = head;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;

        Node node = new Node(value);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        count++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;

        Node node = new Node(value);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
        count++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;

        head.next = head.next.next;
        head.next.prev = head;
        count--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;

        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
        count--;
        return true;
    }
    
    public int getFront() {
        return isEmpty() ? -1 : head.next.val;
    }
    
    public int getRear() {
        return isEmpty() ? - 1 : tail.prev.val;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public boolean isFull() {
        return count == k;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */