import { RiskScore } from "./RiskScore";
import { RiskStatus } from "./RiskStatus";

export class SpecificRisk {
    public static SPECIFIC_RISK_DEVICE_SECURITY_MISCONFIGURATION_NAME = "Security Misconfiguration";
    public static SPECIFIC_RISK_DEVICE_VULNERABILITY_NAME = "Vulnerabilities";
    public static SPECIFIC_RISK_NETWORK_MITM_NAME = "Man-In-The-Middle";
    public static SPECIFIC_RISK_NETWORK_DNS_SPOOFING_NAME = "DNS Spoofing";
    public static SPECIFIC_RISK_NETWORK_WIFI_ENCRYPTION_NAME = "WiFi Encryption";
    public static SPECIFIC_RISK_NETWORK_WIFI_PASSWORD_PROTECTION_NAME = "WiFi Password Protection";
    public static SPECIFIC_RISK_DEVICE_ROOT_OR_JAILBREAK_NAME = "Root/Jail Break";
    public static SPECIFIC_RISK_USER_IDENTITY_COMPROMISE_NAME = "Identity Compromise";
    public static SPECIFIC_RISK_USER_BIOMETRIC_PROFILE_NAME = "Biometric Profile";
    public static SPECIFIC_RISK_APPLICATION_PHISHING_NAME = "Phishing";
    public static SPECIFIC_RISK_APPLICATION_MALWARE_NAME = "Malware";
    public static SPECIFIC_RISK_APPLICATION_FAKE_APPS_NAME = "Fake Apps";
    public static SPECIFIC_RISK_APPLICATION_KEY_LOGGING_NAME = "Key Logging";
    public static SPECIFIC_RISK_USER_SECURITY_AWARENESS_NAME = "Security Awareness";

    public Name: string;
    public CategoryName: string;
    public Score: RiskScore;
    public Status: RiskStatus;
    public AdditionalDetails: string;
}