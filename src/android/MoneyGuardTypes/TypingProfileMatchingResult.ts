class TypingProfileMatchingResult {
    public IsEnrolledOnThisDevice: boolean;
    public Matched: boolean;
    public HighConfidence: boolean;
    public HasOtherEnrollments: boolean;
    public Success: boolean;
    public Message: string;

    constructor(
        IsEnrolledOnThisDevice: boolean,
        Matched: boolean,
        HighConfidence: boolean,
        HasOtherEnrollments: boolean,
        Success: boolean,
        Message: string
    ) {
        this.IsEnrolledOnThisDevice = IsEnrolledOnThisDevice;
        this.Matched = Matched;
        this.HighConfidence = HighConfidence;
        this.HasOtherEnrollments = HasOtherEnrollments;
        this.Success = Success;
        this.Message = Message;
    }
}
