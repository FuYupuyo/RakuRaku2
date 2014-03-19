package own.fuyupuyo.rakuraku2;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.NetworkImageView;

import own.fuyupuyo.model.RankingItem;
import android.content.Context;
import android.graphics.Bitmap;
import android.test.suitebuilder.annotation.SmallTest;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<RankingItem> {
	private LayoutInflater mInflater;
	private ImageLoader mImageLoader;
	private ImageCache mCache;

	public ItemAdapter(Context context, List<RankingItem> objects,
			RequestQueue queue) {
		super(context, 0, objects);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		mCache = getCache();
		mImageLoader = new ImageLoader(queue, mCache);
	}

	//なにも返さない
	private ImageCache getCache() {
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

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.ranking_list_item, parent,
					false);
		}

		RankingItem item = (RankingItem) getItem(position);

		NetworkImageView smallImageView;
		smallImageView = (NetworkImageView) convertView.findViewById(R.id.small_image);
//		smallImageView.setImageBitmap(item.getSmallImage());
		
		ImageListener listener = ImageLoader.getImageListener(smallImageView,
				android.R.drawable.spinner_background,
				android.R.drawable.ic_dialog_alert);
		mImageLoader.get(item.getSmallImageUrl(), listener);
		smallImageView.setImageUrl(item.getSmallImageUrl(), mImageLoader);

		TextView itemRankTextView = (TextView) convertView
				.findViewById(R.id.item_rank_text);
		itemRankTextView.setText(String.format("%1$02d", position + 1) + "位");

		TextView itemNameTextView = (TextView) convertView
				.findViewById(R.id.item_name_text);
		itemNameTextView.setText(item.getName());

		return convertView;
	}
}
