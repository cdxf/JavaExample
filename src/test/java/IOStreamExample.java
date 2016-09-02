import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Snoob on 9/2/2016.
 */
public class IOStreamExample {
    File bigfile;
    @Before
    public void setUp() throws Exception {

        bigfile = new File("big.txt");
    }

    @Test
    public void FileStreamTest(){

        try (FileInputStream fileInputStream = new FileInputStream(bigfile))
        {
            int byteRead;
            while((byteRead = fileInputStream.read()) != -1){
                System.out.print((char)byteRead);
            }
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void BufferedTest(){
        try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(bigfile)))
        {
            int byteRead;
            while((byteRead = fileInputStream.read()) != -1){
                System.out.print((char)byteRead);
            }
            System.out.println();
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ReaderTest(){
        try(Reader reader = new BufferedReader(new FileReader(bigfile));) {
            int byteRead;
            while((byteRead = reader.read()) != -1){
                System.out.print((char)byteRead);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void ScannerTest(){
        try(Scanner scanner = new Scanner(new FileInputStream(bigfile))) {
            scanner.useDelimiter(System.lineSeparator());
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void BufferedScannerTest(){
        try(Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream(bigfile)))) {
            scanner.useDelimiter(System.lineSeparator());
            while(scanner.hasNext()){
                System.out.println(scanner.next());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
