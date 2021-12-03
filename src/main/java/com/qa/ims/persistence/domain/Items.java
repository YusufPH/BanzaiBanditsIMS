package com.qa.ims.persistence.domain;

public class Items {
	
	private Long id;
	private String name;
	private Double value;
    private int stock;
	
	// constructors
	
	public Items(String name, int stock, Double value) {
		this.name = name;
        this.stock = stock;
		this.value = value;
	}
	
	public Items(long id, String name, int stock, Double value) {
		this(name, stock, value);
		this.id = id;
	}

	// getters and setters
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
    public int getStock() {
		return stock;
	}

	public void setStock(double value) {
		this.stock = stock;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Items other = (Items) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value) || stock != other.stock)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[id:" + id + " name:" + name + " stock: " + String.valueOf(stock) + " value:" + value.toString() + "]";
	}

}