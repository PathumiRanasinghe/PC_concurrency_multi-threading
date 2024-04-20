import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SharedQueue {
    private BlockingQueue<PrintJob> queue;

    public SharedQueue(int capacity) {
        queue = new ArrayBlockingQueue<>(capacity);
    }

    public void addPrintJob(PrintJob job) {
        while (queue.size() >= 5) {
            try {
                System.out.println("Queue is full, waiting for space...");
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error while waiting for space in the queue: " + e.getMessage());
            }
        }

        if (job != null) {
            try {
                queue.put(job);
                System.out.println("Successfully added printjob to the queue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Attempted to add a null print job to the queue.");
        }
    }

    public PrintJob getPrintJob() {
        try {
            return queue.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Error retrieving print job from the queue: " + e.getMessage());
            return null;
        }
    }
    
}
