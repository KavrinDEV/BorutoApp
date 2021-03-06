package com.kavrin.borutoapp.di

import android.content.Context
import androidx.room.Room
import com.kavrin.borutoapp.data.local.BorutoDatabase
import com.kavrin.borutoapp.data.repository.LocalDataSourceImpl
import com.kavrin.borutoapp.domain.repository.LocalDataSource
import com.kavrin.borutoapp.util.Constants.BORUTO_DB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

	@Provides
	@Singleton
	fun provideDatabase(
		@ApplicationContext content: Context,
	): BorutoDatabase {
		return Room.databaseBuilder(
			content,
			BorutoDatabase::class.java,
			BORUTO_DB
		).build()
	}

	@Provides
	@Singleton
	fun provideLocalDataSource(
		db: BorutoDatabase
	): LocalDataSource {
		return LocalDataSourceImpl(
			borutoDatabase = db
		)
	}

}