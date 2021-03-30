package ir.mhkz.loginandsignup.RetrofitCLientInstance;



import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit {


    public   static class RetrofitClientInstance {

        private static retrofit2.Retrofit retrofit=null;

      public static retrofit2.Retrofit getClient(String baseUrl) {
          HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
          logging.setLevel(HttpLoggingInterceptor.Level.BODY);
          OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
          httpClient.addInterceptor(logging);
          if (retrofit==null) {
              retrofit = new retrofit2.Retrofit.Builder()
                      .baseUrl(baseUrl)
                      .addConverterFactory(GsonConverterFactory.create())
                      .client(httpClient.build())
                      .build();
          }
          return retrofit;
      }
    }

}
