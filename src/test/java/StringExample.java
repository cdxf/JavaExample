import org.junit.Before;
import org.junit.Test;

import java.io.*;

/**
 * Created by Snoob on 9/6/2016.
 */
public class StringExample {
    File file;
    @Before
    public void setUp() throws Exception {
        file = new File("medium.txt");

    }
    @Test
    public void StringTest() throws IOException {
        String s = "";
        FileReader  stream = new FileReader(file);
        int byteReaded;
        while((byteReaded = stream.read()) != -1){
            s = s + String.valueOf(Character.toChars(byteReaded));
        }
        System.out.println(s);
    }
    @Test
    public void StringBuilderTest() throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader  stream = new FileReader(file);
        int byteReaded;
        while((byteReaded = stream.read()) != -1){
            sb.appendCodePoint(byteReaded);
        }
        System.out.println(sb);
    }
}
