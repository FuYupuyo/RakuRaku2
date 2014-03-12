package own.fuyupuyo.rakuraku2;

import java.util.List;

import own.fuyupuyo.model.RankingItem;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemAdapter extends ArrayAdapter<RankingItem> {
	private LayoutInflater mInflater;

	public ItemAdapter(Context context, List<RankingItem> objects) {
		super(context, 0, objects);
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.ranking_list_item, parent,
					false);
		}

		RankingItem item = (RankingItem) getItem(position);

		ImageView smallImageView;
		smallImageView = (ImageView) convertView.findViewById(R.id.small_image);
		smallImageView.setImageBitmap(item.getSmallImage());

		TextView itemRankTextView = (TextView) convertView
				.findViewById(R.id.item_rank_text);
		itemRankTextView.setText(String.format("%1$02d", position + 1) + "位");

		TextView itemNameTextView = (TextView) convertView
				.findViewById(R.id.item_name_text);
		itemNameTextView.setText(item.getName());

		return convertView;
	}
}
