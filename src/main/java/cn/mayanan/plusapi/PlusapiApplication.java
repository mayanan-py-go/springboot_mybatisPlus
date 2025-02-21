package cn.mayanan.plusapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.mayanan.plusapi.mapper")
public class PlusapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusapiApplication.class, args);
    }

}
