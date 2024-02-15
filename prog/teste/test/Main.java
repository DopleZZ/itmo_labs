package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main{
    public static void main(String[] args){
        Invoker invoker = new Invoker("rr", (long) 5);

        Invoker invoker1 = new Invoker("gg", (long) 6);
         
        String methodName = "quas";
        try {
            Class clazz =  "Invoker".getClass();
            Method meth = clazz.getMethod(methodName);
            meth.invoke(clazz);
            //Method method = invoker.getClass().getMethod(methodName);
            //method.invoke(invoker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
}

         OrgCollection org = new OrgCollection();

        org.setO(invoker);

        org.setO(invoker1);
        
   
        System.out.println(org.get()[0]);
        System.out.println(org.get()[1]);
         

        
        //System.out.println(org.get());
        
        







    }
}