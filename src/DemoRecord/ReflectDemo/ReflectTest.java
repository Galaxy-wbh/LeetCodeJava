package DemoRecord.ReflectDemo;


import java.lang.reflect.Field;

public class ReflectTest {
    private int v1;
    private String name;

    public ReflectTest(){
        v1 = 1;
        name = "test";
    }

    public static void main(String[] args) {
        try {
            Class<?> clazz = new ReflectTest().getClass();
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                field.setAccessible(true);
                System.out.println(field.getName()+":"+field.get(clazz.newInstance()));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
