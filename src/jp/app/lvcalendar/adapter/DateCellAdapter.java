package jp.app.lvcalendar.adapter;

import jp.app.lvcalendar.R;
import jp.app.lvcalendar.consts.ViewConst;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * 各日付の内容を保持するアダプタ
 */
public class DateCellAdapter extends BaseAdapter {

	private LayoutInflater mLayoutInFlater = null;

	public DateCellAdapter(Context context) {
		mLayoutInFlater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	/**
	 * 表示するセルの数
	 */
	public int getCount() {
		return ViewConst.NUM_OF_CELL;
	}

	/**
	 * 各セルの内容
	 */
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mLayoutInFlater.inflate(R.layout.datecell, null);
		}
		// viewの最小の高さを設定する
		convertView.setMinimumHeight(parent.getHeight() / ViewConst.NUM_ROWS
				- 1);

		// 日付の欄に仮に現在のpositionを表示
		TextView dayOfMonthView = (TextView) convertView
				.findViewById(R.id.dayOfMonth);
		dayOfMonthView.setText("" + position);
		TextView scheduleView = (TextView) convertView
				.findViewById(R.id.schedule);
		scheduleView.setText("Schdule" + position);
		return convertView;
	}

	public Object getItem(int position) {
		return null;
	}

	public long getItemId(int position) {
		return 0;
	}

}
