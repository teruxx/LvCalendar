package jp.app.lvcalendar.db;

import jp.app.lvcalendar.consts.DBConst;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * SQLiteに処理を発行します
 */
public class EventProvider extends ContentProvider {

	private EventDatabaseHelper eventDbHelper = null;

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public boolean onCreate() {
		eventDbHelper = new EventDatabaseHelper(getContext());
		return false;
	}

	/**
	 * 検索
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// 読み出し専用で開く
		SQLiteDatabase db = eventDbHelper.getReadableDatabase();
		return db.query(DBConst.EventInfo.TableName, projection, selection,
				selectionArgs, null, null, null);
	}

	/**
	 * 更新
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = eventDbHelper.getWritableDatabase();
		return db.update(DBConst.EventInfo.TableName, values, selection,
				selectionArgs);
	}

	/**
	 * 登録
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = eventDbHelper.getWritableDatabase();
		long id = db.insert(DBConst.EventInfo.TableName, null, values);
		return Uri.parse(uri + "/" + id);
	}

	/**
	 * 削除
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = eventDbHelper.getWritableDatabase();
		return db.delete(DBConst.EventInfo.TableName, selection, selectionArgs);
	}
}
