package own.fuyupuyo.rakuraku2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import own.fuyupuyo.common.PuyoUtil;
import own.fuyupuyo.model.RankingItem;

@SuppressWarnings("serial")
public class RankingArrayList extends ArrayList<RankingItem> {
	private JSONArray mItemsArray;

	public RankingArrayList(JSONObject response) {
		super();
		init(response);
	}

	private void init(JSONObject response) {
		try {
			mItemsArray = response.getJSONArray("Items");
			for (Integer i = 0; i < mItemsArray.length(); i++) {
				JSONObject Item;
				Item = mItemsArray.getJSONObject(i).getJSONObject("Item");
				String smallImageurl = Item.getJSONArray("smallImageUrls")
						.getJSONObject(0).getString("imageUrl");
				String imageUrl = PuyoUtil.cutParameter(smallImageurl);
				String name = Item.getString("itemName");
				String price = Item.getString("itemPrice");
				String caption = Item.getString("itemCaption");
				RankingItem data = new RankingItem(smallImageurl, imageUrl,
						name, price, caption);
				add(data);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
