package com.example.jetpackcomposeui.network

import com.example.jetpackcomposeui.repo.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object Retrofit {

    @Provides
    @ViewModelScoped
    fun setRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @ViewModelScoped
    fun provideProductService(api: ProductApi): ProductService {
        return ProductService(api)
    }

    @Provides
    @ViewModelScoped
    fun provideProductApi(retrofit: Retrofit): ProductApi {
        return retrofit.create(ProductApi::class.java)
    }

    @Provides
    @ViewModelScoped
    fun provideProductRepository(service: ProductService): ProductRepository {
        return ProductRepository(service)
    }
}