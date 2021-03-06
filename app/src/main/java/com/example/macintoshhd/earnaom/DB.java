package com.example.macintoshhd.earnaom;

/**
 * Created by student on 2/23/15 AD.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DB extends SQLiteOpenHelper {

    private static final String name = "currency.sqlite3";
    private static final int version = 2;


    public DB(Context ctx) {
        super(ctx, name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE currency (" +
                "_id integer primary key autoincrement," +
                "cinput real default 0.0," +             // money
                "cfrom text not null," +           // from
                "cto text not null," +            // to
                "coutput real default 0.0);";         // result
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS currency;";
        db.execSQL(sql);
        this.onCreate(db);
    }
}