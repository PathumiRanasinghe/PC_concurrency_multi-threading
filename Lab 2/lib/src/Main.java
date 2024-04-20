public class Main {

    public static void main(String[] args) {
        SharedQueue queue = new SharedQueue(5);
        
        Thread thread1=new Thread(new Computer(1,"text1.txt",queue));
        Thread thread2=new Thread(new Computer(2,"text2.txt",queue));
        Thread thread3=new Thread(new Computer(2,"text3.pdf",queue));

        thread1.start();
        thread2.start();
        thread3.start();

        Printer printer1 = new Printer(queue,1);
        Printer printer2 = new Printer(queue,2);

        printer1.start();
        printer2.start();
    }

}
