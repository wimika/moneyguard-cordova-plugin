package com.wimika.ionic.moneyguard;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.util.Log;


/**
 * This class echoes a string called from JavaScript.
 */
public class Moneyguard extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        Log.d("MoneyguardPlugin", "Executing " + action + " action");
        if (action.equals("registerGuard")) {
            // String partnerBankId = args.getString(0);
            // String sessionToken = args.getString(1);
            // this.registerGuard(partnerBankId, sessionToken, callbackContext);
            // return true;
        }else if(action.equals("echo")){
            String message = args.getString(0);
            this.echo(message, callbackContext);
            return true;
        }
        return false;
    }

    private void registerGuard(String partnerBankId, String sessionToken, CallbackContext callbackContext) {
        // if (partnerBankId != null && partnerBankId.length() > 0
        //         && sessionToken != null && sessionToken.length() > 0) {
        //     MoneyGuardSdk.register(this, partnerBankId, sessionToken, null);
        //     callbackContext.success("success integrating moneyguard");
        // } else {
        //     callbackContext.error("Expected one non-empty string argument.");
        // }
    }

    private void echo(String message, CallbackContext callbackContext) {
        if (message != null && message.length() > 0) {
            callbackContext.success(message);
        } else {
            callbackContext.error("Expected one non-empty string argument.");
        }
    }
}
