package space.digitallab.testappforarview.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?) :
    SQLiteOpenHelper(context, "myDB", null, 1) {
    override fun onCreate(db: SQLiteDatabase) {
        // создаем таблицу с полями
        db.execSQL(
            "create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name,"
                    + "chanel,"
                    + "viewers" + ");"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {}
}