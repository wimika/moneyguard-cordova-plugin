import { CredentialScanResult } from "./CredentialScanResult";
import { DebitTransaction } from "./DebitTransaction";
import { DebitTransactionCheckResult } from "./DebitTransactionCheckResult";
import { ITypingProfileRecorder } from "./ITypingProfileRecorder";

export interface IBasicSession {
    InstallationId: string;
    SessionId: string;
    CheckDebitTransaction(transaction: DebitTransaction): Promise<DebitTransactionCheckResult>;
    CheckCredential(credential: Credential): Promise<CredentialScanResult>;
    TypingProfileRecorder: ITypingProfileRecorder;
    SessionExpired: object;
}