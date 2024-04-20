public class Printer extends Thread {
    private int ID;
    private SharedQueue queue;

    public Printer(SharedQueue queue,int ID) {
        this.queue=queue;
        this.ID=ID;
    }

    @Override
    public void run() {
        processPrintJob();
    }

    public void processPrintJob() {
        PrintJob job = queue.getPrintJob();
        if (job != null) {
            try {
                if (job.getFileType().equals("txt")) {
                    System.out.println("Printing job on Printer ");
                    Thread.sleep(2000); // Simulate printing time
                } else {
                    throw new TypeNotSupportedException("Unsupported file type printed: " + job.getFileType());
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.err.println("Error during printing: " + e.getMessage());
            } catch (TypeNotSupportedException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
    
}
