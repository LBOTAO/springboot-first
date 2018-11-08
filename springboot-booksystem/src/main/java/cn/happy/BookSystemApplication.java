package cn.happy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author：  刘涛
 *
 * @create 2018-10-18 8:42
 */
@SpringBootApplication
@MapperScan("cn.happy.*")
public class BookSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookSystemApplication.class,args);
    }
}
