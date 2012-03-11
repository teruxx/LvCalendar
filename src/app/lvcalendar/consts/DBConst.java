package app.lvcalendar.consts;

import android.provider.BaseColumns;

public class DBConst {

	// バージョン
	public static final int DB_VERSION = 1;

	// データベース名
	public static final String DB_NAME = "LvCalendar";
	
	/**
	 * EventInfoテーブル
	 */
	public class EventInfo {
		public static final String TableName = "EVENT";
		public static final String ID = BaseColumns._ID;
		public static final String TITLE = "TITLE";
		public static final String COTENT = "CONTENT";
		public static final String WHERE ="GD_WHERE";
		public static final String START_TIME = "GD_START_TIME";
		public static final String END_TIME = "GD_END_TIME";
	}

}
