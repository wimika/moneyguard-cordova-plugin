class DebitTransactionCheckResult {
    public Success: boolean;
    public Message: string;
    public Status: RiskStatus;

    constructor(Success: boolean, Message: string, Status: RiskStatus) {
        this.Success = Success;
        this.Message = Message;
        this.Status = Status;
    }
}
