package server;

import java.io.Serializable;

public class Bottom implements Serializable {

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
	private int waist;
	private int thigh;
	private int rise;
	private int hem;

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

	public int getWaist() {
		return waist;
	}

	public void setWaist(int waist) {
		this.waist = waist;
	}

	public int getThigh() {
		return thigh;
	}

	public void setThigh(int thigh) {
		this.thigh = thigh;
	}

	public int getRise() {
		return rise;
	}

	public void setRise(int rise) {
		this.rise = rise;
	}

	public int getHem() {
		return hem;
	}

	public void setHem(int hem) {
		this.hem = hem;
	}

}
