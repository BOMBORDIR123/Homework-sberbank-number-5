package Methods;

import java.lang.reflect.Method;

public class GetterPrinter {
    public static void printGetters(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("get") && method.getParameterCount() == 0) {
                System.out.println(method);
            }
        }
    }
}
