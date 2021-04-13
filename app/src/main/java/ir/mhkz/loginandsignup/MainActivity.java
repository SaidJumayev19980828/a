package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;


import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.DTO.UserDto;
import ir.mhkz.loginandsignup.RetrofitCLientInstance.Retrofit;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static List<UserDto> spacecrafts12;
    EditText username, password, reg_username, reg_password,
            reg_firstName, reg_lastName, reg_email, reg_confirmemail,reg_familya,reg_passporrt,reg_tugilgan_sana;
    Button login, signUp, reg_register,rasm;
    TextInputLayout txtInLayoutUsername, txtInLayoutPassword, txtInLayoutRegPassword;
    CheckBox rememberMe;
    MyApiService myAPIService;
    List<UserDto> check;
   public static List<UserDto>checkPassport;
   String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAPIService = ApiUtils.getAPIService();
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);
        signUp = findViewById(R.id.signUp);
        txtInLayoutUsername = findViewById(R.id.txtInLayoutUsername);
        txtInLayoutPassword = findViewById(R.id.txtInLayoutPassword);
        rememberMe = findViewById(R.id.rememberMe);


        ClickLogin();



        //SignUp's Button for showing registration page
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                  ClickSignUp();




            }
        });

//



    }





    //This is method for doing operation of check login
    private void ClickLogin() {




        login.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                String name = username.getText().toString();
                String passportN = password.getText().toString();
                MyApiService myAPIService = Retrofit.RetrofitClientInstance.getClient("http://134.209.213.59:8070/").create(MyApiService.class);


                Call<List<UserDto>> call = myAPIService.getSpacecrafts();

                call.enqueue(new Callback<List<UserDto>>() {

                    @Override
                    public void onResponse(Call<List<UserDto>> call, final Response<List<UserDto>> response) {


                        spacecrafts12=response.body();

                        for (int i = 0; i < spacecrafts12.size(); i++)
                        {

                            //do something with i
                            if(name.equals(spacecrafts12.get(i).getName()))
                            {
                                System.out.println("Success");
                                Intent intent=new Intent(MainActivity.this,GetCreditActivity.class);
                                intent.putExtra("passportNumber", password.getText().toString());

//                Toast.makeText(getApplicationContext(),"PassportNumber"+password,Toast.LENGTH_LONG).show();
                                startActivity(intent);
                            }

                        }


//                        for (int i = 0; i < spacecrafts12.size(); i++)
//                        {
//                            spacecrafts12.get(i).getName();
//
//                            //do something with i
//                        }

                    }

                    public void onFailure(Call<List<UserDto>> call, Throwable t) {

                    }


                });

//                checkUser(name,passportN);
                if(name.equals("admin")&&passportN.equals("admin"))
                {
                    Intent intent=new Intent(MainActivity.this,AdminActivity.class);
                    startActivity(intent);
                }
//                else
//                {
//                            Toast.makeText(getApplicationContext(),"Notugri malumotlar qaytadan tering",Toast.LENGTH_LONG).show();
//                }

                if(name.equals("nodir")&&passportN.equals("nodir"))
                {
                    Intent intent=new Intent(MainActivity.this,director_activity.class);
                    startActivity(intent);
                }

                if (username.getText().toString().trim().isEmpty()) {

                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutUsername.setError("Username should not be empty");
                } else {
                    //Here you can write the codes for checking username
                }
                if (password.getText().toString().trim().isEmpty()) {
                    Snackbar snackbar = Snackbar.make(view, "Please fill out these fields",
                            Snackbar.LENGTH_LONG);
                    View snackbarView = snackbar.getView();
                    snackbarView.setBackgroundColor(getResources().getColor(R.color.red));
                    snackbar.show();
                    txtInLayoutPassword.setError("Password should not be empty");
                } else {
                    //Here you can write the codes for checking password
                }

                if (rememberMe.isChecked()) {
                    //Here you can write the codes if box is checked
                } else {
                    //Here you can write the codes if box is not checked
                }

            }

        });

    }

