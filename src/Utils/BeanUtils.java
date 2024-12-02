package Utils;

import java.lang.reflect.Method;

public class BeanUtils {
    public static void assign(Object to, Object from) {
        Method[] getterMethods = from.getClass().getMethods();
        Method[] setterMethods = to.getClass().getMethods();

        for (Method getter : getterMethods) {
            if (getter.getName().startsWith("get") && getter.getParameterCount() == 0) {
                String setterName = "set" + getter.getName().substring(3);
                for (Method setter : setterMethods) {
                    if (setter.getName().equals(setterName) && setter.getParameterCount() == 1) {
                        if (setter.getParameterTypes()[0].isAssignableFrom(getter.getReturnType())) {
                            try {
                                setter.invoke(to, getter.invoke(from));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}


