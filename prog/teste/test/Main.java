package test;

public class Main{
    public static void main(String[] args){
        Invoker invoker = new Invoker("rr");

        Invoker invoker1 = new Invoker("gg");
         /* 
        String methodName = "quas";
        try {
            Method method = invoker.getClass().getMethod(methodName);
            method.invoke(invoker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
}
*/
         OrgCollection org = new OrgCollection();

        org.setO(invoker);

        org.setO(invoker1);
        
   
        System.out.println(org.get()[0]);
        System.out.println(org.get()[1]);
         

        
        //System.out.println(org.get());
        
        







    }
}