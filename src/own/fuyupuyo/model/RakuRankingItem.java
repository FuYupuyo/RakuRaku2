package own.fuyupuyo.model;

import java.util.ArrayList;

public class RakuRankingItem {
	public String rank;
	public String carrier;
	public String itemName;
	public String catchcopy;
	public String itemCode;
	public String itemPrice;
	public String itemCaption;
	public String itemUrl;
	public String affiliateUrl;
	public int imageFlag;
	public ArrayList<imageUrl> smallImageUrls;
	public ArrayList<imageUrl> mediumImageUrls;
	public class imageUrl{
		public String imageUrl;
	}
	public String availability;
	public int taxFlag;
	public int postageFlag;
	public int creditCardFlag;
	public int shopOfTheYearFlag;
	public int shipOverseasFlag;
	public String shipOverseasArea;
	public String asurakuFlag;
	public String asurakuClosingTime;
	public String asurakuArea;
	public String affiliateRate;
	public String startTime;
	public String endTime;
	public String reviewCount;
	public String reviewAverage;
	public String pointRate;
	public String pointRateStartTime;
	public String pointRateEndTime;
	public String shopName;
	public String shopCode;
	public String shopUrl;
	public String genreId;
}
