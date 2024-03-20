"use strict";
var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.DebitTransactionCheckResult = void 0;
var RiskResult_1 = require("./RiskResult");
var DebitTransactionCheckResult = /** @class */ (function (_super) {
    __extends(DebitTransactionCheckResult, _super);
    function DebitTransactionCheckResult() {
        return _super !== null && _super.apply(this, arguments) || this;
    }
    return DebitTransactionCheckResult;
}(RiskResult_1.RiskResult));
exports.DebitTransactionCheckResult = DebitTransactionCheckResult;
