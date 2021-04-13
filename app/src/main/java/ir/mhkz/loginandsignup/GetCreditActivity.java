package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.DTO.UserDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetCreditActivity extends AppCompatActivity {

    TextView text1,bir_yillik_ish_haqi_tv,kafil_ism_familya_tv,kafil_ish_haqi_tv,kredit_summasi_tv;
    Button klient_rasm,kredit_olish_btn,kafil_rasm,rasm1,rasm2;
    MyApiService myApiService;


    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kredit_olish);

        String passportNumber = getIntent().getStringExtra("passportNumber");
        System.out.println("DATA FROM INTENT"+passportNumber);


        myApiService = ApiUtils.getAPIService1(passportNumber+"/");

        klient_rasm=(Button) findViewById(R.id.ummumiy_kredit);
        bir_yillik_ish_haqi_tv=(TextView)findViewById(R.id.qarzdorlar_ruy);
        kafil_rasm=(Button) findViewById(R.id.tulab_bulinadigan_sana);
        kafil_ism_familya_tv=(TextView)findViewById(R.id.foyda);
        kafil_ish_haqi_tv=(TextView)findViewById(R.id.kredit_muddati);
        kredit_olish_btn=(Button)findViewById(R.id.roziman_btn);
        kredit_summasi_tv=(TextView)findViewById(R.id.har_oy_tulaydigan_summa);
        rasm1=(Button)findViewById(R.id.rasm1);
        rasm2=(Button)findViewById(R.id.rasm2);
        rasm1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });
        rasm2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });


       kredit_olish_btn.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {



                if (bir_yillik_ish_haqi_tv.getText().toString().trim().isEmpty()) {

                   bir_yillik_ish_haqi_tv.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                }
                if (kafil_ism_familya_tv.getText().toString().trim().isEmpty()) {
                   // txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                    kafil_ism_familya_tv.setError("Please fill out this field");
                } else {
                   // txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                    //Here you can write the codes for checking password
                }
                if (kafil_ish_haqi_tv.getText().toString().trim().isEmpty()) {

                    kafil_ish_haqi_tv.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking firstname

                }
                if (kredit_summasi_tv.getText().toString().trim().isEmpty()) {

                  kredit_summasi_tv.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking lastname
                }


                String ish_haqi_yillik=bir_yillik_ish_haqi_tv.getText().toString().trim();
                String ism_familya=kafil_ism_familya_tv.getText().toString().trim();
                String kafil_ish_haqi=kafil_ish_haqi_tv.getText().toString().trim();
                String kredit_summasi=kredit_summasi_tv.getText().toString().trim();
                int a=Integer.parseInt(bir_yillik_ish_haqi_tv.getText().toString());
                int b=Integer.parseInt(kredit_summasi_tv.getText().toString());
                if(a>=b)
                {
                    Toast.makeText(getApplicationContext(),"Barcha ma'lumotlar yuklandi",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(GetCreditActivity.this,CreditView.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Kredit miqdori Yillik maoshdan katta bulmasligi kerak",Toast.LENGTH_LONG).show();
                }


                updateData( passportNumber ,ish_haqi_yillik,ism_familya, kafil_ish_haqi ,kredit_summasi);

            }


        });



    }

    public void updateData(String passportNumber,String ish_haqi_yillik, String ism_familya,String kafil_ish_haqi,String kredit_summasi) {
        myApiService.updateData(passportNumber, ish_haqi_yillik,ism_familya,kafil_ish_haqi,kredit_summasi).enqueue(new Callback<UserDto>() {
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                if(response.isSuccessful()) {

                    Toast.makeText(getApplicationContext(),"Data"+response.body().toString(),Toast.LENGTH_LONG).show();
                }
            }

            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });
    }
}
