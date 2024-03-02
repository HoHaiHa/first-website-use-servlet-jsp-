package model;
import java.sql.Blob;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity(name = "product")
@Table(name = "product")
public class ProductModel {
	@Id
	@Column(name="[proId]")
	@GeneratedValue
	private int proId;
	@Column(name="[proName]")
	private String proName;
	@Column(name="[image]")
	private Blob image;
	@Column(name="[material]")
	private String material;
	@Column(name="[color]")
	private String color;
	@Column(name="[describe]")
	private String describe;
	@Column(name="[shape]")
	private String shape;
	@Column(name="[branch]")
	private String branch;
	@Column(name="[feature]")
	private String feature;
	@Column(name="[price]")
	private BigDecimal price;
	@Column(name="[hot]")
	private String hot;
	@Column(name = "new")
	private String newness;
	@Column(name="[discounts]")
	private int discounts;
	@Column(name="[quantity]")
	private Integer quantity;
	@Column(name="[category]")
	private String category;
	
	//constructor
	public ProductModel(int proId, String proName, Blob image, String material, String color, String describe,
			String shape, String branch, String feature, BigDecimal price, String hot, String newness,
			int discounts,int quantity, String category) {
		super();
		this.proId = proId;
		this.proName = proName;
		this.image = image;
		this.material = material;
		this.color = color;
		this.describe = describe;
		this.shape = shape;
		this.branch = branch;
		this.feature = feature;
		this.price = price;
		this.hot = hot;
		this.newness = newness;
		this.discounts = discounts;
		this.quantity = quantity;
		this.category = category;
	}
	
	public ProductModel() {
		super();
	}
	
	
	//getter and setter
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Blob getImage() {
		return image;
	}
	public void setImage(Blob image) {
		this.image = image;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getHot() {
		return hot;
	}
	public void setHot(String hot) {
		this.hot = hot;
	}
	public String getNewness() {
		return newness;
	}
	public void setNewness(String newness) {
		this.newness = newness;
	}
	public int getDiscounts() {
		return discounts;
	}
	public void setDiscounts(int discounts) {
		this.discounts = discounts;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
