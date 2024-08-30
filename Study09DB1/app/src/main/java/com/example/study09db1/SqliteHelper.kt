package com.example.study09db1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SqliteHelper(context: Context, name:String, version: Int): SQLiteOpenHelper(context, name, null, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "create table memo(num integer primary key," +
                "content text," +
                "datetime integer)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    // 추가
    fun insertMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        val wd = writableDatabase
        wd.insert("memo", null, values)
        wd.close()
    }

    // 전체보기
    fun selectMemo():MutableList<Memo> {
        val list = mutableListOf<Memo>()
        val sql = "select * from memo"
        val rd = readableDatabase
        val cursor = rd.rawQuery(sql, null)

        while(cursor.moveToNext()) {
            val num = cursor.getLong(0)
            val content = cursor.getString(1)
            val datatime = cursor.getLong(2)

            list.add(Memo(num, content, datatime))
        }

        cursor.close()
        rd.close()

        return list
    }

    // 수정
    fun updateMemo(memo: Memo) {
        val values = ContentValues()
        values.put("content", memo.content)
        values.put("datetime", memo.datetime)

        val wd = writableDatabase
        wd.update("memo", values, "num=${memo.num}", null)
        wd.close()
    }

    // 삭제
    fun deleteMemo(memo: Memo) {
        val sql = "delete from memo where num = ${memo.num}"
        val wd = writableDatabase
        wd.execSQL(sql)
        wd.close()
    }
}