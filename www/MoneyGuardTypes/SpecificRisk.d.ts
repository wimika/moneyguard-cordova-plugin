import { RiskScore } from "./RiskScore";
import { RiskStatus } from "./RiskStatus";
export declare class SpecificRisk {
    static SPECIFIC_RISK_DEVICE_SECURITY_MISCONFIGURATION_NAME: string;
    static SPECIFIC_RISK_DEVICE_VULNERABILITY_NAME: string;
    static SPECIFIC_RISK_NETWORK_MITM_NAME: string;
    static SPECIFIC_RISK_NETWORK_DNS_SPOOFING_NAME: string;
    static SPECIFIC_RISK_NETWORK_WIFI_ENCRYPTION_NAME: string;
    static SPECIFIC_RISK_NETWORK_WIFI_PASSWORD_PROTECTION_NAME: string;
    static SPECIFIC_RISK_DEVICE_ROOT_OR_JAILBREAK_NAME: string;
    static SPECIFIC_RISK_USER_IDENTITY_COMPROMISE_NAME: string;
    static SPECIFIC_RISK_USER_BIOMETRIC_PROFILE_NAME: string;
    static SPECIFIC_RISK_APPLICATION_PHISHING_NAME: string;
    static SPECIFIC_RISK_APPLICATION_MALWARE_NAME: string;
    static SPECIFIC_RISK_APPLICATION_FAKE_APPS_NAME: string;
    static SPECIFIC_RISK_APPLICATION_KEY_LOGGING_NAME: string;
    static SPECIFIC_RISK_USER_SECURITY_AWARENESS_NAME: string;
    Name: string;
    CategoryName: string;
    Score: RiskScore;
    Status: RiskStatus;
    AdditionalDetails: string;
}
