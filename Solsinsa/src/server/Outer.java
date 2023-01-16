package server;

import java.io.Serializable;

public class Outer implements Serializable {

	private static final long serialVersionUID = 456789654L;

	private String img;
	private String material;
	private String fit;
	private String touch;
	private String flexible;
	private String through;
	private String thickness;
	private String size;
	private int length;
	private int shoulder;
	private int chest;
	private int sleeve;

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getFit() {
		return fit;
	}

	public void setFit(String fit) {
		this.fit = fit;
	}

	public String getTouch() {
		return touch;
	}

	public void setTouch(String touch) {
		this.touch = touch;
	}

	public String getFlexible() {
		return flexible;
	}

	public void setFlexible(String flexible) {
		this.flexible = flexible;
	}

	public String getThrough() {
		return through;
	}

	public void setThrough(String through) {
		this.through = through;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getShoulder() {
		return shoulder;
	}

	public void setShoulder(int shoulder) {
		this.shoulder = shoulder;
	}

	public int getChest() {
		return chest;
	}

	public void setChest(int chest) {
		this.chest = chest;
	}

	public int getSleeve() {
		return sleeve;
	}

	public void setSleeve(int sleeve) {
		this.sleeve = sleeve;
	}

}
