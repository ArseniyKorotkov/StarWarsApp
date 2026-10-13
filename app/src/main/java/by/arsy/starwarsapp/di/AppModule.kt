package by.arsy.starwarsapp.di

import by.arsy.starwarsapp.data.repository.StarWarsRepositoryImpl
import by.arsy.starwarsapp.data.repository.storage.StarWarsRemoteStorage
import by.arsy.starwarsapp.domain.StarWarsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideStarWarsRepository(
        remoteStorage: StarWarsRemoteStorage
    ): StarWarsRepository {
        return StarWarsRepositoryImpl(starWarsRemoteStorage = remoteStorage)
    }

    @Provides
    @Singleton
    fun provideStarWarsRemoteStorage(
        httpClient: HttpClient
    ): StarWarsRemoteStorage {
        return StarWarsRemoteStorage(httpClient)
    }
}
