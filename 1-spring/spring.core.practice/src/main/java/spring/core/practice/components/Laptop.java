package spring.core.practice.components;

public class Laptop {

	private String name;
	private HardDrive hardDrive;

	public Laptop() {
		super();
	}

	public Laptop(String name, HardDrive hardDrive) {
		super();
		this.name = name;
		this.hardDrive = hardDrive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HardDrive getHardDrive() {
		return hardDrive;
	}

	public void setHarddrive(HardDrive hardDrive) {
		this.hardDrive = hardDrive;
	}

	@Override
	public String toString() {
		return "Laptop [name=" + name + ", hardDrive=" + hardDrive + "]";
	}

}
