package com.batch.lcwd.components;

import org.springframework.stereotype.Component;

@Component
public class Wheel {
	private String brandName;

	public Wheel() {
		super();
	}

	public Wheel(String brandName) {
		super();
		this.brandName = brandName;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Wheel [brandName=" + brandName + "]";
	}

}
