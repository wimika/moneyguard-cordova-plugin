"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.RiskStatus = void 0;
var RiskStatus;
(function (RiskStatus) {
    RiskStatus[RiskStatus["RISK_STATUS_UNKNOWN"] = 0] = "RISK_STATUS_UNKNOWN";
    RiskStatus[RiskStatus["RISK_STATUS_SAFE"] = 1] = "RISK_STATUS_SAFE";
    RiskStatus[RiskStatus["RISK_STATUS_WARN"] = 2] = "RISK_STATUS_WARN";
    RiskStatus[RiskStatus["RISK_STATUS_UNSAFE"] = 3] = "RISK_STATUS_UNSAFE";
})(RiskStatus || (exports.RiskStatus = RiskStatus = {}));
