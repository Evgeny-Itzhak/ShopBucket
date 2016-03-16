package home.model;

import org.hibernate.validator.constraints.NotEmpty;

public class Item {
	private int id;

	@NotEmpty(message = "You have to select something!")
	private String model;

	@NotEmpty(message = "You have to select something!")
	private String memory;

	@NotEmpty(message = "You have to select something!")
	private String color;

	public Item() {
	}

	public Item(String model, String memory, String color) {
		this.model = model;
		this.memory = memory;
		this.color = color;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMemory() {
		return memory;
	}

	public void setMemory(String memory) {
		this.memory = memory;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Item{" +
				"id=" + id +
				", model='" + model + '\'' +
				", memory='" + memory + '\'' +
				", color='" + color + '\'' +
				'}';
	}
}