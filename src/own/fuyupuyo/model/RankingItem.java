package own.fuyupuyo.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class RankingItem implements Serializable {
	private String smallImageUrl;
	private String imageUrl;
	private String name;
	private String price;
	private String caption;

	public RankingItem() {
		super();
		this.imageUrl = "";
		this.name = "";
		this.price = "";
		this.caption = "";
	}

	public RankingItem(String smallImageUrl, String imageUrl, String name,
			String price, String caption) {
		super();
		this.smallImageUrl = smallImageUrl;
		this.imageUrl = imageUrl;
		this.name = name;
		this.price = price;
		this.caption = caption;
	}

	public String getSmallImageUrl() {
		return smallImageUrl;
	}

	public void setSmallImageUrl(String smallImageUrl) {
		this.smallImageUrl = smallImageUrl;
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
