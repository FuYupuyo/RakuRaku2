package own.fuyupuyo.common;

public class Const {
	private Const() {
		// ユーティリティクラスなのでインスタンス化禁止
	}

	public static enum ScreenType {
		/** Activity */
		SCREEN_TYPE_ACTIVITY_MAIN, SCREEN_TYPE_ACTIVITY_SETTING, SCREEN_TYPE_ACTIVITY_ITEM,
	}

	public static final String APPLICATION_ID = "1093443291235859235";
	public static final String RANKING_API_URL = "https://app.rakuten.co.jp/services/api/IchibaItem/Ranking/20120927";
	public static final String BASE_PARAMETER = "format=json&applicationId=" + APPLICATION_ID;
	public static final String BASE_URL = RANKING_API_URL + "?" + BASE_PARAMETER;

}
