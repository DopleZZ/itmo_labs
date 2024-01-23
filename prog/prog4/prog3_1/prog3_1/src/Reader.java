import Errors.FileReadException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interfaces.TitleReader;

class Reader implements TitleReader{

    @Override
    public void read() throws FileReadException{
        try {
            BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
            String line;
            line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch (IOException e) {
            throw new FileReadException("Здесь должно было быть название произведения, но возникла ошибка, и название потерялось:( - расстроенно говорит FileReadException");
        }
    }

}
