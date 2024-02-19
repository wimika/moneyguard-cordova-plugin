interface IBasicSession {
    InstallationId: string;
    SessionId: string;
    CheckDebitTransaction(transaction: DebitTransaction): Promise<DebitTransactionCheckResult>;
    CheckCredential(credential: Credential): Promise<CredentialScanResult>;
    TypingProfileRecorder: ITypingProfileRecorder;
    SessionExpired: object;
}