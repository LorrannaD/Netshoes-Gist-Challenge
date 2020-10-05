package br.com.netshoesgistchallenge.database

import android.content.Context

import android.database.sqlite.SQLiteDatabase

import android.util.Log


import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper

import com.j256.ormlite.support.ConnectionSource

import com.j256.ormlite.table.TableUtils
import java.sql.SQLException


class DatabaseHelper(context: Context?) : OrmLiteSqliteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "gits.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(database: SQLiteDatabase?, connectionSource: ConnectionSource?) {
        try {
            TableUtils.createTable(connectionSource, OwnerRecord::class.java)
            TableUtils.createTable(connectionSource, GistRecord::class.java)
            TableUtils.createTable(connectionSource, FileRecord::class.java)
            TableUtils.createTable(connectionSource, HelloWorldRbRecord::class.java)

        } catch (e: SQLException) {
            Log.e("DB", "Unable to create database tables: $e")
        }
    }

    override fun onUpgrade(
        database: SQLiteDatabase?,
        connectionSource: ConnectionSource?,
        oldVersion: Int,
        newVersion: Int
    ) {

    }



}
