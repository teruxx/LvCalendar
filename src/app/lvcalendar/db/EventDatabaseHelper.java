package app.lvcalendar.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import app.lvcalendar.consts.DBConst;
import app.lvcalendar.consts.DBConst.EventInfo;

/**
 * SQLiteHelper
 */
public class EventDatabaseHelper extends SQLiteOpenHelper {

	public EventDatabaseHelper(Context context) {
		super(context, DBConst.DB_NAME + ".db", null, DBConst.DB_VERSION);
	}

	/**
	 * 初回起動時にデータベースを作成
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE " + EventInfo.TableName + "("
				+ EventInfo.ID + " INTEGER PRIMARY KEY,"
				+ EventInfo.TITLE + " TEXT,"
				+ EventInfo.COTENT + " TEXT,"
				+ EventInfo.WHERE + " TEXT,"
				+ EventInfo.START_TIME + " TEXT,"
				+ EventInfo.END_TIME + " TEXT"
				+ " )";
		
		db.execSQL(sql);
	}

	/**
	 * データベースのバージョンアップ
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS " + DBConst.EventInfo.TableName;
		db.execSQL(sql);
		onCreate(db);
	}

}
