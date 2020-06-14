package DemoRecord.StaticDemo;

public class Father {
    /**
     * 测试static能否被重写
     */
    public Father(){}
    public static void say(){
        System.out.println("father");
    }

    public static void main(String[] args) {
        Father f = new Father();
        Father s = new Son();
        f.say();
        s.say();
    }
}

class Son extends Father{
    public Son(){}
    public static void say(){
        System.out.println("son");
    }
}
