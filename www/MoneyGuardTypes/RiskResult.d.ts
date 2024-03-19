import { RiskStatus } from "./RiskStatus";
import { SpecificRisk } from "./SpecificRisk";
export declare class RiskResult {
    Success: boolean;
    Message: string;
    Status: RiskStatus;
    Risks: SpecificRisk[];
}
