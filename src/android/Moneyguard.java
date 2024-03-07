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

 public interface IBasicSession {
    String getInstallationId();
    String getSessionId();
}

public class BasicSessionMock implements IBasicSession {
    private String installationId;
    private String sessionId;

    public BasicSessionMock(String installationId, String sessionId) {
        this.installationId = installationId;
        this.sessionId = sessionId;
    }

    @Override
    public String getInstallationId() {
        return installationId;
    }

    @Override
    public String getSessionId() {
        return sessionId;
    }
}

public class Moneyguard extends CordovaPlugin {


    private IBasicSession registerGuard(String partnerBankId, String sessionToken) {
        // Mock implementation using BasicSessionMock
        return new BasicSessionMock(partnerBankId, sessionToken);
    }

    private JSONObject sessionToJson(IBasicSession session) {
        JSONObject json = new JSONObject();
        try {
            json.put("InstallationId", session.getInstallationId());
            json.put("SessionId", session.getSessionId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        Log.d("MoneyguardPlugin", "Executing " + action + " action");
        if (action.equals("Register")) {
            String partnerBankId = args.getString(0);
            String sessionToken = args.getString(1);
            IBasicSession session = registerGuard(partnerBankId, sessionToken);
            JSONObject sessionJson = sessionToJson(session);
            callbackContext.success(sessionJson);
            return true;
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
