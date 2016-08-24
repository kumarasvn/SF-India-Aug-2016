package threads;

public class BrokenThreads {

    static class MyInteger {
        int x;
    }
    
    public static void main(String[] args) throws Throwable {
        class MyRunnable implements Runnable {

            private MyInteger count = new MyInteger(); 
            { count.x = 0; }
            private MyInteger count1 = new MyInteger();
            { count1.x = 0; }

            @Override
            public void run() {
                for (int i = 0; i < 1_000; i++) {
                    // NOTE Usually, synchronize on "this", but
                    // can reasonably safely synchronize on a
                    // "subset" of this if there is no transactional
                    // relationship between the subset pieces in use.
                    synchronized (count) {
                        count.x++;
                    }
                    synchronized (count1) {
                        count1.x++;
                    }
                }
            }
        }

        MyRunnable mr = new MyRunnable();

        Thread t1 = new Thread(mr);
        t1.start();
        Thread t2 = new Thread(mr);
        t2.start();

        t1.join();
        t2.join();
        System.out.println("count is " + mr.count);
    }
}
