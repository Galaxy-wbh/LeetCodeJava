package DemoRecord.ClassLoaderDemo;

public class ClassLoadTest {
    public ClassLoadTest() {
    }

    public static void main(String[] args) {
        ClassLoadTest clt = new ClassLoadTest();
        Class clazz = clt.getClass();
        System.out.println(clazz);
        System.out.println(clazz.getClassLoader());
    }
}
