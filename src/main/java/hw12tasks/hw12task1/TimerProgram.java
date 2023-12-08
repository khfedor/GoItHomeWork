package hw12tasks.hw12task1;

class SecondTimerThread extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (true) {

            System.out.println("second " + i);
            try {
                sleep(1000);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class EveryFiveSecondThread extends Thread {
    @Override
    public void run() {
        while (true) {
            try {
                sleep(5000);
                System.err.println("5 seconds have come");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class TimerProgram {
    public static void main(String[] args) {

        SecondTimerThread timeThread = new SecondTimerThread();

        EveryFiveSecondThread messageThread = new EveryFiveSecondThread();

        timeThread.start();
        messageThread.start();
    }
}