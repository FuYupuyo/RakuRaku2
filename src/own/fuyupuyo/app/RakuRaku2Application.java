package own.fuyupuyo.app;

import org.json.JSONObject;

import android.app.Application;

public class RakuRaku2Application extends Application {
	private JSONObject selectItem;

	@Override
	public void onCreate() {
		super.onCreate();
		selectItem = new JSONObject();
	}

	public JSONObject getSelectItem() {
		return selectItem;
	}

	public void setSelectItem(JSONObject selectItem) {
		this.selectItem = selectItem;
	}
}