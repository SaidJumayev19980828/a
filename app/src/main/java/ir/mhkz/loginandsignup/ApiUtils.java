package ir.mhkz.loginandsignup;

import ir.mhkz.loginandsignup.APiService.MyApiService;
import ir.mhkz.loginandsignup.RetrofitCLientInstance.Retrofit;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://134.209.213.59:8070/";

    public static MyApiService getAPIService() {

        return Retrofit.RetrofitClientInstance.getClient(BASE_URL).create(MyApiService.class);
    }
    private void ApiUtils1() {}

    public static final String BASE_URL1 = "http://134.209.213.59:8070/";

    public static MyApiService getAPIService1(String passportNumber) {

        return Retrofit.RetrofitClientInstance.getClient(BASE_URL+passportNumber).create(MyApiService.class);
    }
}