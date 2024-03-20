import { RiskStatus } from "./RiskStatus";
import { SpecificRisk } from "./SpecificRisk";

export class RiskResult {
    public Success: boolean;
    public Message: string;
    public Status: RiskStatus;
    public Risks: SpecificRisk[];
}