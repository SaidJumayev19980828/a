package ir.mhkz.loginandsignup;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.DTO.UserDto;
import ir.mhkz.loginandsignup.RetrofitCLientInstance.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public  class director_activity extends AppCompatActivity {
    TextInputEditText um_kredit,deb,foyda,bank,balans1,pul_kiritish;
    Button btn,pulqush;

    public static List<UserDto> spacecrafts12;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.director_activity);

        um_kredit=(TextInputEditText)findViewById(R.id.ummumiy_kredit);
        deb=(TextInputEditText)findViewById(R.id.qarzdorlar_ruy);
        foyda=(TextInputEditText)findViewById(R.id.foyda);
        bank=(TextInputEditText)findViewById(R.id.bank_hisobi);
        btn=(Button)findViewById(R.id.roziman_btn);
        balans1=(TextInputEditText)findViewById(R.id.balans);
        pul_kiritish=(TextInputEditText)findViewById(R.id.pul_kiritish);
        pulqush=(Button)findViewById(R.id.qoshish);

        MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://134.209.213.59:8070/").create(MyApiService.class);


        Call<List<UserDto>> call = myAPIService.getSpacecrafts1();
        call.enqueue(new Callback<List<UserDto>>() {

            @Override
            public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {


                spacecrafts12=response.body();

                //  textView.setText(spacecrafts12.get(0).getPassport_number().toString().trim());
//                    Toast.makeText(getApplicationContext(),"Passport"+spacecrafts12.get(1).getPassport_number().toString(),Toast.LENGTH_LONG).show();


                for (int i = 0; i < spacecrafts12.size(); i++)
                {

                    foyda.setText(Integer.parseInt(spacecrafts12.get(i).getKredit_summasi())/4+"");


                    um_kredit.append(Integer.parseInt(spacecrafts12.get(i).getKredit_summasi())+"+"+"\n");
//                    um_kredit.setText(Integer.parseInt(spacecrafts12.get(i).getKredit_summasi())+Integer.parseInt(spacecrafts12.get(i).getKredit_summasi()));
                   deb.append(spacecrafts12.get(i).getName()+"\n");
//                  bank.append(100000000+"so'm");
                 //  double foyda1 =(res*0.25);

                //    foyda.setText((int) foyda1);
                 int  balans=1000000-(Integer.valueOf(spacecrafts12.get(i).getKredit_summasi()));
                        Toast.makeText(getApplicationContext(),"BALANCE"+balans,Toast.LENGTH_LONG).show();
                        String a=String.valueOf(balans);


                        balans1.setText(a);
                        pulqush.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                              int qq=balans+Integer.valueOf(pul_kiritish.getText().toString());
                              Toast.makeText(getApplicationContext(),"Balamce"+qq,Toast.LENGTH_LONG).show();
                              String as=String.valueOf(qq);
                                balans1.setText(as);
                            }
                        });


                    //do something with i


                }



            }

            public void onFailure(Call<List<UserDto>> call, Throwable t) {

            }


        });
//                btn.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        Toast.makeText(getApplicationContext(),"Barcha ma'lumotlar tasdiqlandi",Toast.LENGTH_LONG).show();
//                    }
//                });
    }

}
