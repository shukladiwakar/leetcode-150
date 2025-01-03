package threads;

public class PingPong {

    private static final int numberOfTimes = 10;
    private static volatile boolean isPing = true;

    public static void main(String[] args) {
        Thread pingThread = new Thread(() -> {
            for (int i = 0; i < numberOfTimes; i++) {
                synchronized (PingPong.class) {
                    while (!isPing) {
                        try {
                            PingPong.class.wait();
                        } catch (InterruptedException exception) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Ping Baba");
                    isPing = false;
                    PingPong.class.notifyAll();
                }
            }
        });

        Thread pongThread = new Thread(() -> {
            for (int i = 0; i < numberOfTimes; i++) {
                synchronized (PingPong.class) {
                    while (isPing) {
                        try {
                            PingPong.class.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                    System.out.println("Pong Baba");
                    isPing = true;
                    PingPong.class.notifyAll();
                }
            }
        });

        pingThread.start();
        pongThread.start();

        try {
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
    }
}
