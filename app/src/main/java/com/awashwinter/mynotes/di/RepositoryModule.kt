package com.awashwinter.mynotes.di

import com.awashwinter.mynotes.repository.NotesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideRepository():NotesRepository {
        return NotesRepository()
    }
}