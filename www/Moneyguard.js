var exec = require('cordova/exec');

exports.registerGuard = function (arg0, arg1, success, error) {
    exec(success, error, 'Moneyguard', 'register', [arg0, arg1]);
};


exports.checkCredential = function (checkCredentialReq, success, error) {
    exec(success, error, 'Moneyguard', 'checkCredential', [checkCredentialReq]);
};


exports.checkTypingProfile = function (checkTypingProfileReq, success, error) {
    exec(success, error, 'Moneyguard', 'checkTypingProfile', [checkTypingProfileReq]);
};


exports.checkDebitTransaction = function (checkTransactionReq, success, error) {
    exec(success, error, 'Moneyguard', 'checkDebitTransaction', [checkTransactionReq]);
};


exports.getRiskProfile = function (success, error) {
    exec(success, error, 'Moneyguard', 'getRiskProfile');
};