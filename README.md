## MoneyGuard SDK For Xamarin Sample

MoneyGuard SDK For Ionic allows financial institutions to embed [Moneyguard](https://wimika.ng/moneyguard/) into
their Ionic applications.

## Getting Started

1. Obtain a partner Id from Wimika RMS Technologies

2. Implement a REST API endpoint that exposes [Wimika Partner Bank Service API](https://wimika.gitbook.io/wimika-partner-bank-api-documentation/), provide your service url to Wimika RMS Technologies

3. Embed Wimika Moneyguard in your Android Application

## Usage For Ionic

### 1) Add Cordova Plugin to Your Project

- cordova plugin add moneyguard-ionic@0.0.1

### 2) Initialize MoneyGuard

Initialize Moneyguard. An IBasicSession is an implementation of the methods that support the following Moneyguard
functionality :

- Obtain an authorization token for MoneyGuard REST API service calls
- Credential Compromise Check
- Create a Typing Profile Recorder
- Preview a banking debit transaction before it is processed

```typescript

...
import { Component } from '@angular/core';
declare var cordova: any;

const Moneyguard = cordova.plugins.Moneyguard;
const partnerBankId = <partner-bank-id>; // Obtained from Wimika
const sessionToken = <session-token>; // Session token that will be passed to Partner Bank REST Service to validate user session

Moneyguard.registerGuard(
   partnerBankId,
   sessionToken,
   (session: any) => {
       console.log('Session Object:', session);
   },
   (error: any) => {
       console.error('Error initializing MoneyGuard:', error);
   }
);

...

```

### 3) Credential Compromise Check

A compromised user credential can lead to account takeover with severe adverse financial consequences for an account holder.
Moneyguard SDK supports checking a users credentials for existence of compromise. If such compromise is detected it is strongly advised to
suggest that users change their passwords. The code fragment below shows example of how to use MoneyGuard to check for credential compromise.

```typescript

...
const { checkCredential } = cordova.plugins.Moneyguard;

  var credentialCheckReq = {
    username: "example_user",
    passwordStartingCharactersHash: "example_hash",
    passwordFragmentLength: 10,
    hashAlgorithm: HashAlgorithm.SHA256,
    domain: "example.com"
  };

checkCredential(
    credentialCheckReq,
    (result: any) => {
      var res: CredentialScanResult = result;
      console.log(res);
    },
    (error: any) => {
      console.log(error);
    }
  );

var status = res.Status;
      if (status == RiskStatus.RISK_STATUS_WARN || status == RiskStatus.RISK_STATUS_UNKNOWN) {
        // warn user that their credentials may be compromised and they are strongly advised to
        //change their passowrd
      }
      else if (status == RiskStatus.RISK_STATUS_UNSAFE) {
        //alert user that their credentials are compromised. Require user to change their password before
        //permitting any system access
      }
      else {
        //proceed
      }
...

```

### 4) Typing Profile Check

Moneyguard SDK supports determining the identity of a mobile app user by obtaining a record of how a user types. The process entails an initial
period where the user enrolls their typing profile. The actual mechanism requires MoneyGuard SDK clients to attach event handlers to monitor KeyDown and TextChanged events from a entry widget where user will type a specific piece of text. Example usage is shown below.

```typescript

...
const { checkTypingProfile } = cordova.plugins.Moneyguard;

//Todo

...

```

### 5) Debit Transaction Check

MoneyGuard SDK supports the ability to monitor debit transaction patterns as well as mobile app usage risks that may indicate the likelihood of exposure to cyberfraud. The Moneyguard App is required to provide the capture of the usage risks due to device, network , application and user attack surfaces. Example of Debit transaction check is shown below

```typescript

...
const { checkDebitTransaction } = cordova.plugins.Moneyguard;

  var transactionReq =
  {
    sourceAccountNumber: "CHK-123456789", //Account to debit
    amount: 100000,
    memo: "Electricity Purchase",
    destinationBank: "098", // Destination Bank Code
    destinationAccountNumber: "KGD-987654321" //Destination Account Number
  };

   checkDebitTransaction(
    transactionReq,
    (result: any) => {
      var res: DebitTransactionCheckResult = result;
      console.log(res);
    },
    (error: any) => {
      console.log(error);
    }
  );

  res.Risks.forEach((element: SpecificRisk) => {
        var status = element.Status;
        if (status == RiskStatus.RISK_STATUS_WARN || status == RiskStatus.RISK_STATUS_UNKNOWN) {
          //warn user and proceed with caution
        }
        else if (status == RiskStatus.RISK_STATUS_UNSAFE) {
          //do not proceed
          return;
        }
        else {
          //proceed
        }
      });
...

```

### 6) Get Risk Profile

This method is similar to Debit Check except that it can be called at any time to check the risk profile of the current session before permitting a sensitive operation.

```typescript

...
const { getRiskProfile } = cordova.plugins.Moneyguard;



   getRiskProfile(
    transactionReq,
    (result: any) => {
      var res: DebitTransactionCheckResult = result;
      console.log(res);
    },
    (error: any) => {
      console.log(error);
    }
  );

  res.Risks.forEach((element: SpecificRisk) => {
        var status = element.Status;
        if (status == RiskStatus.RISK_STATUS_WARN || status == RiskStatus.RISK_STATUS_UNKNOWN) {
          //warn user and proceed with caution
        }
        else if (status == RiskStatus.RISK_STATUS_UNSAFE) {
          //do not proceed
          return;
        }
        else {
          //proceed
        }
      });
...

```
