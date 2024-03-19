"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.TypingProfileMatchingResult = void 0;
var TypingProfileMatchingResult = /** @class */ (function () {
    function TypingProfileMatchingResult(IsEnrolledOnThisDevice, Matched, HighConfidence, HasOtherEnrollments, Success, Message) {
        this.IsEnrolledOnThisDevice = IsEnrolledOnThisDevice;
        this.Matched = Matched;
        this.HighConfidence = HighConfidence;
        this.HasOtherEnrollments = HasOtherEnrollments;
        this.Success = Success;
        this.Message = Message;
    }
    return TypingProfileMatchingResult;
}());
exports.TypingProfileMatchingResult = TypingProfileMatchingResult;
