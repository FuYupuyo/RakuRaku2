package own.fuyupuyo.rakuraku2;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import own.fuyupuyo.common.Const;
import own.fuyupuyo.common.PageDispatcher;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

public class MainActivity extends Activity implements OnMenuItemClickListener {
	private RequestQueue mQueue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setView();
		setRanking();
	}

	private void setView() {
		setContentView(R.layout.activity_main);
	}

	private void setRanking() {
		String url = Const.BASE_URL;
		Intent intent = getIntent();
		if (intent.getStringExtra("parameter") != null) {
			url = url + intent.getStringExtra("parameter");
		}
		mQueue = Volley.newRequestQueue(this);
		JsonObjectRequest request = new JsonObjectRequest(
				com.android.volley.Request.Method.GET, url, null,
				new RankingResponse(this, mQueue), 
				new RankingErrorResponse(this)
		);
		mQueue.add(request);
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
			PageDispatcher.dispatchSettingPage(this);
			break;
		default:
			break;
		}

		return true;
	}

}
