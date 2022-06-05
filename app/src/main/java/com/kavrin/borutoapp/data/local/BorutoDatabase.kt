package com.kavrin.borutoapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kavrin.borutoapp.data.local.dao.HeroDao
import com.kavrin.borutoapp.data.local.dao.HeroRemoteKeyDao
import com.kavrin.borutoapp.domain.model.Hero
import com.kavrin.borutoapp.domain.model.HeroRemoteKey

@Database(entities = [Hero::class, HeroRemoteKey::class], version = 1, exportSchema = true)
@TypeConverters(DatabaseConverter::class)
abstract class BorutoDatabase : RoomDatabase() {

	abstract fun heroDao(): HeroDao
	abstract fun heroRemoteKeyDao(): HeroRemoteKeyDao
}