package own.fuyupuyo.item;

import own.fuyupuyo.common.PageDispatcher;
import own.fuyupuyo.common.PuyoUtil;
import own.fuyupuyo.rakuraku2.R;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ItemActivity extends Activity {
	private Activity mActivity;
	private static final Object TAG_REQUEST_QUEUE = new Object();
	private RequestQueue mRequestQueue;
	private ImageLoader mImageLoader;
	private ImageCache mCache;
	private TextView mName;
	private TextView mPrice;
	private TextView mCaption;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mActivity = this;
		Intent intent = getIntent();
		if (intent == null) {
			PuyoUtil.showToast(mActivity, "アイテムの情報が取得できませんでした");
			PageDispatcher.dispatchMainPage(mActivity, null);
			return;
		}
		setView(intent);
	}

	private void setView(Intent intent) {
		setContentView(R.layout.activity_item);
		mCache = getCacheNone();
		mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		mImageLoader = new ImageLoader(mRequestQueue, mCache);
		NetworkImageView image = (NetworkImageView) findViewById(R.id.item_image);
		image.setImageUrl(intent.getStringExtra("url"), mImageLoader);
		mName = (TextView) findViewById(R.id.item_name);
		mName.setText(intent.getStringExtra("name"));
		mPrice = (TextView) findViewById(R.id.item_price);
		mPrice.setText(intent.getStringExtra("price"));
		mCaption = (TextView) findViewById(R.id.item_caption);
		CharSequence cs = Html.fromHtml(intent.getStringExtra("caption"));
		mCaption.setText(cs);
	}

	@Override
	public void onStop() {
		super.onStop();
		mRequestQueue.cancelAll(TAG_REQUEST_QUEUE);
	}

	/*
	 * TODO: Volleyのキャッシュの仕組みを理解して、キャッシュを利用しないためnullにする
	 */
	private ImageCache getCacheNone() {
		return new ImageCache() {
			@Override
			public Bitmap getBitmap(String url) {
				return null;
			}

			@Override
			public void putBitmap(String url, Bitmap bitmap) {
			}
		};
	}
}
