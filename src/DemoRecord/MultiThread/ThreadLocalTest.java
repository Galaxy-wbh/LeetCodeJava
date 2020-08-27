package DemoRecord.MultiThread;

public class ThreadLocalTest {
    public static void main(String[] args) {

        Thread t1 = new Thread(new MyRunnable(), "A");
        Thread t2 = new Thread(new MyRunnable(), "B");
        t1.start();
        t2.start();
    }
}
class MyRunnable implements Runnable {
    private ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    @Override
    public void run() {
        threadLocal.set((int) (Math.random() * 100D));
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }
}