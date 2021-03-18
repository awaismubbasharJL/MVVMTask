package com.example.myapplication.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Sell::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun sellDao(): SellDao

    companion object{
        @JvmStatic
        private lateinit var instance: AppDatabase

        @Synchronized
        fun getInstance(context: Context): AppDatabase{
            if (!this::instance.isInitialized){
                instance = Room.databaseBuilder(context,
                    AppDatabase::class.java, "sell_database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            instance.let { PopulateDbAsyncTask(it).execute() }
                        }
                    })
                    .build()
            }
            return instance
        }
    }

    class PopulateDbAsyncTask(db: AppDatabase): AsyncTask<Void, Void, Void>() {
        private var sellDao = db.sellDao()

         override fun doInBackground(vararg voids: Void): Void? {
            sellDao.insertSellData(Sell(1,"Table", 12000.0, 1))
            sellDao.insertSellData(Sell(2,"Tv", 38000.0, 2))
            sellDao.insertSellData(Sell(3,"IphoneX", 150000.0, 1))
            return null
        }
    }
}
