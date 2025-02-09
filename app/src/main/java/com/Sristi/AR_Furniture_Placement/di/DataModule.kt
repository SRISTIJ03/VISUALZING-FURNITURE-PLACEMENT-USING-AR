package com.Sristi.AR_Furniture_Placement.di

import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepository
import com.Sristi.AR_Furniture_Placement.data.repository.ModelRepositoryImpl
import com.Sristi.AR_Furniture_Placement.data.utils.ConnectivityManagerNetworkMonitor
import com.Sristi.AR_Furniture_Placement.data.utils.FileHelper
import com.Sristi.AR_Furniture_Placement.data.utils.FileHelperImpl
import com.Sristi.AR_Furniture_Placement.data.utils.NetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindNetworkMonitor(networkMonitor: ConnectivityManagerNetworkMonitor): NetworkMonitor

    @Binds
    fun bindsFileHelper(fileHelper: FileHelperImpl): FileHelper

    @Binds
    fun bindsModelRepository(modelRepository: ModelRepositoryImpl): ModelRepository
}
