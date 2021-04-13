package ir.mhkz.loginandsignup;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
    TextInputEditText textView,text1;
     TextView txt1,txt2;
     Button btn;

    Button olinayotgan_sana_btn;
    long time;
    Context context;
    String a;


   // @RequiresApi(api = Build.VERSION_CODES.N)
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.credit_activity);
        olinayotgan_sana_btn = (Button) findViewById(R.id.foyda);
        btn=(Button)findViewById(R.id.tasdiqlash_btn);
//        txt1=(TextView) findViewById(R.id.Sana123);
        MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://134.209.213.59:8070/").create(MyApiService.class);
//        txt2=(TextView)findViewById(R.id.debil);
        textView=(TextInputEditText) findViewById(R.id.qarzdorlar_ruy);
        text1=(TextInputEditText)findViewById(R.id.debil1);
        btn=(Button) findViewById(R.id.roziman_btn);

        Call<List<UserDto>> call = myAPIService.getSpacecrafts();

        call.enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {

                    btn.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            Toast.makeText(getApplicationContext(),"Kredit rasmiylashtirildi",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(CreditView.this,MainActivity.class);
                            startActivity(intent);
                        }
                    });
                spacecrafts12=response.body();

                spacecrafts12.get(0).getKredit_summasi();

//                Toast.makeText(getApplicationContext(),"Test"+spacecrafts12.get(0).getKredit_summasi(),Toast.LENGTH_LONG).show();
                int a1;
                text1.setText(spacecrafts12.get(0).getKredit_summasi());
                a1=Integer.parseInt(spacecrafts12.get(0).getKredit_summasi());
                if(a1>10000&&a1<30000)
                {
                    Toast.makeText(getApplicationContext(),"Test",Toast.LENGTH_LONG).show();
                   textView.setText("20%");
                }
                else
                {


                   textView.setText("10%");
                }
                if(a1>30000)
                {
                    textView.setText("30%");
                }


            }

            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }


        });

        final View dialogView = View.inflate(this, R.layout.date_time_picker, null);
        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        olinayotgan_sana_btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {



                dialogView.findViewById(R.id.date_time_set).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        DatePicker datePicker = (DatePicker) dialogView.findViewById(R.id.date_picker);
                        TimePicker timePicker = (TimePicker) dialogView.findViewById(R.id.time_picker);

                        Calendar calendar = new GregorianCalendar(datePicker.getYear(),
                                datePicker.getMonth(),
                                datePicker.getDayOfMonth(),
                                timePicker.getCurrentHour(),
                                timePicker.getCurrentMinute());

                        time = calendar.getTimeInMillis();
                        alertDialog.dismiss();
                     //   a=String.valueOf(time);
                   //    Toast.makeText(getApplicationContext(),"Sana   "+calendar.getWeekYear()+datePicker.getMonth(),Toast.LENGTH_LONG).show();
                    //    txt1.setTextAppearance(datePicker.getMonth() + datePicker.getDayOfMonth());


                    }});
                alertDialog.setView(dialogView);
                alertDialog.show();





            }


        });

    }




}
//        MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://172.10.10.98:8070/").create(MyApiService.class);
//
//
//        Call<List<UserDto>> call = myAPIService.getSpacecrafts();
//        call.enqueue(new Callback<List<UserDto>>() {
//
//            @Override
//            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {
//
//
//                spacecrafts12 = response.body();
//
////                textView.setText(spacecrafts12.get(0).getName().toString().trim());
//
//
//
//
//            }
//
//            public void onFailure(Call<List<UserDto>> call, Throwable t) {
//
//            }
//
//
//        });



