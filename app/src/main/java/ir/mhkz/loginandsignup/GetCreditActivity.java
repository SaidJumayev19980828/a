package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    TextView text1,text2,text3,text4,text5;
    Button button;
    MyApiService myApiService;


    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_activity);

        String passportNumber = getIntent().getStringExtra("passportNumber");
        System.out.println("DATA FROM INTENT"+passportNumber);


        myApiService = ApiUtils.getAPIService1(passportNumber);

        text1=(TextView)findViewById(R.id.reg_username);
        text2=(TextView)findViewById(R.id.reg_password);
        text3=(TextView)findViewById(R.id.reg_lastName);
        text4=(TextView)findViewById(R.id.reg_firstName );
        text5=(TextView)findViewById(R.id.reg_lastName2);
        button=(Button)findViewById(R.id.reg_register);


        button.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {



                if (text1.getText().toString().trim().isEmpty()) {

                   text1.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                }
                if (text2.getText().toString().trim().isEmpty()) {
                   // txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                    text2.setError("Please fill out this field");
                } else {
                   // txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                    //Here you can write the codes for checking password
                }
                if (text3.getText().toString().trim().isEmpty()) {

                    text3.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking firstname

                }
                if (text4.getText().toString().trim().isEmpty()) {

                  text4.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking lastname
                }


                String name=text1.getText().toString().trim();
                String password=text2.getText().toString().trim();
                String fName=text3.getText().toString().trim();
                String lName=text4.getText().toString().trim();
                int a=Integer.parseInt(text5.getText().toString());
                int b=Integer.parseInt(text3.getText().toString());
                if(a>=b)
                {
                    Toast.makeText(getApplicationContext(),"Barcha ma'lumotlar yuklandi",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(GetCreditActivity.this,CreditView.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(),"Kredit miqdori Yillik maoshdan katta bulmasligi kerak",Toast.LENGTH_LONG).show();
                }


                updateData( name,  password, fName ,lName,passportNumber );

            }


        });



    }

    public void updateData(String name, String password,String fNmae,String lName,String passportNumber) {
        myApiService.updateData(name, password,fNmae,lName,passportNumber).enqueue(new Callback<UserDto>() {
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
