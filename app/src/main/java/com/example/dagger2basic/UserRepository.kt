package com.example.dagger2basic

import androidx.lifecycle.MutableLiveData
import com.example.dagger2basic.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val quizService: QuizService
)  {
    fun users(): MutableLiveData<Result<List<FieldView>>> {
        val result: MutableLiveData<Result<List<FieldView>>> = MutableLiveData()


            val call = quizService.getLogout("api/json/get/bOPIQIieiG?indent=2")
            call.enqueue(object : Callback<CourseView> {
                override fun onFailure(call: Call<CourseView>, t: Throwable) {
                    result.value = Result.Error("can not connect to server to get all members", null)
                }

                override fun onResponse(
                    call: Call<CourseView>,
                    entity: Response<CourseView>
                ) {
                    if (entity.isSuccessful) {
                        entity.body()?.let {
                            result.value = Result.Success(it.courses)
                        }
                    } else {
                        result.value = Result.Error("can not get users from server")

                    }
                }


            })



        return result
    }

}