//    public void checkUser(String name, String passportN) {
//        myAPIService.checkUser(name, passportN).enqueue(new Callback<UserDto>() {
//            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
//                if(response.isSuccessful()) {
//                    Toast.makeText(getApplicationContext(),"Data"+response.body().toString(),Toast.LENGTH_LONG).show();
//                }
//            }
//
//            public void onFailure(Call<UserDto> call, Throwable t) {
//
//            }
//        });
//    }

    //The method for opening the registration page and another processes or checks for registering
    private void ClickSignUp() {


        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.register, null);
        dialog.setView(dialogView);

        reg_username = dialogView.findViewById(R.id.ummumiy_kredit);
        reg_familya = dialogView.findViewById(R.id.qarzdorlar_ruy);
        reg_passporrt = dialogView.findViewById(R.id.foyda);
        reg_tugilgan_sana = dialogView.findViewById(R.id.tulab_bulinadigan_sana);
//        reg_email = dialogView.findViewById(R.id.reg_email);
//        reg_confirmemail = dialogView.findViewById(R.id.reg_confirmemail);
        reg_register = dialogView.findViewById(R.id.roziman_btn);
              rasm=(Button)dialogView.findViewById(R.id.rasm);
        txtInLayoutRegPassword = dialogView.findViewById(R.id.txtInLayoutRegPassword);



        rasm.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Inside button",Toast.LENGTH_LONG).show();
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, 1);
            }
        });


        reg_register.setOnClickListener(new View.OnClickListener() {




            @Override
            public void onClick(View view) {



                if (reg_username.getText().toString().trim().isEmpty()) {

                    reg_username.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking username
                }
                if (reg_familya.getText().toString().trim().isEmpty()) {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(false);
                    reg_familya.setError("Please fill out this field");
                } else {
                    txtInLayoutRegPassword.setPasswordVisibilityToggleEnabled(true);
                    //Here you can write the codes for checking password
                }
                if (reg_passporrt.getText().toString().trim().isEmpty()) {

                    reg_passporrt.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking firstname

                }
                if (reg_tugilgan_sana.getText().toString().trim().isEmpty()) {

                    reg_tugilgan_sana.setError("Please fill out this field");
                } else {
                    //Here you can write the codes for checking lastname
                }
//                Intent intent=new Intent(MainActivity.this,GetCreditActivity.class);
//                startActivity(intent);



                String name=reg_username.getText().toString().trim();
                String familya=reg_familya.getText().toString().trim();
                String passport=reg_passporrt.getText().toString().trim();
                String tugilgan_sana=reg_tugilgan_sana.getText().toString().trim();



                sendPost1( name,  familya, passport,tugilgan_sana );


            }


        });


        dialog.show();


    }

    public void sendPost1(String name, String password,String fName,String lName ) {
        myAPIService.savePost(name, password,fName,lName).enqueue(new Callback<UserDto>() {
            public void onResponse(Call<UserDto> call, Response<UserDto> response) {
                if(response.isSuccessful()) {


//                    if(spacecrafts12.getName().isEmpty())
//                    {
//
//                    }else
//                    {
//                        Toast.makeText(getApplicationContext(),"This user already exist",Toast.LENGTH_LONG).show();
//                    }

                }
            }

            public void onFailure(Call<UserDto> call, Throwable t) {

            }
        });
    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 1)
//            if (resultCode == Activity.RESULT_OK) {
//                Uri selectedImage = data.getData();
//
//                String filePath = getPath(selectedImage);
//                String file_extn = filePath.substring(filePath.lastIndexOf(".") + 1);
//                image_name_tv.setText(filePath);
//
//                if (file_extn.equals("img") || file_extn.equals("jpg") || file_extn.equals("jpeg") || file_extn.equals("gif") || file_extn.equals("png")) {
//                    //FINE
//                } else {
//                    //NOT IN REQUIRED FORMAT
//                }
//            }
//    }
//
//    public String getPath(Uri uri) {
//        String[] projection = {MediaStore.MediaColumns.DATA};
//        Cursor cursor = managedQuery(uri, projection, null, null, null);
//        column_index = cursor
//                .getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
//        cursor.moveToFirst();
//        imagePath = cursor.getString(column_index);
//
//        return cursor.getString(column_index);
//    }
}
