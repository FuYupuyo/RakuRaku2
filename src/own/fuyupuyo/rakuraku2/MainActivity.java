package own.fuyupuyo.rakuraku2;

import org.json.JSONException;
import org.json.JSONObject;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import own.fuyupuyo.common.Const;
import own.fuyupuyo.common.PageDispatcher;
import own.fuyupuyo.common.PuyoUtil;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;

public class MainActivity extends Activity implements OnMenuItemClickListener {
	private Activity mActivity;
	private ListView mListView;
	private RequestQueue mQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = this;
		setView();
		setRanking();
	}

	private void setView() {
		setContentView(R.layout.activity_main);
		mListView = (ListView) findViewById(R.id.ranking_list_view);
	}

	private void setRanking() {
		String url = Const.BASE_URL;
		Intent intent = getIntent();
		if (intent.getStringExtra("parameter") != null) {
			url = url + intent.getStringExtra("parameter");
		}
		mQueue = Volley.newRequestQueue(mActivity);
		JsonObjectRequest request = new JsonObjectRequest(
				com.android.volley.Request.Method.GET, url, null,
				new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						try {
							PuyoUtil.showToast(mActivity,
									response.getString("title"));
						} catch (JSONException e) {
							e.printStackTrace();
						}
						RankingArrayList list = new RankingArrayList(response,
								defaultBitmap());
						ItemAdapter adapter = new ItemAdapter(mActivity, list);
						OnRankingItemClickListener listener = new OnRankingItemClickListener();
						listener.setActivity(mActivity);
						mListView.setAdapter(adapter);
						mListView.setOnItemClickListener(listener);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						PuyoUtil.showToast(mActivity, "通信エラーです");
					}
				});
		mQueue.add(request);
	}

	private Bitmap defaultBitmap() {
		Bitmap defaultBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ic_launcher);
		return defaultBitmap;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		MenuItem favoriteActionItem = menu.findItem(R.id.action_settings);
		favoriteActionItem.setOnMenuItemClickListener(this);
		return true;
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
		if (item == null) {
			return false;
		}

		switch (item.getItemId()) {
		case R.id.action_settings:
			PageDispatcher.dispatchSettingPage(mActivity);
			break;
		default:
			break;
		}

		return true;
	}

}
