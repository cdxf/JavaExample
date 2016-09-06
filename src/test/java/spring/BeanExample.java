package spring;

import org.springframework.beans.factory.annotation.Qualifier;
import spring.Bean.ConsumerBean;
import spring.Bean.IBean;
import spring.Bean.SimpleBean;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by Snoob on 9/2/2016.
 */
public class BeanExample {
    private GenericXmlApplicationContext ctx;
    @Before
    public void setUp() throws Exception {

        ctx = new GenericXmlApplicationContext("Context.xml");
    }

    @Test
    public void SimpleBeanTest() {
        IBean bean = (IBean) ctx.getBean("simpleBean");
        bean.setMessage("HelloWorld");
        Assert.assertEquals("HelloWorld",bean.getMessage());
    }
    @Test
    public void AnnotationBeanTest() {
        IBean bean = (IBean) ctx.getBean("customBean");
        IBean bean2 = (IBean) ctx.getBean("customBean");
        Assert.assertEquals("AnnotationBean",bean.getMessage());
        Assert.assertNotSame(bean,bean2);

    }
    @Test
    public void AutoWiredTest(){
        ConsumerBean bean = ctx.getBean(ConsumerBean.class);
        System.out.println(bean.getMessage());
    }
    @Test
    public void BeanSingletonTest(){
        SimpleBean bean1 = (SimpleBean) ctx.getBean("simpleBean");
        SimpleBean bean2 = (SimpleBean) ctx.getBean("simpleBean");
        bean1.setMessage("spring.Bean 1");
        bean2.setMessage("spring.Bean 2");
        Assert.assertEquals(bean1.getMessage(),bean2.getMessage());
        Assert.assertSame(bean1.getMessage(),bean2.getMessage());
    }
    @Test
    public void BeanPrototypeTest(){
        SimpleBean bean1 = (SimpleBean) ctx.getBean("prototypeBean");
        SimpleBean bean2 = (SimpleBean) ctx.getBean("prototypeBean");
        bean1.setMessage("spring.Bean 1");
        bean2.setMessage("spring.Bean 2");
        Assert.assertNotEquals(bean1.getMessage(),bean2.getMessage());
    }

}
