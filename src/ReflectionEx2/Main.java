package ReflectionEx2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> constructor = clazz.getDeclaredConstructor();
        constructor.setAccessible(true);
        BlackBoxInt blackBoxInt = constructor.newInstance();

        List<Method> methods = Arrays.asList(clazz.getDeclaredMethods());
        Field innerValue = clazz.getDeclaredField("innerValue");
        innerValue.setAccessible(true);

        while(!input.equals("END")){
            String command = input.split("_")[0];
            int value = Integer.parseInt(input.split("_")[1]);
            Method currentMethod = getCurrentMethod(methods, command);
            currentMethod.setAccessible(true);
            currentMethod.invoke(blackBoxInt, value);
            System.out.println(innerValue.get(blackBoxInt));

            input = sc.nextLine();
        }
    }

    private static Method getCurrentMethod(List<Method> methods, String command) {
        for (Method method : methods) {
            if(method.getName().equals(command)){
                return method;
            }
        }
        return null;
    }
}

