package com.example.employee;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CarTests {
	@Test
	void calculateTotalCostByBrandReturnsCorrectValue() {
		Integer cars = 50;
		Car car = new Car();
		car.setPrice(250000);
		car.setBrand("Volvo");
		car.setModel("XC90");
		car.setCarReg("ABC123");

		assertThat( car.totalCostByBrand(cars)).isEqualTo(12500000);

	}

}
