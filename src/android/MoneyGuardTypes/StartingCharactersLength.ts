class StartingCharactersLength {
    public static FIVE: StartingCharactersLength = new StartingCharactersLength(5);
    public static FOUR: StartingCharactersLength = new StartingCharactersLength(4);
    public static THREE: StartingCharactersLength = new StartingCharactersLength(3);

    private _length: number;

    constructor(length: number) {
        this._length = length;
    }

    public get Length(): number {
        return this._length;
    }
}
