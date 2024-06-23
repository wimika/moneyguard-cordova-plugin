package com.wimika.ionic;

import com.wimika.moneyguardcore.BasicClient;
import com.wimika.moneyguardcore.CredentialScanResult;
import com.wimika.moneyguardcore.BasicSession;
import com.wimika.moneyguardcore.TransactionCheckResult;
import com.wimika.moneyguardcore.TypingProfileMatchingResult;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class BasicClientImpl implements BasicClient {
    private final ConcurrentHashMap<Long, CredentialScanResult> scanResults = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Long, TransactionCheckResult> scanDebitResults = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Long, TypingProfileMatchingResult> typingProfileResults = new ConcurrentHashMap<>();

    private final ConcurrentHashMap<Long, CountDownLatch> scanLatches = new ConcurrentHashMap<>();

    @Override
    public void onSessionCreated(BasicSession session) {
        // Handle session creation
    }

    @Override
    public void onSessionExpired(String sessionId) {
        // Handle session expiration
    }

    @Override
    public void onCredentialScanCompleted(long id, CredentialScanResult result) {
        scanResults.put(id, result);
        CountDownLatch latch = scanLatches.get(id);
        if (latch != null) {
            latch.countDown();
        }
    }

    @Override
    public void onTransactionCheckCompleted(long id, TransactionCheckResult result) {
      scanDebitResults.put(id, result);
      CountDownLatch latch = scanLatches.get(id);
      if (latch != null) {
        latch.countDown();
      }
    }

    @Override
    public void onTypingProfileMatchResult(long id, TypingProfileMatchingResult result) {
      typingProfileResults.put(id, result);
      CountDownLatch latch = scanLatches.get(id);
      if (latch != null) {
        latch.countDown();
      }
    }

    public CredentialScanResult getScanResult(long id) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        scanLatches.put(id, latch);
        latch.await(); // Wait until the result is available
        return scanResults.get(id);
    }

    public TransactionCheckResult getDebitScanResult(long id) throws InterruptedException {
      CountDownLatch latch = new CountDownLatch(1);
      scanLatches.put(id, latch);
      latch.await(); // Wait until the result is available
      return scanDebitResults.get(id);
    }

    public TypingProfileMatchingResult getTypingResult(long id) throws InterruptedException {
      CountDownLatch latch = new CountDownLatch(1);
      scanLatches.put(id, latch);
      latch.await(); // Wait until the result is available
      return typingProfileResults.get(id);
    }

}
