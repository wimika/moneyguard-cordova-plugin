interface ITypingProfileRecorder {
    TypingFragment: string;
    OnKeydown(): void;
    OnTextChanged(newText: string): void;
    Reset(): void;
    MatchTypingProfile(): Promise<TypingProfileMatchingResult>;
}
