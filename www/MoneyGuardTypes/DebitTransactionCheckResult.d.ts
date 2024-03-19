import { RiskStatus } from "./RiskStatus";
export declare class DebitTransactionCheckResult {
    Success: boolean;
    Message: string;
    Status: RiskStatus;
    constructor(Success: boolean, Message: string, Status: RiskStatus);
}
