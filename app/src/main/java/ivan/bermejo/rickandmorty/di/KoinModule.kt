package ivan.bermejo.rickandmorty.di

import ivan.bermejo.rickandmorty.viewmodels.VMCharacter
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val KoinModuleView = module {

    viewModel { VMCharacter(get(),get()) }
}