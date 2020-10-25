package com.example.dagger2basic
import android.app.Application

class CourceApp: Application() {


    lateinit var courceComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        courceComponent = initDagger(this)

    }

    private fun initDagger(app: CourceApp): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()


}