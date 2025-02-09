package com.Sristi.AR_Furniture_Placement.di

import android.content.Context
import androidx.room.Room
import com.Sristi.AR_Furniture_Placement.data.local.database.SSFurniCraftARDatabase
import com.Sristi.AR_Furniture_Placement.data.local.database.dao.CategoryAndProductDao
import com.Sristi.AR_Furniture_Placement.data.local.database.dao.ProductDao
import com.Sristi.AR_Furniture_Placement.data.local.database.dao.RemoteKeyDao
import com.Sristi.AR_Furniture_Placement.utils.constant.Constants
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
    fun providesSSFurniCraftARDatabase(
        @ApplicationContext context: Context,
    ): SSFurniCraftARDatabase = Room.databaseBuilder(
        context,
        SSFurniCraftARDatabase::class.java,
        Constants.DATABASE,
    ).build()

    @Provides
    fun providesModelDao(
        database: SSFurniCraftARDatabase
    ): ProductDao = database.modelDao()

    @Provides
    fun providesRemoteKeyDao(
        database: SSFurniCraftARDatabase
    ): RemoteKeyDao = database.remoteKeyDao()

    @Provides
    fun providesCategoryAndProductDao(
        database: SSFurniCraftARDatabase
    ): CategoryAndProductDao = database.categoryAndProductDao()
}
