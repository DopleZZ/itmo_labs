package test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main{
    public static void main(String[] args){
        Invoker invoker = new Invoker();
        String methodName = "exort";
        try {
            Method method = invoker.getClass().getMethod(methodName);
            method.invoke(invoker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
}

    }
}