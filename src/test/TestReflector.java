package test;

import java.lang.reflect.Constructor;

/**
 * @author boyang.lby
 * @date 11/8/19
 * @description
 */
public class TestReflector extends AbstractTestReflector{
    public String userName = "lby";

    public static class User{
    }

    private static <T> T getInstance(String className, Object... args) {
        try {
            Class<?> clazz = Class.forName(className);
            if (args.length == 0) {
                return (T)clazz.newInstance();
            } else {
                Class<?>[] parTypes = new Class<?>[args.length];
                Object[] parameters = new Object[args.length];

                for (int i = 0; i < args.length; i++) {
                    parTypes[i] = args[i].getClass();
                    parameters[i] = args[i];
                }
                Constructor<?> constructor = clazz.getConstructor(parTypes);

                return (T)constructor.newInstance(parameters);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[]args)throws Exception{
        AbstractTestReflector object = getInstance("test.TestReflector");
        //System.out.println((object).userName);
    }
}

abstract class AbstractTestReflector{

}

