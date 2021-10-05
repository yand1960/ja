package my.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("appender")
public class DataAppender {

    @Autowired
    JdbcTemplate db;

    @Transactional
    public void append(String data) {
        String sql = "INSERT Junk(Data) VALUES(?)";
        db.update(sql,data);
    }
}
