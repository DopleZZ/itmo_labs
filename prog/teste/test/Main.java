package test;

public class Main{
    public static void main(String[] args){
        Invoker invoker = new Invoker();
         /*
        String methodName = "quas";
        try {
            Method method = invoker.getClass().getMethod(methodName);
            method.invoke(invoker);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
}*/

        OrgCollection org = new OrgCollection();

        org.setO(invoker);
        
        
        org.get();

        System.out.println();







    }
}