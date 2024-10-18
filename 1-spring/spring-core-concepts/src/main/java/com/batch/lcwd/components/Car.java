package com.batch.lcwd.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	private Wheel wheel;
	// other fields

	public Car(@Qualifier(value = "MRF") Wheel wheel) {
		this.wheel = wheel;
	}


	public Wheel getWheel() {
		return wheel;
	}

	public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}

	@Override
	public String toString() {
		return "Car [wheel=" + wheel + "]";
	}

}
