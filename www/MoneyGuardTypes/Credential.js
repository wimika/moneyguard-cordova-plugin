"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.MoneyGuardCredential = void 0;
var MoneyGuardCredential = /** @class */ (function () {
    function MoneyGuardCredential(Username, PasswordStartingCharactersHash, PasswordFragmentLength, HashAlgorithm, Domain) {
        this.Username = Username;
        this.PasswordStartingCharactersHash = PasswordStartingCharactersHash;
        this.PasswordFragmentLength = PasswordFragmentLength;
        this.HashAlgorithm = HashAlgorithm;
        this.Domain = Domain;
    }
    return MoneyGuardCredential;
}());
exports.MoneyGuardCredential = MoneyGuardCredential;
