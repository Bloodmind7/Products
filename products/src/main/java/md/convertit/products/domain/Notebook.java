package md.convertit.products.domain;

import java.util.Date;

/**
 * This class represents a Notebook object
 * @author Utilizator
 *
 */
public class Notebook {

	public static int stock;

	private Long id;
	private String type;
	private double price;
	private String info;
	private boolean ordered;
	private Date orderedDate;

	public Notebook() {
		super();
	}

	public Notebook(String type, double price, String info, boolean ordered, Date orderedDate) {
		super();
		
		this.type = type;
		this.price = price;
		this.info = info;
		this.ordered = ordered;
		this.orderedDate = orderedDate;
	}

	public static int getStock() {
		return stock;
	}

	public static void setStock(int stock) {
		Notebook.stock = stock;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public boolean isOrdered() {
		return ordered;
	}

	public void setOrdered(boolean ordered) {
		this.ordered = ordered;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", type=" + type + ", price=" + price + ", info=" + info + ", ordered=" + ordered
				+ ", orderedDate=" + orderedDate + "]";
	}

}
