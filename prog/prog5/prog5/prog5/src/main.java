import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CommanderExecuter Executer = new CommanderExecuter();

        
        while (true) {
            String command = reader.readLine();
            Executer.execute(command);
            }
    }
}
