package app.lvcalendar.activity;

import android.app.Activity;
import android.app.calendar.R;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;
import app.lvcalendar.adapter.DateCellAdapter;
import app.lvcalendar.consts.ViewConst;

/**
 * 月表示カレンダー（メイン画面）
 */
public class CalendarActivity extends Activity {

	private GridView mGridView = null;
	private DateCellAdapter mDateCellAdapter = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		mGridView = (GridView) findViewById(R.id.gridView1);
		// 横セルの数
		mGridView.setNumColumns(ViewConst.DAYS_OF_WEEK);
		mDateCellAdapter = new DateCellAdapter(this);
		mGridView.setAdapter(mDateCellAdapter);

		ContentResolver cr = getContentResolver();
		Cursor c = cr.query(
				Uri.parse("content://app.lvcalendar.db.EventProvider"), null,
				null, null, null);
		Log.d("CALENDAR", "Num of records:" + c.getCount());
		c.close();

	}
}