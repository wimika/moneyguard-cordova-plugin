export class DebitTransaction {
    public SourceAccountNumber: string;
    public Amount: number;
    public Memo: string;
    public DestinationBank: string;
    public DestinationAccountNumber: string;

    constructor(
        SourceAccountNumber: string,
        Amount: number,
        Memo: string,
        DestinationBank: string,
        DestinationAccountNumber: string
    ) {
        this.SourceAccountNumber = SourceAccountNumber;
        this.Amount = Amount;
        this.Memo = Memo;
        this.DestinationBank = DestinationBank;
        this.DestinationAccountNumber = DestinationAccountNumber;
    }
}
