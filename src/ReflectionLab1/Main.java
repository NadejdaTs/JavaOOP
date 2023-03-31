package ReflectionLab1;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        //Class<?> reflection1 = Class.forName("Reflection"); - ClassNotFoundException
        /*Class<Reflection> clazz = Reflection.class;
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getTypeName());
        System.out.println(clazz.getSuperclass().getTypeName());
        System.out.println(clazz.getSuperclass().getSimpleName());*/

        Class reflection = Reflection.class;
        System.out.println(reflection);

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
            //System.out.println(anInterface.getSimpleName());
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
    }
}
