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

    @POST("reg/details")
    @FormUrlEncoded
    Call<UserDto> savePost(@Field("name") String name,
                        @Field("passportNumber") String surname,
                        @Field("surname") String passport_number,
                           @Field("date_of_birth")  String date_of_birth );

    @GET("reg/checkUser")

    Call<List<UserDto>>checkUser();


    @PUT("user/credit/{passportNumber}")
    @FormUrlEncoded
    Call<UserDto>updateData(@Path("passportNumber") String passportNumber,
                            @Field("kafil_person_name") String kafil_person_name,
                            @Field("kafil_passport_number") String  kafil_passport_number,
                            @Field("kafil_surname") String kafil_surname,
                            @Field("kafil_income_yearly") String kafil_income_yearly);
}
