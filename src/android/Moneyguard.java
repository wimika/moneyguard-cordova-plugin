package com.wimika.ionic;

import static com.wimika.moneyguardcore.RiskStatus.RISK_STATUS_SAFE;
import static com.wimika.moneyguardcore.RiskStatus.RISK_STATUS_UNSAFE;
import static com.wimika.moneyguardcore.RiskStatus.RISK_STATUS_WARN;

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
import com.wimika.moneyguardcore.BasicClient;
import com.wimika.moneyguardcore.Credential;
import com.wimika.moneyguardcore.impl.BasicSessionImpl;
import com.wimika.moneyguardcore.RiskStatus;
import com.wimika.moneyguardcore.CredentialScanResult;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Moneyguard extends CordovaPlugin {

  private SessionImpl session;
  private BasicSessionImpl basicSession;
  private BankRestService bankRestService;
  private MoneyGuardRestService moneyGuardRestService;

  private String sessionId;
  public String domain;
  private BasicClient client;
  private static final String TAG = "MoneyGuardPlugin";




    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      bankRestService = new BankRestService();
      moneyGuardRestService = new MoneyGuardRestService();
      domain = "wimika.ng";
      Log.d(TAG, "Initializing MoneyGuardPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Log.d(TAG, "Executing " + action + " action");
        Gson gson = new Gson();
        Activity activity = this.cordova.getActivity();
        String installationId = "test-id";


        if (action.equals("register")) {

            String partnerBankId = args.getString(0);
            String sessionToken = args.getString(1);
            session = new SessionImpl();
            JSONObject sessionJson = sessionToJson(session);
            callbackContext.success(sessionJson);
            return true;

        }else if(action.equals("checkCredential")){

          String username = args.getString(0);
          String password = args.getString(1);
          BasicClientImpl client = new BasicClientImpl();
          basicSession = new BasicSessionImpl(activity, installationId, sessionId, client);

          try{
            Class<?> clazz = Class.forName("com.wimika.moneyguardcore.Credential");
            Object credential = clazz.getDeclaredConstructor().newInstance();

            Field field = credential.getClass().getDeclaredField("userName");
            field.setAccessible(true);
            field.set(credential, username);

            Field field1 = credential.getClass().getDeclaredField("password");
            field1.setAccessible(true);
            field1.set(credential, password);

            Field field2 = credential.getClass().getDeclaredField("domain");
            field2.setAccessible(true);
            field2.set(credential, domain);


            Long scanId = basicSession.scanCredential((Credential) credential);
            CredentialScanResult result = client.getScanResult(scanId);
            String statusMsg = "";
            switch (result.getStatus())
            {
              case RISK_STATUS_SAFE:
                statusMsg = "Safe";
              case RISK_STATUS_WARN:
                statusMsg = "Warn";
              case RISK_STATUS_UNSAFE:
                statusMsg = "Unsafe";
            }

            String msg = "Credential is "  + statusMsg;
            callbackContext.success(msg);
            return true;


          } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
          } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
          } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
          } catch (InstantiationException e) {
            throw new RuntimeException(e);
          } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
          } catch (Exception e){
            throw new RuntimeException(e);
          }

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
//          RiskResult result = new RiskResult(
//            true,
//            "risk check success",
//            RiskStatus.RISK_STATUS_UNKNOWN,
//            null
//          );
//          String json = gson.toJson(result);
//          JSONObject re = new JSONObject(json);
//          callbackContext.success(re);
          return true;

        }else if(action.equals("getSession")){
          String username = args.getString(0);
          String password = args.getString(1);
          Call<GenericResult<SessionResponse>> call = this.bankRestService.getApiService().getBankSession(new LoginReq(username, password));
          call.enqueue(new Callback<GenericResult<SessionResponse>>() {
            @Override
            public void onResponse(Call<GenericResult<SessionResponse>> call, Response<GenericResult<SessionResponse>> response) {
              if (response.isSuccessful()) {

                sessionId = response.body().getData().getSessionId();

                // Use the sessionId to make the next call
                SessionRequest req = new SessionRequest(101, sessionId, installationId);
                Call<MoneyGuardSessionResponse> nextCall = moneyGuardRestService.getApiService().getMoneyGuardSession(req);
                nextCall.enqueue(new Callback<MoneyGuardSessionResponse>() {
                  @Override
                  public void onResponse(Call<MoneyGuardSessionResponse> call, Response<MoneyGuardSessionResponse> response) {
                    Gson gson = new Gson();

                    if (response.isSuccessful()) {
                      MoneyGuardSessionResponse result = response.body();
                      String json = gson.toJson(result);

                      try {
                        JSONObject re = new JSONObject(json);
                        callbackContext.success(re);
                      } catch (JSONException e) {
                        callbackContext.error("JSON Exception: " + e.getMessage());
                      }
                    } else {
                      int statusCode = response.code();
                      callbackContext.error("Error: " + statusCode);
                    }
                  }
                  @Override
                  public void onFailure(Call<MoneyGuardSessionResponse> call, Throwable t) {
                    callbackContext.error("Failure: " + t.getMessage());
                  }
                });
              } else {
                int statusCode = response.code();
                callbackContext.error("Error: " + statusCode);
              }
            }

            @Override
            public void onFailure(Call<GenericResult<SessionResponse>> call, Throwable t) {
              callbackContext.error("Failure: " + t.getMessage());
            }
          });
          return true;
        }
        return false;
    }

  private static String StatusAsString(RiskStatus status)
  {
    switch (status)
    {
      case RISK_STATUS_SAFE:
        return "Safe";
      case RISK_STATUS_WARN:
        return "Warn";
      case RISK_STATUS_UNSAFE:
        return "Unsafe";
    }

    return "Unknown";
  }

  private JSONObject sessionToJson(SessionImpl session) throws JSONException {
        JSONObject sessionJson = new JSONObject();
        sessionJson.put("SessionId", session.getSessionId());
        return sessionJson;
    }


}


