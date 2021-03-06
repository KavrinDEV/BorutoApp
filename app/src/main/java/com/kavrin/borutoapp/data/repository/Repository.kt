package com.kavrin.borutoapp.data.repository

import androidx.paging.PagingData
import com.kavrin.borutoapp.domain.model.Hero
import com.kavrin.borutoapp.domain.repository.DataStoreOperations
import com.kavrin.borutoapp.domain.repository.LocalDataSource
import com.kavrin.borutoapp.domain.repository.RemoteDaraSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
	private val dataStore: DataStoreOperations,
	private val remote: RemoteDaraSource,
	private val local: LocalDataSource
) {

	fun getAllHeroes(): Flow<PagingData<Hero>> {
		return remote.getAllHeroes()
	}

	fun searchHeroes(query: String): Flow<PagingData<Hero>> {
		return remote.searchHeroes(query = query)
	}

	suspend fun getSelectedHero(heroId: Int): Hero {
		return local.getSelectedHero(heroId = heroId)
	}

	suspend fun saveOnBoardingState(completed: Boolean) {
		dataStore.saveOnBoardingState(completed = completed)
	}

	fun readOnBoardingState(): Flow<Boolean> {
		return dataStore.readOnBoardingState()
	}
}