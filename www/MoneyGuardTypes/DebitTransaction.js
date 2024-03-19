"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.DebitTransaction = void 0;
var DebitTransaction = /** @class */ (function () {
    function DebitTransaction(SourceAccountNumber, Amount, Memo, DestinationBank, DestinationAccountNumber) {
        this.SourceAccountNumber = SourceAccountNumber;
        this.Amount = Amount;
        this.Memo = Memo;
        this.DestinationBank = DestinationBank;
        this.DestinationAccountNumber = DestinationAccountNumber;
    }
    return DebitTransaction;
}());
exports.DebitTransaction = DebitTransaction;
