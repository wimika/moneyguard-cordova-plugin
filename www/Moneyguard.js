var exec = require('cordova/exec');

exports.registerGuard = function (arg0, arg1, success, error) {
    exec(success, error, 'Moneyguard', 'register', [arg0, arg1]);
};


exports.checkCredential = function (username, password, success, error) {
    exec(success, error, 'Moneyguard', 'checkCredential', [username, password]);
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


exports.getSession = function (username, password, success, error) {
    exec(success, error, 'Moneyguard', 'getSession', [username, password]);
};