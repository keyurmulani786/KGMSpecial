/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread;

/**
 *
 * @author keyur
 */
import java.util.ArrayList;
import java.util.List;

public class Summation1 {
    public static int BIG_NR;
    public static int NR_THREADS;
    public static long bigSum;

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("You should specify the number "
                    + "of threads and BIG_NR. Call me like this:\n"
                    + "java -jar RaceCondition.jar 5 20000\n"
                    + "This will create 5 Threads which try to count"
                    + "up to 2000000.\n" + "-v will show status "
                    + "information ");
            return;
        }

        boolean verbose = false;

        if (args.length > 2) {
            verbose = true;
        }

        NR_THREADS = Integer.parseInt(args[0]);
        BIG_NR = Integer.parseInt(args[1]);

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < NR_THREADS; i++) {
            Runnable task = new Sum(BIG_NR);
            Thread worker = new Thread(task);
            worker.start();
            threads.add(worker);
        }

        int running = 0;
        do {
            running = 0;
            for (Thread thread : threads) {
                if (thread.isAlive()) {
                    running++;
                }
            }

            if (verbose) {
                System.out.println("Remaining threads: " + running);
            }
        } while (running > 0);

        System.out.println(bigSum);

    }
}

class Sum implements Runnable {
    private final int UpperEnd;

    public Sum(int upperEnd) {
        UpperEnd = upperEnd;
    }

    @Override
    public void run() {
        for (int i = 0; i < UpperEnd; i++) {
//            bigSum++;
        }
    }
}