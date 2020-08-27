package DemoRecord;

import java.lang.reflect.Constructor;

public class Singleton {
    private static volatile Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        try{
            Constructor con = Singleton.class.getDeclaredConstructor();
            con.setAccessible(true);
            Singleton s1 = (Singleton)con.newInstance();
            Singleton s2 = (Singleton)con.newInstance();
            Singleton s3 = Singleton.getInstance();
            Singleton s4 = Singleton.getInstance();
            System.out.println(s1==s2);
            System.out.println(s3==s4);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
