package DemoRecord.MultiThread;


public class PrintABC1 {
    private int signal = 0;
    public synchronized void a(){
        while(signal%3 != 0){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("A");
        signal++;
        notifyAll();
    }
    public synchronized void b(){
        while(signal%3 != 1){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("B");
        signal++;
        notifyAll();
    }
    public synchronized void c(){
        while(signal%3 != 2){
            try{
                wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("C");
        signal++;
        notifyAll();
    }
    public static void main(String[] args) {
        PrintABC1 abc = new PrintABC1();
        new Thread(new PrintA(abc)).start();
        new Thread(new PrintB(abc)).start();
        new Thread(new PrintC(abc)).start();
    }


}
class PrintA implements Runnable{
    PrintABC1 demo;
    public PrintA(PrintABC1 demo){
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

class PrintB implements Runnable{
    PrintABC1 demo;
    public PrintB(PrintABC1 demo){
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

class PrintC implements Runnable{
    PrintABC1 demo;
    public PrintC(PrintABC1 demo){
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
