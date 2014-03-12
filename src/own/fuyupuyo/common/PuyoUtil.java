package own.fuyupuyo.common;

import android.app.Activity;
import android.widget.Toast;

public class PuyoUtil {
	private PuyoUtil() {
		// ユーティリティクラスなのでインスタンス化禁止
	}

	public static String cutParameter(String str) {
		int index = str.indexOf("?");
		return str.substring(0, index);
	}

	public static void showToast(Activity c, String str) {
		Toast.makeText(c, str, Toast.LENGTH_SHORT).show();
	}
}
