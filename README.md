# moneyguard-cordova-plugin

# TypeScript Models Description

1. **TypingProfileMatchingResult:**  
   Represents the result of matching a typing profile, containing information such as enrollment status, match status, confidence level, and any associated message.

2. **StartingCharactersLength:**  
   Defines the length of starting characters used in a particular context, typically used for password fragment lengths.

3. **SessionExpiredException:**  
   Custom exception class representing a session expiration error.

4. **RiskStatus:**  
   Enumeration representing different risk statuses, including "unknown", "safe", "warn", and "unsafe".

5. **DebitTransaction:**  
   Represents a debit transaction, containing information such as source account number, amount, memo, destination bank, and destination account number.

6. **DebitTransactionCheckResult:**  
   Result of checking a debit transaction, indicating success status, message, and associated risk status.

7. **Credential:**  
   Represents user credentials, including username, password hash, password fragment length, hash algorithm, and domain.

8. **CredentialScanResult:**  
   Result of scanning user credentials, containing a message and associated risk status.

9. **IBasicSession:**  
   Interface defining basic session properties and methods, including installation and session IDs, debit transaction and credential checks, typing profile recorder, and session expiration event handler.

10. **ITypingProfileRecorder:**  
    Interface defining methods for recording typing profiles, including capturing typing fragments, handling keyboard events, resetting profiles, and matching typing profiles.

11. **HashAlgorithm:**  
    Enumeration representing different hash algorithms, including "SHA1", "SHA256", "SHA384", and "SHA512".