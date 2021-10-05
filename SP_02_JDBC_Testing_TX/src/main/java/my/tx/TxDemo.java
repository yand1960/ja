package my.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("txdemo")
public class TxDemo {

    @Autowired
    DataAppender appender;

    @Transactional()
    public void append3() {
        appender.append("YA - one");
        appender.append("YA - two");
        if (1 == 0)
            throw  new RuntimeException("TEST ERR");
        appender.append("YA - three");
    }

}
