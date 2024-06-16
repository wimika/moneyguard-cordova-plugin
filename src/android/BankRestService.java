package com.wimika.ionic;


import android.util.Log;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import okhttp3.logging.HttpLoggingInterceptor;


public class BankRestService {
  private static final String BASE_URL = "https://bankservice.azurewebsites.net/";
  private ApiService apiService;

  public BankRestService() {

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
      @Override
      public void log(String message) {
        Log.d("OkHttp", message); // You can change "OkHttp" to any tag you prefer
      }
    });
    loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);// Set logging level to include request and response bodies

    OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
    httpClientBuilder.addInterceptor(loggingInterceptor); // Add logging interceptor to log request and response bodies

    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .client(httpClientBuilder.build()) // Set custom OkHttpClient with logging interceptor
      .build();

    apiService = retrofit.create(ApiService.class);
  }

  public ApiService getApiService() {
    return apiService;
  }
}
