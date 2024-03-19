package com.wimika.ionic;

import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.google.gson.Gson;


public class Moneyguard extends CordovaPlugin {

  private SessionImpl session;
  private RestService restService;
  private static final String TAG = "MoneyGuardPlugin";


    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
      super.initialize(cordova, webView);
      restService = new RestService();
      Log.d(TAG, "Initializing MyCordovaPlugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        Log.d("MoneyguardPlugin", "Executing " + action + " action");
        if (action.equals("register")) {
            String partnerBankId = args.getString(0);
            String sessionToken = args.getString(1);
            session = new SessionImpl();
            JSONObject sessionJson = sessionToJson(session);
            callbackContext.success(sessionJson);
            return true;
        }else if(action.equals("echo")){
            String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;
        }else if(action.equals("checkCredential")){
          String message = args.getString(0);
          JSONObject jsonCredentialCheckReq = args.getJSONObject(0);
          Gson gson = new Gson();
          CredentialCheckReq credentialCheckReq = gson.fromJson(jsonCredentialCheckReq.toString(), CredentialCheckReq.class);

          //Todo: make api call here
          CredentialScanResult result = new CredentialScanResult("Scan all good", RiskStatus.RISK_STATUS_UNKNOWN);
          String json = gson.toJson(result);
          this.echo(json, callbackContext);
          return true;

        }else if(action.equals("checkTypingProfile")){
          String message = args.getString(0);
          this.echo(message, callbackContext);
          return true;
        }
        return false;
    }

    private JSONObject sessionToJson(SessionImpl session) throws JSONException {
        JSONObject sessionJson = new JSONObject();
        sessionJson.put("SessionId", session.getSessionId());
        // Convert other session properties to JSON as needed
        return sessionJson;
    }

    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
