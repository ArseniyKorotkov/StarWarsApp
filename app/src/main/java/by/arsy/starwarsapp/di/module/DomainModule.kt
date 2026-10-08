package by.arsy.starwarsapp.di.module

import by.arsy.starwarsapp.domain.StarWarsRepository
import by.arsy.starwarsapp.domain.usecase.item.GetFilmUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPersonUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetPlanetUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetSpecieUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetStarshipUseCase
import by.arsy.starwarsapp.domain.usecase.item.GetVehicleUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetFilmPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetPersonPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetPlanetPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetSpeciePageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetStarshipPageUseCase
import by.arsy.starwarsapp.domain.usecase.page.GetVehiclePageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @Provides
    fun provideGetFilmUseCase(repository: StarWarsRepository): GetFilmUseCase {
        return GetFilmUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetPersonUseCase(repository: StarWarsRepository): GetPersonUseCase {
        return GetPersonUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetPlanetUseCase(repository: StarWarsRepository): GetPlanetUseCase {
        return GetPlanetUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetSpecieUseCase(repository: StarWarsRepository): GetSpecieUseCase {
        return GetSpecieUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetStarshipUseCase(repository: StarWarsRepository): GetStarshipUseCase {
        return GetStarshipUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetVehicleUseCase(repository: StarWarsRepository): GetVehicleUseCase {
        return GetVehicleUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetFilmPageUseCase(repository: StarWarsRepository): GetFilmPageUseCase {
        return GetFilmPageUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetPersonPageUseCase(repository: StarWarsRepository): GetPersonPageUseCase {
        return GetPersonPageUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetPlanetPageUseCase(repository: StarWarsRepository): GetPlanetPageUseCase {
        return GetPlanetPageUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetSpeciePageUseCase(repository: StarWarsRepository): GetSpeciePageUseCase {
        return GetSpeciePageUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetStarshipPageUseCase(repository: StarWarsRepository): GetStarshipPageUseCase {
        return GetStarshipPageUseCase(starWarsRepository = repository)
    }

    @Provides
    fun provideGetVehiclePageUseCase(repository: StarWarsRepository): GetVehiclePageUseCase {
        return GetVehiclePageUseCase(starWarsRepository = repository)
    }
}