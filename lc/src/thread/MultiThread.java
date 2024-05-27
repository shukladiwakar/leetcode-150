package thread;

public class MultiThread {
    int counter = 1;
    static int N;

    public static void main(String[] args) {
        N = 10;
        MultiThread multiThread = new MultiThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread.printEvenNumber();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                multiThread.printOddNumber();
            }
        });

        t1.start();
        t2.start();


    }

    public void printOddNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {

                    try {
                        wait();
                    } catch (Exception exception) {

                    }
                }
                System.out.println(counter + " ");
                counter++;

                notify();
            }
        }
    }

    public void printEvenNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (Exception exception) {

                    }
                }
                System.out.println(counter + " ");
                counter++;
                notify();
            }
        }
    }


}

class ThredDemo implements Runnable {

    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception exception) {
            System.out.println("Exception is caught");

        }
    }
}

class ThreadDemo extends Thread {
    @Override
    public void run() {
        try {
            // Displaying the thread that is running
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception exception) {
            System.out.println("Exception is caught");

        }
    }
}