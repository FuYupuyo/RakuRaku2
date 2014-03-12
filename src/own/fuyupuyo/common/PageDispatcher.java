package own.fuyupuyo.common;

import own.fuyupuyo.common.Const.ScreenType;
import own.fuyupuyo.item.ItemActivity;
import own.fuyupuyo.model.RankingItem;
import own.fuyupuyo.rakuraku2.MainActivity;
import own.fuyupuyo.setting.SettingsActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class PageDispatcher {
	private PageDispatcher() {
		// ユーティリティクラスなのでインスタンス化禁止
	}

	public static void dispatchMainPage(Context context, Object obj) {
		dispatchPage(context, ScreenType.SCREEN_TYPE_ACTIVITY_MAIN, obj);
	}

	public static void dispatchSettingPage(Context context) {
		dispatchPage(context, ScreenType.SCREEN_TYPE_ACTIVITY_SETTING, null);
	}

	public static void dispatchItemPage(Context context, RankingItem item) {
		dispatchPage(context, ScreenType.SCREEN_TYPE_ACTIVITY_ITEM, item);
	}

	private static void dispatchPage(Context ctx, ScreenType type, Object obj) {
		if (ctx == null || type == null) {
			return;
		}

		Log.d("Dispatch Screen:", type.toString());

		Intent mIntent = null;
		switch (type) {
		case SCREEN_TYPE_ACTIVITY_MAIN:
			mIntent = new Intent(ctx, MainActivity.class);
			if (obj == null || obj.toString() == "") {
				ctx.startActivity(mIntent);
			}
			mIntent.putExtra("parameter", obj.toString());
			ctx.startActivity(mIntent);
			break;

		case SCREEN_TYPE_ACTIVITY_SETTING:
			mIntent = new Intent(ctx, SettingsActivity.class);
			ctx.startActivity(mIntent);
			break;

		case SCREEN_TYPE_ACTIVITY_ITEM:
			if (obj == null) {
				break;
			}
			mIntent = new Intent(ctx, ItemActivity.class);
			RankingItem item = (RankingItem) obj;
			mIntent.putExtra("url", item.getImageUrl());
			mIntent.putExtra("name", item.getName());
			mIntent.putExtra("price", item.getPrice() + "円");
			mIntent.putExtra("caption", item.getCaption());
			ctx.startActivity(mIntent);
			break;

		default:
			break;
		}
	}

}
