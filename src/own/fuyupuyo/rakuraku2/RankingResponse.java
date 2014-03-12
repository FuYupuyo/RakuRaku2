package own.fuyupuyo.rakuraku2;

import org.json.JSONException;
import org.json.JSONObject;

import own.fuyupuyo.common.PuyoUtil;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ListView;

import com.android.volley.Response;

public class RankingResponse implements Response.Listener<JSONObject> {
	private Activity mActivity;
	private ListView mListView;

	public RankingResponse(Activity mActivity) {
		super();
		this.mActivity = mActivity;
		mListView = (ListView) mActivity.findViewById(R.id.ranking_list_view);
	}

	@Override
	public void onResponse(JSONObject response) {
		try {
			PuyoUtil.showToast(mActivity, response.getString("title"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RankingArrayList list = new RankingArrayList(response, defaultBitmap());
		ItemAdapter adapter = new ItemAdapter(mActivity, list);
		OnRankingItemClickListener listener = new OnRankingItemClickListener(
				mActivity);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(listener);
	}

	private Bitmap defaultBitmap() {
		Bitmap defaultBitmap = BitmapFactory.decodeResource(
				mActivity.getResources(), R.drawable.ic_launcher);
		return defaultBitmap;
	}

}
