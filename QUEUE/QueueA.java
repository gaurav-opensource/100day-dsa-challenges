import java.util.*;

class QueueA {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            this.size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        public static boolean isFull() {
            return rear == size - 1;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full. Cannot add " + data);
                return;
            }

            rear++;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot remove element.");
                return -1; // Indicate failure to remove
            }

            int front = arr[0];
            // Shift elements to the left
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear--;
            return front;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty. Cannot peek.");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.println("Front element: " + q.peek());
            q.remove();
        }
    }
}
