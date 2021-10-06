package my.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

//Заготовка всего этого проекта генерируется
// на сайте "spring boot initializr"

@SpringBootApplication
@ImportResource({"classpath:spring-config.xml",
					"classpath:spring-security-config.xml"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	//@Scope("singleton") //по умолчанию
	//@Scope("prototype")
	@Scope(value="session",proxyMode = ScopedProxyMode.TARGET_CLASS)
	//  @Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public CounterBean counter() {
		return new CounterBean();
	}
}
