class MoneyGuardCredential {
    public Username: string;
    public PasswordStartingCharactersHash: string;
    public PasswordFragmentLength: StartingCharactersLength;
    public HashAlgorithm: HashAlgorithm;
    public Domain: string;

    constructor(
        Username: string,
        PasswordStartingCharactersHash: string,
        PasswordFragmentLength: StartingCharactersLength,
        HashAlgorithm: HashAlgorithm,
        Domain: string
    ) {
        this.Username = Username;
        this.PasswordStartingCharactersHash = PasswordStartingCharactersHash;
        this.PasswordFragmentLength = PasswordFragmentLength;
        this.HashAlgorithm = HashAlgorithm;
        this.Domain = Domain;
    }
}
