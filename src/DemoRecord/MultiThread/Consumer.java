package DemoRecord.MultiThread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    BlockingQueue<Product> queue;

    public Consumer(BlockingQueue<Product> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try{
            Product p;
            while(!(p = queue.take()).getName().equals("exit")){
                Thread.sleep(10);
                System.out.println("消费" + p.getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
