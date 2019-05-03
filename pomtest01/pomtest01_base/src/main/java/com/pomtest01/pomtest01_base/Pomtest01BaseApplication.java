package com.pomtest01.pomtest01_base;

import com.pomtest01.pomtest01_common.util.IdWorker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
//(exclude = {DataSourceAutoConfiguration.class})
@SpringBootApplication
public class Pomtest01BaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pomtest01BaseApplication.class, args);
    }
    @Bean
    public IdWorker idWorker(){
        return new IdWorker(1,1);
    }

}
