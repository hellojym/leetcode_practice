
class MyQueue {

    String[] table;
    int head = 0;
    int tail = 0;

    public MyQueue(int capacity) {
        table = new String[capacity];
    }
    // t h
    // 3,4,5,1,2,7,8,9,6

    public boolean enqueue(String val) {
        if (isFull()) {
            return false;
        } else {
            table[tail] = val;
            tail++;
            tail = tail % table.length;
            return true;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            return "empty";
        }
        String val = table[head];
        head++;
        return val;

    }

    private boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        if (tail >= head) {
            if (tail == table.length - 1 && head == 0) {
                return true;
            }
            return false;
        }
        return (tail + 1) % table.length >= head;
    }
}