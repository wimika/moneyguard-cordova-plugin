package com.wimika.ionic;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestService {
  private static final String BASE_URL = "https://moneyguardservice.azurewebsites.net/";
  private ApiService apiService;

  public RestService() {
    Retrofit retrofit = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .addConverterFactory(GsonConverterFactory.create())
      .build();

    apiService = retrofit.create(ApiService.class);
  }

  public ApiService getApiService() {
    return apiService;
  }
}
