package readinglist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//开启组件扫描
@SpringBootApplication
public class ReadinglistApplication {

	public static void main(String[] args) {
		//负责启动应用引导程序
		SpringApplication.run(ReadinglistApplication.class, args);
	}
}
