package spring.Bean;

import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Created by Snoob on 9/4/2016.
 */
@Component("customBean")
@Scope(value="prototype")
public class AnnotationBean implements IBean{
    @Override
    public String getMessage() {
        return "AnnotationBean";
    }

    @Override
    public void setMessage(String message) {
    }
}
