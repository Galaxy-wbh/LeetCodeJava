package DemoRecord.MultiThread;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    BlockingQueue<Product> queue;

    public Producer(BlockingQueue<Product> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        //生产产品
        for (int i = 0; i < 100; i++) {
            Product p = new Product("product"+i);
            try{
                Thread.sleep(100);
                queue.put(p);
                System.out.println("生产了:" + p.getName());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        //添加推出消息
        Product msg = new Product("exit");
        try{
            queue.put(msg);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
