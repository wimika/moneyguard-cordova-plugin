package com.wimika.ionic;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
  @POST("credential/check")
  Call<GenericResult> checkCredentials(@Body CredentialCheckReq request);

  @POST("auth/emails/signin")
  Call<GenericResult<SessionResponse>> getBankSession(@Body LoginReq request);

  @POST("api/v1/session")
  Call<MoneyGuardSessionResponse> getMoneyGuardSession(@Body SessionRequest request);
}
