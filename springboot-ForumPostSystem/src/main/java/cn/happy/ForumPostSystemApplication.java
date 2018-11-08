package cn.happy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author：  刘涛
 *
 * @create 2018-10-25 14:23
 */
@SpringBootApplication
@MapperScan("cn.happy.*")
public class ForumPostSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(ForumPostSystemApplication.class,args);
    }
}
