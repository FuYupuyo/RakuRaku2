package own.fuyupuyo.rakuraku2;

import own.fuyupuyo.common.PageDispatcher;
import own.fuyupuyo.common.PuyoUtil;
import own.fuyupuyo.model.RankingItem;
import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class OnRankingItemClickListener implements OnItemClickListener {
	private Activity mActivity;

	public void setActivity(Activity c) {
		mActivity = c;
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
		ListView listView = (ListView) parent;
		RankingItem item = (RankingItem) listView.getItemAtPosition(position);
		PuyoUtil.showToast(mActivity, item.getName());
		PageDispatcher.dispatchItemPage(mActivity, item);
	}

}
