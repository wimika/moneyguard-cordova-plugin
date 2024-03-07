

## MoneyGuard SDK For Xamarin Sample

MoneyGuard SDK For Ionic allows financial institutions to embed [Moneyguard](https://wimika.ng/moneyguard/) into
their Ionic applications. 

## Getting Started

1. Obtain a partner Id from Wimika RMS Technologies

2. Implement a REST API endpoint that exposes [Wimika Partner Bank Service API](https://wimika.gitbook.io/wimika-partner-bank-api-documentation/), provide your service url to Wimika RMS Technologies

3. Embed Wimika Moneyguard in your Android Application

## Usage For Ionic

### 1) Add Cordova Plugin to Your Project
- cordova plugin add com.wimika.ionic.moneyguard@0.0.1


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

Moneyguard.Register(
      partnerBankId,
      sessionToken,
      (sessionId: string) => {
        // Use sessionId in REST API call using header "Authorization" : "Bearer <sessionId>"
        console.log('Session ID:', sessionId);
      },
      (error: any) => {
        console.error('Error initializing MoneyGuard:', error);
      }
    );
 ...

 ```