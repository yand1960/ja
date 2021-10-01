package my.logging;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class LogJreDemo {

    public static void main(String[] args) throws IOException {
        //Путь по умолчанию к файлу конфигурации логирования - в JRE
        // Если он скопирован в другое место,
        // требуется конфигурировать LogManager
        LogManager.getLogManager()
                .readConfiguration(
                        //new FileInputStream("E:\\USER_FILES\\JA\\JA08_Logging_Gradle\\src\\main\\resources\\logging.properties")
                        LogJreDemo.class.getResourceAsStream("../../logging.properties")
                );

        Logger logger = Logger.getLogger(LogJreDemo.class.getName());
        logger.info("It is info");
        logger.warning("It is warning");
        logger.severe("It is severe");
    }
}
