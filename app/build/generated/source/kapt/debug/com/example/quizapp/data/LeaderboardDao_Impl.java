package com.example.quizapp.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
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
public final class LeaderboardDao_Impl implements LeaderboardDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<LeaderboardEntry> __insertionAdapterOfLeaderboardEntry;

  public LeaderboardDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfLeaderboardEntry = new EntityInsertionAdapter<LeaderboardEntry>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `leaderboard_table` (`id`,`playerName`,`score`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final LeaderboardEntry entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getPlayerName() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getPlayerName());
        }
        statement.bindLong(3, entity.getScore());
      }
    };
  }

  @Override
  public Object insert(final LeaderboardEntry entry, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfLeaderboardEntry.insert(entry);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<LeaderboardEntry>> getTopScores() {
    final String _sql = "SELECT * FROM leaderboard_table ORDER BY score DESC LIMIT 10";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"leaderboard_table"}, new Callable<List<LeaderboardEntry>>() {
      @Override
      @NonNull
      public List<LeaderboardEntry> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfPlayerName = CursorUtil.getColumnIndexOrThrow(_cursor, "playerName");
          final int _cursorIndexOfScore = CursorUtil.getColumnIndexOrThrow(_cursor, "score");
          final List<LeaderboardEntry> _result = new ArrayList<LeaderboardEntry>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final LeaderboardEntry _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpPlayerName;
            if (_cursor.isNull(_cursorIndexOfPlayerName)) {
              _tmpPlayerName = null;
            } else {
              _tmpPlayerName = _cursor.getString(_cursorIndexOfPlayerName);
            }
            final int _tmpScore;
            _tmpScore = _cursor.getInt(_cursorIndexOfScore);
            _item = new LeaderboardEntry(_tmpId,_tmpPlayerName,_tmpScore);
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

  @Override
  public Object countEntries(final String playerName, final int score,
      final Continuation<? super Integer> $completion) {
    final String _sql = "SELECT COUNT(*) FROM leaderboard_table WHERE playerName = ? AND score = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    if (playerName == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, playerName);
    }
    _argIndex = 2;
    _statement.bindLong(_argIndex, score);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Integer>() {
      @Override
      @NonNull
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if (_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
