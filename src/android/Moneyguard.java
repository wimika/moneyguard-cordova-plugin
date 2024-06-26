package com.wimika.ionic;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;

import com.google.gson.Gson;
import com.wimika.moneyguard.Client;
import com.wimika.moneyguardcore.BasicClient;
import com.wimika.moneyguardcore.MoneyGuardSdk;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Moneyguard extends CordovaPlugin {

  private SessionImpl session;
  private RestService restService;
  private static final String TAG = "MoneyGuardPlugin";

  private BasicClient client;

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      restService = new RestService();
      Log.d(TAG, "Initializing MoneyGuardPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Log.d(TAG, "Executing " + action + " action");
        Gson gson = new Gson();
        if (action.equals("register")) {

            String partnerBankId = args.getString(0);
            String sessionToken = args.getString(1);
            session = new SessionImpl();
            JSONObject sessionJson = sessionToJson(session);
            callbackContext.success(sessionJson);
            return true;

        }else if(action.equals("checkCredential")){

          String message = args.getString(0);
          JSONObject jsonCredentialCheckReq = args.getJSONObject(0);
          CredentialCheckReq credentialCheckReq = gson.fromJson(jsonCredentialCheckReq.toString(), CredentialCheckReq.class);

          //Todo: make api call here
          CredentialScanResult result = new CredentialScanResult("Scan all good", RiskStatus.RISK_STATUS_UNKNOWN);
          String json = gson.toJson(result);
          JSONObject re = new JSONObject(json);
          callbackContext.success(re);
          return true;

        }else if(action.equals("checkTypingProfile")){

          String message = args.getString(0);
          callbackContext.success("not implemented");
          return true;

        }else if(action.equals("checkDebitTransaction")){

          String message = args.getString(0);
          JSONObject jsonCredentialCheckReq = args.getJSONObject(0);
          DebitCheckReq debitCheckReq = gson.fromJson(jsonCredentialCheckReq.toString(), DebitCheckReq.class);

          //Todo: make api call here
          DebitCheckResult result = new DebitCheckResult(
            true,
            "transaction check success",
            RiskStatus.RISK_STATUS_UNKNOWN.ordinal(),
            null
          );
          String json = gson.toJson(result);
          JSONObject re = new JSONObject(json);
          callbackContext.success(re);
          return true;

        }else if(action.equals("checkTypingProfile")){

          String message = args.getString(0);
          callbackContext.success("not implemented");
          return true;

        }else if(action.equals("getRiskProfile")){

          //Todo: make api call here
          RiskResult result = new RiskResult(
            true,
            "risk check success",
            RiskStatus.RISK_STATUS_UNKNOWN,
            null
          );
          String json = gson.toJson(result);
          JSONObject re = new JSONObject(json);
          callbackContext.success(re);
          return true;

        }else if(action.equals("getSession")){
          String username = args.getString(0);
          String password = args.getString(1);
          Activity activity = this.cordova.getActivity();
          Call<GenericResult<SessionResponse>> call = this.restService.getApiService().getSession(new LoginReq(username, password));
          call.enqueue(new Callback<GenericResult<SessionResponse>>() {
            @Override
            public void onResponse(Call<GenericResult<SessionResponse>> call, Response<GenericResult<SessionResponse>> response) {
              if (response.isSuccessful()) {
                String sessionId= response.body().getData().getSessionId();
                MoneyGuardSdk.register(activity, "101", sessionId , client);
                Log.d("kk", "skksks");
              } else {
                int statusCode = response.code();
              }
            }

            @Override
            public void onFailure(Call<GenericResult<SessionResponse>> call, Throwable t) {
            }
          });
        }
        return false;
    }

    private JSONObject sessionToJson(SessionImpl session) throws JSONException {
        JSONObject sessionJson = new JSONObject();
        sessionJson.put("SessionId", session.getSessionId());
        return sessionJson;
    }

}
