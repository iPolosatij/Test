package space.digitallab.testappforarview.database

import Top
import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import java.util.*

class DBinterface(dbHelper: DBHelper) {
    var cv = ContentValues()
    var db: SQLiteDatabase
    fun dataSave(contactList: List<Top>): String {
        var S = contactList.toString()
        for (contact in contactList) {
            cv.put("name", contact.game.name)
            cv.put("chanel", contact.channels)
            cv.put("viewers", contact.viewers)

            // вставляем запись и получаем ее ID
            val rowID = db.insert("mytable", null, cv)
            S = """
                ${S}row inserted, ID = $rowID
                
                """.trimIndent()
        }
        return S
    }

    fun dataItemSave(contact: Top) {
        cv.put("name", contact.game.name)
        cv.put("chanel", contact.channels)
        cv.put("viewers", contact.viewers)
        val rowID = db.insert("mytable", null, cv)
    }

    fun dataRead(listDatum: ArrayList<DB>) {
        var i = 0
        val c = db.query("mytable", null, null, null, null, null, null)
        if (c.moveToFirst()) {
            val idColIndex = c.getColumnIndex("id")
            val nameColIndex = c.getColumnIndex("name")
            val chanelColIndex = c.getColumnIndex("chanel")
            val viawersColIndex = c.getColumnIndex("veawers")

            do {
                listDatum.add(
                    DB(
                        c.getInt(idColIndex),
                        c.getString(nameColIndex),
                        c.getString(chanelColIndex),
                        c.getString(viawersColIndex)
                    )
                )
            } while (c.moveToNext())
        } else {
            c.close()
            val n = 0
            while (n < 5) {
                listDatum.add(DB(0, "no data", "no data", "no data"))
                i++
            }
        }
    }

    fun dbClear(): String {
        val clearCount = db.delete("mytable", null, null)
        return "deleted rows count = $clearCount"
    }

    init {
        db = dbHelper.writableDatabase
    }
}
