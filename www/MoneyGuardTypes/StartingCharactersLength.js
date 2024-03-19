"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.StartingCharactersLength = void 0;
var StartingCharactersLength = /** @class */ (function () {
    function StartingCharactersLength(length) {
        this._length = length;
    }
    Object.defineProperty(StartingCharactersLength.prototype, "Length", {
        get: function () {
            return this._length;
        },
        enumerable: false,
        configurable: true
    });
    StartingCharactersLength.FIVE = new StartingCharactersLength(5);
    StartingCharactersLength.FOUR = new StartingCharactersLength(4);
    StartingCharactersLength.THREE = new StartingCharactersLength(3);
    return StartingCharactersLength;
}());
exports.StartingCharactersLength = StartingCharactersLength;
