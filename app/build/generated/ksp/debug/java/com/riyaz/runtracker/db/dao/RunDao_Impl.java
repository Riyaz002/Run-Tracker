package com.riyaz.runtracker.db.dao;

import android.database.Cursor;
import android.graphics.Bitmap;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.riyaz.runtracker.db.entity.Run;
import com.riyaz.runtracker.util.TypeConverter;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@SuppressWarnings({"unchecked", "deprecation"})
public final class RunDao_Impl extends RunDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Run> __insertionAdapterOfRun;

  private final EntityDeletionOrUpdateAdapter<Run> __deletionAdapterOfRun;

  public RunDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfRun = new EntityInsertionAdapter<Run>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `run_table` (`bitmap`,`timestamp`,`averageSpeedInKMH`,`timeInMillis`,`distanceInMeters`,`caloriesBurned`,`id`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Run value) {
        final byte[] _tmp;
        if(value.getBitmap() == null) {
          _tmp = null;
        } else {
          _tmp = TypeConverter.INSTANCE.fromBitmap(value.getBitmap());
        }
        if (_tmp == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindBlob(1, _tmp);
        }
        if (value.getTimestamp() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindLong(2, value.getTimestamp());
        }
        stmt.bindDouble(3, value.getAverageSpeedInKMH());
        if (value.getTimeInMillis() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, value.getTimeInMillis());
        }
        stmt.bindLong(5, value.getDistanceInMeters());
        stmt.bindLong(6, value.getCaloriesBurned());
        if (value.getId() == null) {
          stmt.bindNull(7);
        } else {
          stmt.bindLong(7, value.getId());
        }
      }
    };
    this.__deletionAdapterOfRun = new EntityDeletionOrUpdateAdapter<Run>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `run_table` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Run value) {
        if (value.getId() == null) {
          stmt.bindNull(1);
        } else {
          stmt.bindLong(1, value.getId());
        }
      }
    };
  }

  @Override
  public Object insertRun(final Run run, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfRun.insert(run);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Object deleteRun(final Run run, final Continuation<? super Unit> continuation) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfRun.handle(run);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, continuation);
  }

  @Override
  public Flow<List<Run>> getAllRuns() {
    final String _sql = "SELECT * FROM run_table";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[]{"run_table"}, new Callable<List<Run>>() {
      @Override
      public List<Run> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfBitmap = CursorUtil.getColumnIndexOrThrow(_cursor, "bitmap");
          final int _cursorIndexOfTimestamp = CursorUtil.getColumnIndexOrThrow(_cursor, "timestamp");
          final int _cursorIndexOfAverageSpeedInKMH = CursorUtil.getColumnIndexOrThrow(_cursor, "averageSpeedInKMH");
          final int _cursorIndexOfTimeInMillis = CursorUtil.getColumnIndexOrThrow(_cursor, "timeInMillis");
          final int _cursorIndexOfDistanceInMeters = CursorUtil.getColumnIndexOrThrow(_cursor, "distanceInMeters");
          final int _cursorIndexOfCaloriesBurned = CursorUtil.getColumnIndexOrThrow(_cursor, "caloriesBurned");
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final List<Run> _result = new ArrayList<Run>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Run _item;
            final Bitmap _tmpBitmap;
            final byte[] _tmp;
            if (_cursor.isNull(_cursorIndexOfBitmap)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getBlob(_cursorIndexOfBitmap);
            }
            if(_tmp == null) {
              _tmpBitmap = null;
            } else {
              _tmpBitmap = TypeConverter.INSTANCE.toBitmap(_tmp);
            }
            final Long _tmpTimestamp;
            if (_cursor.isNull(_cursorIndexOfTimestamp)) {
              _tmpTimestamp = null;
            } else {
              _tmpTimestamp = _cursor.getLong(_cursorIndexOfTimestamp);
            }
            final float _tmpAverageSpeedInKMH;
            _tmpAverageSpeedInKMH = _cursor.getFloat(_cursorIndexOfAverageSpeedInKMH);
            final Long _tmpTimeInMillis;
            if (_cursor.isNull(_cursorIndexOfTimeInMillis)) {
              _tmpTimeInMillis = null;
            } else {
              _tmpTimeInMillis = _cursor.getLong(_cursorIndexOfTimeInMillis);
            }
            final long _tmpDistanceInMeters;
            _tmpDistanceInMeters = _cursor.getLong(_cursorIndexOfDistanceInMeters);
            final int _tmpCaloriesBurned;
            _tmpCaloriesBurned = _cursor.getInt(_cursorIndexOfCaloriesBurned);
            _item = new Run(_tmpBitmap,_tmpTimestamp,_tmpAverageSpeedInKMH,_tmpTimeInMillis,_tmpDistanceInMeters,_tmpCaloriesBurned);
            final Integer _tmpId;
            if (_cursor.isNull(_cursorIndexOfId)) {
              _tmpId = null;
            } else {
              _tmpId = _cursor.getInt(_cursorIndexOfId);
            }
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
