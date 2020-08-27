package DemoRecord.MultiThread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC2 {
    private int signal = 0;
    public Lock rl = new ReentrantLock();
    public Condition ca = rl.newCondition();
    public Condition cb = rl.newCondition();
    public Condition cc = rl.newCondition();
    public void a(){
        rl.lock();
        while(signal%3 != 0){
            try{
                ca.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("A");
        signal++;
        cb.signal();
        rl.unlock();
    }

    public void b(){
        rl.lock();
        while(signal%3 != 1){
            try{
                cb.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("B");
        signal++;
        cc.signal();
        rl.unlock();
    }
    public void c(){
        rl.lock();
        while(signal%3 != 2){
            try{
                cc.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("C");
        signal++;
        ca.signal();
        rl.unlock();
    }

    public static void main(String[] args) {
        PrintABC2 abc = new PrintABC2();
        new Thread(new PrintA2(abc)).start();
        new Thread(new PrintB2(abc)).start();
        new Thread(new PrintC2(abc)).start();

    }
}
class PrintA2 implements Runnable{
    PrintABC2 demo;
    public PrintA2(PrintABC2 demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true){
            demo.a();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class PrintB2 implements Runnable{
    PrintABC2 demo;
    public PrintB2(PrintABC2 demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true){
            demo.b();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class PrintC2 implements Runnable{
    PrintABC2 demo;
    public PrintC2(PrintABC2 demo){
        this.demo = demo;
    }

    @Override
    public void run() {
        while(true){
            demo.c();
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

