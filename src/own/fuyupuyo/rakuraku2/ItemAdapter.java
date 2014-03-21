package own.fuyupuyo.rakuraku2;

import java.util.List;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageContainer;
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

	static class ViewHolder {
		NetworkImageView smallImageView;
		TextView itemRankTextView;
		TextView itemNameTextView;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.ranking_list_item, parent,
					false);
			holder = new ViewHolder();
			holder.smallImageView = (NetworkImageView) convertView
					.findViewById(R.id.small_image);
			holder.itemRankTextView = (TextView) convertView
					.findViewById(R.id.item_rank_text);
			holder.itemNameTextView = (TextView) convertView
					.findViewById(R.id.item_name_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		RankingItem item = (RankingItem) getItem(position);

		ImageContainer imageContainer = (ImageContainer) holder.smallImageView.getTag();
		if (imageContainer != null) {
			imageContainer.cancelRequest();
		}

		ImageListener listener = ImageLoader.getImageListener(
				holder.smallImageView, android.R.drawable.spinner_background,
				R.drawable.ic_launcher);
		mImageLoader.get(item.getSmallImageUrl(), listener);
		
		holder.smallImageView.setTag(mImageLoader.get(item.getSmallImageUrl(), listener));
		holder.smallImageView.setImageUrl(item.getSmallImageUrl(), mImageLoader);
		holder.itemRankTextView.setText(String.format("%1$02d", position + 1) + "位");
		holder.itemNameTextView.setText(item.getName());

		return convertView;
	}
}
