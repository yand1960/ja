package my.tests;

import my.dal.Product;
import my.dal.Repository;
import my.tx.DataAppender;
import my.tx.TxDemo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:spring-tx-demo.xml")
public class DataAppenderTest {

    @Autowired
    DataAppender appender;

    @Autowired
    TxDemo txDemo;

    @Test
    public void appendTest(){
        appender.append("YA");
    }

    @Test
    //@Transactional //для тестового метода это откатит трансакцию
    public void append3Test(){
        txDemo.append3();
    }
}
