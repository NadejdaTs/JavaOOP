package ReflectionLab3;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static <Fields> void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class clazz = Reflection.class;
        Field[] declareFields = clazz.getDeclaredFields();
        Arrays.stream(declareFields)
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> {
                    if(!Modifier.isPrivate(f.getModifiers())){
                        System.out.printf("%s must be private!%n", f.getName());
                    }
                });

        Method[] declareMethods = clazz.getDeclaredMethods();
        Method[] getters = Arrays.stream(declareMethods)
                .filter(m -> m.getName().startsWith("get") && m.getParameterCount() == 0)
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(getters).forEach(m -> {
            if(!Modifier.isPublic(m.getModifiers())){
                System.out.printf("%s have to be public!%n", m.getName());
            }
        });

        Method[] setters = Arrays.stream(declareMethods)
                .filter(m -> m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .toArray(Method[]::new);

        Arrays.stream(setters).forEach(m -> {
            if(!Modifier.isPrivate(m.getModifiers())){
                System.out.printf("%s have to be private!%n", m.getName());
            }
        });

        /*for (Method m : declareMethods) {
            System.out.println(Modifier.toString(m.getModifiers()) + " " + m.getName());
        }*/
    }
}

