package ir.mhkz.loginandsignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.DTO.UserDto;
import ir.mhkz.loginandsignup.RetrofitCLientInstance.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class CreditView extends AppCompatActivity {
    public static List<UserDto> spacecrafts12;
    public static List<String> object;
    TextView textView, txt1, txt2;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_view_activity);


        MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://134.209.213.59:8070/").create(MyApiService.class);


        Call<List<UserDto>> call = myAPIService.getSpacecrafts();
        call.enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {


                spacecrafts12 = response.body();

                textView.setText(spacecrafts12.get(0).getName().toString().trim());




            }

            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }


        });
    }
}

