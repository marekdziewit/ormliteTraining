package com.test.marek.ormlitetraining;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class TrainingOrmLiteHelper extends OrmLiteSqliteOpenHelper {
    public static final String TAG = TrainingOrmLiteHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "marek.sqlite";
    public static final int DATABASE_VERSION = 10;

    private Dao<DataModel, Integer> modelDao = null;

    public TrainingOrmLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, DataModel.class);
            Log.d(TAG, "Created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        try {
            TableUtils.dropTable(connectionSource, DataModel.class, true);
            Log.d(TAG, "Updated");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        onCreate(database, connectionSource);
    }

    public Dao<DataModel, Integer> getModelDao() throws SQLException {
        if (modelDao == null) {
            modelDao = getDao(DataModel.class);
        }
        return modelDao;
    }


}
