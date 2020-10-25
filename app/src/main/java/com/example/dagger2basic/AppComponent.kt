package com.example.dagger2basic

import android.app.Application
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CourseModule::class
    ]
)
interface AppComponent {

    fun inject(app: Application)

    fun inject(target: MainActivity)

    fun inject(target: LoginFragment)
    fun inject(target: FieldFragment)
    fun inject(target: NoteFragment)

}