package spring.core.practice.components;

public class HardDrive {

	private String name;
	private Long storage;

	public HardDrive() {
		super();
	}

	public HardDrive(String name, Long storage) {
		super();
		this.name = name;
		this.storage = storage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getStorage() {
		return storage;
	}

	public void setStorage(Long storage) {
		this.storage = storage;
	}

	@Override
	public String toString() {
		return "HardDrive [name=" + name + ", storage=" + storage + "GB]";
	}

}
