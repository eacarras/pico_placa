package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import tda.UserCar;

class UserCarTest {

	@Test
	void testCant_drive() {
		UserCar user = new UserCar("ASD-1051", "monday", "08:00");
		int resultadoReal;
		if(!user.can_drive()) resultadoReal = 0;
		else resultadoReal = 1;

		int resultadoEsperado = 0;
		
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
	}
	
	@Test
	void testCan_drive() {
		UserCar user = new UserCar("ASD-1051", "tuesday", "08:00");
		int resultadoReal;
		if(user.can_drive()) resultadoReal = 0;
		else resultadoReal = 1;

		int resultadoEsperado = 0;
		
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
	}
	
	@Test
	void testCan_drive_weekend() {
		UserCar user = new UserCar("ASD-1051", "saturday", "08:00");
		int resultadoReal;
		if(user.can_drive()) resultadoReal = 0;
		else resultadoReal = 1;

		int resultadoEsperado = 0;
		
		assertEquals(resultadoEsperado, resultadoReal, 0.01);
	}
}
