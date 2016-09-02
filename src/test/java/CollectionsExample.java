import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Snoob on 9/2/2016.
 */
public class CollectionsExample {
    String text;
    @Before
    public void setUp() throws Exception {
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit";

    }
    @Test
    public void listToArray(){
        List<Character> list = new ArrayList<>();
        for(char c : text.toCharArray()){
            list.add(c);
        }
        Character[] objects = new Character[text.length()];
        list.toArray(objects);
        for(char c : objects){
            System.out.print(c);
        }
    }
    @Test
    public void arrayToList(){
        Character[] list = new Character[text.length()];
        for (int i = 0; i < list.length; i++) {
            list[i] = text.charAt(i);
        }
        List<Character> objects = Arrays.asList(list);
        for(Character c : objects){
            System.out.print(c);
        }
    }
}
