import { RiskStatus } from "./RiskStatus";

export class CredentialScanResult {
    public Message: string;
    public Status: RiskStatus;

    constructor(Message: string, Status: RiskStatus) {
        this.Message = Message;
        this.Status = Status;
    }
}
