package com.tbox.coilexample.ui.theme

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger


// MyApplication sınıfı, Application sınıfından türetilir ve ImageLoaderFactory'yi uygular
class MyApplication: Application(), ImageLoaderFactory {

    // ImageLoaderFactory arabirimini uygulayan bir sınıf
    override fun newImageLoader(): ImageLoader {
        return ImageLoader(this).newBuilder()

            // Bellek önbelleğini etkinleştirir
            .memoryCachePolicy(CachePolicy.ENABLED)
            .memoryCache {
                MemoryCache.Builder(this)
                    .maxSizePercent(0.1)  // Maksimum bellek kullanımını belirler (%10)
                    .strongReferencesEnabled(true) // Güçlü referansların etkinleştirilmesi
                    .build()
            }

            // Disk önbelleğini etkinleştirir
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizePercent(0.03)  // Diskin %3'üne kadar önbellek kullanır
                    .directory(cacheDir) // Disk önbelleği için dizin belirler
                    .build()
            }
            // Hata ayıklamak için Logger
            .logger(DebugLogger())
            .build()
    }
}