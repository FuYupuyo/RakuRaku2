package own.fuyupuyo.model;

import android.graphics.Bitmap;

public class RankingItem {
	private Bitmap smallImage;
	private String imageUrl;
	private String name;
	private String price;
	private String caption;

	public RankingItem(){
		super();
		this.imageUrl = "";
		this.name = "";
		this.price = "";
		this.caption = "";
	}
	
	public RankingItem(Bitmap smallImage, String imageUrl, String name,
			String price, String caption) {
		super();
		this.smallImage = smallImage;
		this.imageUrl = imageUrl;
		this.name = name;
		this.price = price;
		this.caption = caption;
	}

	public Bitmap getSmallImage() {
		return smallImage;
	}

	public void setSmallImage(Bitmap smallImage) {
		this.smallImage = smallImage;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}
}
