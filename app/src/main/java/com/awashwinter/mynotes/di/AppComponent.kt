package com.awashwinter.mynotes.di

import com.awashwinter.mynotes.usecases.UseCaseAddNote
import com.awashwinter.mynotes.usecases.UseCaseGetNotes
import dagger.Component
import javax.inject.Singleton

@Component(modules = [RepositoryModule::class])
@Singleton
interface AppComponent {

    fun injectRepository(useCase: UseCaseGetNotes)
    fun injectRepository(useCase: UseCaseAddNote)
}