var exec = require('cordova/exec');

exports.registerGuard = function (arg0, arg1, success, error) {
    exec(success, error, 'Moneyguard', 'register', [arg0, arg1]);
};

exports.echo = function(arg0, success, error) {
    exec(success, error, "Moneyguard", "echo", [arg0]);
};


exports.checkCredential = function (checkCredentialReq, success, error) {
    exec(success, error, 'Moneyguard', 'checkCredential', [checkCredentialReq]);
};


exports.checkTypingProfile = function (checkTypingProfileReq, success, error) {
    exec(success, error, 'Moneyguard', 'checkTypingProfile', [checkTypingProfileReq]);
};
