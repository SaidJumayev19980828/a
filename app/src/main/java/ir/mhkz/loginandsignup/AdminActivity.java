package ir.mhkz.loginandsignup;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
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
    TextView text1;
    Spinner spinner;
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_activity);

        spinner=(Spinner)findViewById(R.id.spinner);
        textView=(TextView)findViewById(R.id.textView2) ;
        txt1=(TextView)findViewById(R.id.textView1);
        txt2=(TextView)findViewById(R.id.textView3) ;
        text1=(TextView)findViewById(R.id.reg_password3) ;


        String[] items = new String[]{"50-100 mlngacha" , "100mln-10mlrdgacha"};
//       int[] items_value = new String[]{ 4, 8, 9, 10, 55};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner.setAdapter(adapter);
        String text = spinner.getSelectedItem().toString();


        text1.setText(text);
//        Toast.makeText(getApplicationContext(),"Test"+text,Toast.LENGTH_LONG).show();





        MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://192.168.31.218:8070/").create(MyApiService.class);


        Call<List<UserDto>> call = myAPIService.getSpacecrafts1();
        call.enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {


               spacecrafts12=response.body();

              //  textView.setText(spacecrafts12.get(0).getPassport_number().toString().trim());
//                    Toast.makeText(getApplicationContext(),"Passport"+spacecrafts12.get(1).getPassport_number().toString(),Toast.LENGTH_LONG).show();


                for (int i = 0; i < spacecrafts12.size(); i++)
                {
                 txt1.append(spacecrafts12.get(i).getName()+spacecrafts12.get(i).getSurname()+"\n");
                 textView.append(spacecrafts12.get(i).getPassport_number()+"\n");
                 txt2.append(spacecrafts12.get(i).getDate_of_birth()+"\n");
                    //do something with i
                }

            }

            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }


        });
    }
}
