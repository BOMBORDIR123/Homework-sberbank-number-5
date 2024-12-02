package Methods;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ConstantChecker {
    public static void checkStringConstants(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getType() == String.class && Modifier.isStatic(field.getModifiers()) && Modifier.isFinal(field.getModifiers())) {
                try {
                    field.setAccessible(true);
                    String value = (String) field.get(null);
                    if (!value.equals(field.getName())) {
                        System.out.println("Constant " + field.getName() + " does not match its value!");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

