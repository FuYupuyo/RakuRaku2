package own.fuyupuyo.rakuraku2;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.NetworkImageView;

import own.fuyupuyo.common.BitmapLruCache;
import own.fuyupuyo.model.RankingItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

		mCache = new BitmapLruCache();
		mImageLoader = new ImageLoader(queue, mCache);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.ranking_list_item, parent,
					false);
		}

		RankingItem item = (RankingItem) getItem(position);

		NetworkImageView smallImageView;
		smallImageView = (NetworkImageView) convertView
				.findViewById(R.id.small_image);

		ImageListener listener = ImageLoader.getImageListener(smallImageView,
				android.R.drawable.spinner_background, R.drawable.ic_launcher);
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
