package own.fuyupuyo.rakuraku2;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.graphics.Bitmap;
import own.fuyupuyo.common.PuyoUtil;
import own.fuyupuyo.model.RankingItem;

public class RankingArrayList extends ArrayList<RankingItem> {
	private JSONArray mItemsArray;

	public RankingArrayList(JSONObject response, Bitmap defaultBitmap) {
		super();
		init(response, defaultBitmap);
	}

	private void init(JSONObject response, Bitmap defaultBitmap) {
		try {
			mItemsArray = response.getJSONArray("Items");
			for (Integer i = 0; i < mItemsArray.length(); i++) {
				JSONObject Item;
				Item = mItemsArray.getJSONObject(i).getJSONObject("Item");
				String url = Item.getJSONArray("smallImageUrls")
						.getJSONObject(0).getString("imageUrl");
				url = PuyoUtil.cutParameter(url);
				String name = Item.getString("itemName");
				String price = Item.getString("itemPrice");
				String caption = Item.getString("itemCaption");
				RankingItem data = new RankingItem(defaultBitmap, url, name,
						price, caption);
				add(data);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}
