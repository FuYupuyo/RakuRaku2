package own.fuyupuyo.setting;

import own.fuyupuyo.common.PageDispatcher;
import own.fuyupuyo.rakuraku2.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;

public class SettingsActivity extends Activity implements
		OnItemSelectedListener, OnClickListener {
	private Spinner mSexSpinner;
	private Spinner mAgeSpinner;
	private TextView mSearchButton;
	private UrlParameter mParam;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mParam = new UrlParameter();
		setView();
	}

	private void setView() {
		setContentView(R.layout.activity_settings);
		mSexSpinner = (Spinner) findViewById(R.id.spin_sex);
		mSexSpinner.setOnItemSelectedListener(this);
		mAgeSpinner = (Spinner) findViewById(R.id.spin_age);
		mAgeSpinner.setOnItemSelectedListener(this);
		mSearchButton = (TextView) findViewById(R.id.search_button);
		mSearchButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		PageDispatcher.dispatchMainPage(this, mParam);
	}

	@Override
	public void onItemSelected(AdapterView<?> adapter, View v, int arg2,
			long arg3) {
		int i = adapter.getSelectedItemPosition();
		if (adapter.getId() == mAgeSpinner.getId()) {
			if (i != 0) {
				mParam.setAge(i * 10 + "");
			}
		} else if (adapter.getId() == mSexSpinner.getId()) {
			switch (i) {
			case 1:
				mParam.setSex("0");
				break;
			case 2:
				mParam.setSex("1");
				break;
			default:
				break;
			}
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
	}
}
