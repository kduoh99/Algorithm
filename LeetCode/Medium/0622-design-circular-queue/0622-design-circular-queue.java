class MyCircularQueue {
    int[] q;
    int front, rear, count;

    public MyCircularQueue(int k) {
        this.q = new int[k];
        this.front = 0;
        this.rear = -1;
        this.count = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;

        rear = (rear + 1) % q.length;
        q[rear] = value;
        count++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;

        front = (front + 1) % q.length;
        count--;
        return true;
    }

    public int Front() {
        return (isEmpty() ? -1 : q[front]);
    }

    public int Rear() {
        return (isEmpty() ? -1 : q[rear]);
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == q.length;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */