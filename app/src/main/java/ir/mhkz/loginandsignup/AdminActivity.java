package ir.mhkz.loginandsignup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.DTO.UserDto;
import ir.mhkz.loginandsignup.RetrofitCLientInstance.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdminActivity extends AppCompatActivity {

    public static List<UserDto> spacecrafts12;
    public static List<String> object;
    TextView textView,txt1,txt2;

    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);


        textView=(TextView)findViewById(R.id.textView2) ;
        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView3) ;


      MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://134.209.213.59:8070/").create(MyApiService.class);


        Call<List<UserDto>> call = myAPIService.getSpacecrafts();
        call.enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {


               spacecrafts12=response.body();

                textView.setText(spacecrafts12.get(0).getName().toString().trim());



                for (int i = 0; i < spacecrafts12.size(); i++)
                {
                 textView.append(spacecrafts12.get(i).getName()+"\n");
                 txt1.append(spacecrafts12.get(i).getPassport_number()+"\n");
                 txt2.append(spacecrafts12.get(i).getDate_of_birth()+"\n");
                    Toast.makeText(getApplicationContext(),"Size"+object,Toast.LENGTH_LONG).show();
                    //do something with i
                }

            }

            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }


        });
    }
}
