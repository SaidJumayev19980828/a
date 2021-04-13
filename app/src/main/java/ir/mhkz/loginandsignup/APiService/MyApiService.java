package ir.mhkz.loginandsignup.APiService;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import ir.mhkz.loginandsignup.DTO.UserDto;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface MyApiService {
    @GET("user/admin")
    Call<List<UserDto>> getSpacecrafts();

    @GET("user/admin")
    Call<List<UserDto>> getSpacecrafts1();
    @POST("reg/details")
    @FormUrlEncoded
    Call<UserDto> savePost(@Field("name") String name,
                        @Field("surname") String surname,
                        @Field("passportNumber") String passport_number,
                           @Field("date_of_birth")  String date_of_birth );


    @GET("reg/checkUser")

    Call<List<UserDto>>checkUser();


    @PUT("user/credit/{passportNumber}")
    @FormUrlEncoded
    Call<UserDto>updateData(@Path("passportNumber") String passportNumber,
                            @Field("kafil_ish_haqi_yillik") String kafil_person_name,
                            @Field("kafil_ism_familya") String  kafil_passport_number,
                            @Field("ish_haqi") String kafil_surname,
                            @Field("kredit_summasi") String kafil_income_yearly);
}
