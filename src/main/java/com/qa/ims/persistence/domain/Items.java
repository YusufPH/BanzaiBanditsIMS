package com.qa.ims.persistence.domain;

public class Item {
	
	private Long id;
	private String name;
	private double value;
    private int stock;
	
	// constructors
	
	public Item(String name, int stock, double value) {
		this();
		this.name = name;
        this.stock = stock;
		this.value = value;
	}
	
	public Item(long id, String name, int stock, double value) {
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
		Item other = (Item) obj;
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
		} else if (!value.equals(other.value) || !stock.equals(other.stock))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[id:" + id + " name:" + name + " stock: " + stock.toString() + " value:" + value.toString() + "]";
	}

}