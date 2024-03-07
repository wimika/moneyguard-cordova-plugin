var exec = require('cordova/exec');

exports.registerGuard = function (arg0, success, error) {
    exec(success, error, 'Moneyguard', 'Register', [arg0]);
};

exports.echo = function(arg0, success, error) {
    exec(success, error, "Moneyguard", "echo", [arg0]);
};
