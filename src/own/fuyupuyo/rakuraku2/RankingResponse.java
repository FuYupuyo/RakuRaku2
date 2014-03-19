package own.fuyupuyo.rakuraku2;

import org.json.JSONException;
import org.json.JSONObject;

import own.fuyupuyo.common.PuyoUtil;

import android.app.Activity;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;

public class RankingResponse implements Response.Listener<JSONObject> {
	private Activity mActivity;
	private RequestQueue mQueue;
	private ListView mListView;

	public RankingResponse(Activity activity, RequestQueue queue) {
		super();
		mActivity = activity;
		mQueue = queue;
		mListView = (ListView) mActivity.findViewById(R.id.ranking_list_view);
	}

	@Override
	public void onResponse(JSONObject response) {
		try {
			PuyoUtil.showToast(mActivity, response.getString("title"));
		} catch (JSONException e) {
			e.printStackTrace();
		}
		RankingArrayList list = new RankingArrayList(response);
		ItemAdapter adapter = new ItemAdapter(mActivity, list, mQueue);
		OnRankingItemClickListener listener = new OnRankingItemClickListener(
				mActivity);
		mListView.setAdapter(adapter);
		mListView.setOnItemClickListener(listener);
	}
}
