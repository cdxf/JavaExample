import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by Snoob on 9/2/2016.
 */
public class StreamExample {
    @Test
    public void FileStreamTest(){
        try (FileInputStream fileInputStream = new FileInputStream("test.txt"))
        {
            int byteReaded;
            while((byteReaded = fileInputStream.read()) != -1){
                System.out.println(byteReaded + " - " + (char) byteReaded);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
