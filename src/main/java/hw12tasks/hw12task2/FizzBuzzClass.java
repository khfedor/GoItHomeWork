package hw12tasks.hw12task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FizzBuzzClass {


    private int n;
    private BlockingQueue<String> queue = new LinkedBlockingQueue<>();

    public FizzBuzzClass(int n) {
        this.n = n;
    }

    public void fizz() throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                queue.put("fizz");
            }
        }
    }

    public void buzz() throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                queue.put("buzz");
            }
        }
    }

    public void fizzbuzz() throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            queue.put("fizzbuzz");
        }
    }

    public void number() throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            try {
                if (i % 3 != 0 && i % 5 != 0) {
                    System.out.println(i);
                } else {
                    System.out.println(queue.take());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        FizzBuzzClass fizzBuzz = new FizzBuzzClass(15);


        Thread threadA = new Thread(() -> {
            try {
                fizzBuzz.fizz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                fizzBuzz.buzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                fizzBuzz.number();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

     threadA.start();
     threadB.start();
     threadC.start();
     threadD.start();
     try {
         threadA.join();
         threadB.join();
         threadC.join();
         threadD.join();
     }catch (RuntimeException e){
         e.printStackTrace();
     }finally {
         System.err.println("потік A " + threadA.isAlive());
         System.err.println("потік B " + threadB.isAlive());
         System.err.println("потік C " + threadC.isAlive());
         System.err.println("потік D " + threadD.isAlive());
     }


    }
}