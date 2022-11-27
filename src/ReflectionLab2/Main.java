package ReflectionLab2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        /* Lab1
        Class reflection = Reflection.class;
        System.out.println(reflection);

        Class superClass = reflection.getSuperclass();
        System.out.println(superClass);

        Class[] interfaces = reflection.getInterfaces();

        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }

        Object reflectionObject = reflection.getDeclaredConstructor().newInstance();
        System.out.println(reflectionObject);
         */
        /*test
        Class clazz = Reflection.class;
        Constructor<Reflection> ctor = clazz.getDeclaredConstructor(
                String.class, String.class, String.class
        );

        ctor.setAccessible(true); //because of private access to the constructor

        Reflection reflection = ctor.newInstance("Name", "Web address", "example@example.com");
        System.out.println(reflection.toString());

        Field field = clazz.getDeclaredField("zip");
        field.setAccessible(true);
        /*Class<?> type = field.getType();
        System.out.println(type);
        Class<String> strClass = String.class;
        System.out.println(strClass);
        Field[] fields = clazz.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getType().toString());
        }
        Reflection ref = new Reflection();

        int zip = (int)field.get(ref);
        field.set(ref,152);
        System.out.println(ref.getZip());
*/
        //Lab 2
        Class clazz = Reflection.class;
        Method[] declareMethods = clazz.getDeclaredMethods();

        Method[] getters = Arrays.stream(declareMethods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(m ->
                System.out.printf("%s will return class %s%n", m.getName(), m.getReturnType().getName()));

        Method[] setters = Arrays.stream(declareMethods)
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(m ->
                System.out.printf("%s and will set field of %s%n", m.getName(), formatType(m.getParameterTypes()[0])));
    }

    public static String formatType(Class<?> type){
        return type == int.class ? "class " + type : type.toString();
    }
}
