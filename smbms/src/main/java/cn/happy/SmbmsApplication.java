package cn.happy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * author：  刘涛
 *
 * @create 2018-11-02 9:17
 */
@SpringBootApplication
@MapperScan("cn.happy.*")
public class SmbmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(SmbmsApplication.class,args);
    }
}
