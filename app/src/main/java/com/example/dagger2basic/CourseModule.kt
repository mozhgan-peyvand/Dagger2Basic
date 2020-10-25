package com.example.dagger2basic
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CourseModule {

    @Singleton
    @Provides
    fun provideQuizService(retrofit: Retrofit): QuizService {
        return retrofit.create(QuizService::class.java)
    }



    @Provides
    fun provideUserRepository(quizService: QuizService): UserRepository {
        return UserRepository(quizService)
    }
}