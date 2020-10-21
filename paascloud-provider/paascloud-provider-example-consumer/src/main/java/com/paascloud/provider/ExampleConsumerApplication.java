package com.paascloud.provider;

import com.paascloud.swagger.annotation.EnableCustomSwagger2;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCustomSwagger2
@SpringCloudApplication
@EnableFeignClients(basePackages = "com.paascloud")
public class ExampleConsumerApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(ExampleConsumerApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  示例消费者模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
