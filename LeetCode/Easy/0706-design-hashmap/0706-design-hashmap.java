class MyHashMap {
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] nodes = new Node[10007];

    public void put(int key, int value) {
        int idx = key % nodes.length;

        if (nodes[idx] == null) {
            nodes[idx] = new Node(key, value);
            return;
        }

        Node curr = nodes[idx];

        while (curr != null) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }

            if (curr.next == null) {
                curr.next = new Node(key, value);
                return;
            }

            curr = curr.next;
        }
    }
    
    public int get(int key) {
        int idx = key % nodes.length;
        Node curr = nodes[idx];

        while (curr != null) {
            if (curr.key == key) {
                return curr.value;
            }

            curr = curr.next;
        }

        return -1;
    }
    
    public void remove(int key) {
        int idx = key % nodes.length;
        Node curr = nodes[idx];
        Node prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null) {
                    nodes[idx] = curr.next;
                } else {
                    prev.next = curr.next;
                }
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */