package com.limito.payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {
	"com.limito.payment", // 본인 서비스
	"com.limito.common" // jitpack common 패키지
})
@EnableFeignClients
public class LimitoPaymentsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitoPaymentsApplication.class, args);
	}

}
