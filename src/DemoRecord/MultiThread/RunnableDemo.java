package DemoRecord.MultiThread;

public class RunnableDemo implements Runnable{
    private Thread t;
    private String threadName;

    public RunnableDemo(String name){
        threadName = name;
        System.out.println("creating "+ threadName);
    }

    @Override
    public void run() {
        System.out.println("Running " + threadName);
        try{
            Thread.sleep(400);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<5;i++){
            RunnableDemo r = new RunnableDemo("rd"+i);
            new Thread(r).start();
        }
    }
}
