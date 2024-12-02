package Methods;

import java.lang.reflect.Method;

public class MethodPrinter {
    public static void printAllMethods(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }
}
