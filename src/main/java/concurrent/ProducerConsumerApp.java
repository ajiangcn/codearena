package concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerApp {

    static class Producer implements Runnable {
        private ArrayBlockingQueue queue;

        Producer(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            int messageId = 0;
            while(true) {
                int size = new Random().nextInt(10)+1;
                List<String> messages = new ArrayList<String>(size);
                for(int i=0; i<size; i++) {
                    messages.add(String.format("Message %d", messageId++));
                }
                queue.add(messages);
                try {
                    Thread.sleep((new Random().nextInt(20)+1) * 1000);
                } catch (InterruptedException e) {
                    // finish the produce job
                    return;
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private ArrayBlockingQueue queue;

        Consumer(ArrayBlockingQueue queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                System.out.println(queue.remove());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // finish the consume job
                    return;
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(5);
        Thread pt = new Thread(new Producer(queue));
        Thread ct = new Thread(new Consumer(queue));

        System.out.println("Start the simulation.");
        pt.start();
        ct.start();

        Thread.sleep(1000);
        pt.interrupt();
        ct.interrupt();
        System.out.println("Finish the simulation.");
    }
}
