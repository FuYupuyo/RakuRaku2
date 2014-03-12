package own.fuyupuyo.rakuraku2;

import own.fuyupuyo.common.PuyoUtil;
import android.app.Activity;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class RankingErrorResponse implements Response.ErrorListener {
	private Activity mActivity;

	public RankingErrorResponse(Activity mActivity) {
		super();
		this.mActivity = mActivity;
	}

	@Override
	public void onErrorResponse(VolleyError error) {
		PuyoUtil.showToast(mActivity, "通信エラーです");
	}

}
