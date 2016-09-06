package spring.Bean;

import com.sun.istack.internal.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * Created by Snoob on 9/4/2016.
 */
@Component
public class ConsumerBean {
    private IBean message;
    @Autowired
    public ConsumerBean(@Qualifier("simpleBean") IBean message) {
        this.message = message;
    }
    @Autowired
    public void getMessage(@Qualifier("simpleBean") IBean message, @Qualifier("prototypeBean")IBean message2){
        System.out.println(message.getMessage());
        System.out.println(message2.getMessage());
    }
    public String getMessage() {
        return message.getMessage();
    }
}
