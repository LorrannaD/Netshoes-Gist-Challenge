package br.com.netshoesgistchallenge.database

import android.content.Context
import android.util.Log
import br.com.netshoesgistchallenge.entities.Gist
import com.j256.ormlite.android.apptools.OpenHelperManager
import com.j256.ormlite.dao.Dao

import java.sql.SQLException


class GistRepository(var context: Context) {

    private val TAG = GistRepository::class.java.simpleName

    var databaseHelper_: DatabaseHelper? = null
    var gistDao: Dao<GistRecord, String>? = null
    var ownerDao: Dao<OwnerRecord, String>? = null
    var filesDao: Dao<FileRecord, String>? = null
    var HelloWorldRbDao: Dao<HelloWorldRbRecord, String>? = null

    init {
        databaseHelper_ = OpenHelperManager.getHelper(context, DatabaseHelper::class.java)
        try {
            gistDao = databaseHelper_?.getDao(GistRecord::class.java)
            ownerDao = databaseHelper_?.getDao(OwnerRecord::class.java)
            filesDao = databaseHelper_?.getDao(FileRecord::class.java)
            HelloWorldRbDao = databaseHelper_?.getDao(HelloWorldRbRecord::class.java)
        } catch (e: SQLException) {
            Log.e(TAG, "Could not create DAO Dao", e)
        }
    }

    fun store(gist: Gist){
        try {

            val records: List<GistRecord> =
                gistDao!!.queryBuilder()
                    .where()
                    .eq("idGist", gist?.id)
                    .query()

            if(records.isEmpty()){

                val helloWorldRbRecord = HelloWorldRbRecord(gist.files?.helloWorldRb?.filename,gist.files?.helloWorldRb?.type,gist.files?.helloWorldRb?.language,gist.files?.helloWorldRb?.rawUrl,
                    gist.files?.helloWorldRb?.size)
                HelloWorldRbDao?.create(helloWorldRbRecord)

                val fileRecord = FileRecord(helloWorldRbRecord)
                filesDao?.create(fileRecord)

                val ownerRecord = OwnerRecord(gist.owner?.login, gist.owner?.id, gist.owner?.avatarUrl, gist.owner?.htmlUrl)
                ownerDao?.create(ownerRecord)

                val recordGist = GistRecord(gist?.id, false, gist.htmlUrl, gist.description, ownerRecord, fileRecord )
                gistDao?.create(recordGist)
            }

        } catch (e: Exception){

        }
    }

    fun fetchGists(): ArrayList<Gist>{
        return try {
            val records: List<GistRecord> =
                gistDao!!.queryBuilder()
                    .query()


            var gists = ArrayList<Gist>()

            for(item in records) {
                gists.add(item.toGist())
            }
            gists
        } catch (e: Exception){
            ArrayList()
        }

    }

    fun fetchFavorites(): ArrayList<Gist>{
        return try {
            val records: List<GistRecord> =
                gistDao!!.queryBuilder()
                    .where()
                    .eq("isFavorites", true)
                    .query()

            var gists = ArrayList<Gist>()

            for(item in records) {
                gists.add(item.toGist())
            }
            gists
        } catch (e: Exception){
            ArrayList()
        }

    }


    fun update(gist: Gist){
        try {
            val record: GistRecord =
                gistDao!!.queryBuilder()
                    .where()
                    .eq("idGist", gist?.id)
                    .queryForFirst()

            record.isFavorites = gist.isFavorites
            gistDao?.update(record)

        } catch (e: Exception){

        }

    }

}