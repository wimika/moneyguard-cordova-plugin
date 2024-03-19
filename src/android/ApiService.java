package com.wimika.ionic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
  @POST("credential/check")
  Call<GenericResult> checkCredentials(@Body CredentialCheckReq request);
}
