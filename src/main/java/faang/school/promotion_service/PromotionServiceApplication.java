package faang.school.promotion_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients(basePackages = "faang.school.promotion_service.client")
@EnableScheduling
public class PromotionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionServiceApplication.class, args);
	}

}
