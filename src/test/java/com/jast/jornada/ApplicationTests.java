package com.jast.jornada;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@SpringBootTest
@ComponentScan(basePackages = {"package com.jast.jornada.milhas"})
class ApplicationTests {

	@Test
	void contextLoads() {
	}

}
