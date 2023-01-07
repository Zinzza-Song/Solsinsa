package gui;

import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;

// 완료 x
class ProductList {
	int pNo; // 상품 코드
	String pName; // 상품 이름
	int Price;
	ImageIcon img;

	public int getpNo() {
		return pNo;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public void setpNo(int pNo) {
		this.pNo = pNo;
	}

	public ProductList(ImageIcon img) {
		this.img = img;
	}
}

class CartCount {
	int count;
	ProductList pList;

	CartCount() {

	}
}

public class CartList {

}
