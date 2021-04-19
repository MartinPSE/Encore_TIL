package servlet.model;

public class ProductVO {
	
	private String name;
	private int price;
	private String desc;
	
	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVO(String name, int price, String desc) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", price=" + price + ", desc=" + desc + "]";
	}
	
	

	
	
}
