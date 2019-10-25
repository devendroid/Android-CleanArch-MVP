package com.devs.android_cleanarch_mvp.data.remote;

import com.devs.android_cleanarch_mvp.data.model.UserDto;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;

/**
 * Created by Deven on 2019-09-07.
 */
public interface RestApi {


    public static final String BASEPATH = "https://raw.githubusercontent.com/devendroid/X-Data/master/Android-CleanArch-MVP/";

    @GET("users.json")
    Observable<Response<List<UserDto>>> userDtoList();

    @GET("login.json")
    Observable<Response<UserDto>> userLogin();


    //https://api.stackexchange.com/2.2/questions/11227809/answers?order=desc&sort=activity&site=stackoverflow&filter=withbody
  //  @GET("questions/{qid}/answers?order=desc&sort=votes&site=stackoverflow&page=1&pagesize=10&filter=withbody")
 //   Single<Response<UserDto>> getAnswers(@Path("qid") String qid);


}
