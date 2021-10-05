package my.tests;

import my.dal.Product;
import my.dal.Repository;
import my.tx.DataAppender;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-tx-demo.xml")
public class DataAppenderTest {

    @Autowired
    DataAppender appender;

    @Test
    public void appendTest(){
        appender.append("YA");
    }
}
