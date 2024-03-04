import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import enums.VladLoh;

import enums.VladLoh;

public class Main{
    public static void main(String[] args){
       

       
        String ewr = Arrays.toString(VladLoh.values()).substring(1, Arrays.toString(VladLoh.values()).length()-1);
        String[] array = ewr.split(", ");
        for (int i = 0; i<=array.length-1; i++){System.out.println(array[i]);}
        System.out.println(Arrays.toString(VladLoh.values()).substring(1, Arrays.toString(VladLoh.values()).length()-1).indexOf("kolokvium"));
        if(ewr.indexOf("kolokvium")==30){
            System.out.println("ads");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        /*Invoker invoker = new Invoker("rr", (long) 5);

        Invoker invoker1 = new Invoker("gg", (long) 6);
         
        /*String methodName = "quas";
        try {
            Class clazz =  Invoker.Class();
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
        
        */








    }
}