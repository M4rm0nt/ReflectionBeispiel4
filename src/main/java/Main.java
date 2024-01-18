import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Class<?> clazz = util.MyClass.class;

        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            clazz.getMethods()[0].invoke(instance);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            LOGGER.severe("Error: " + e.getMessage());
        }

        Method[] methods = clazz.getSuperclass().getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        System.out.println(clazz.describeConstable());
    }
}