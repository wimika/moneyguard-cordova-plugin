import { HashAlgorithm } from "./HashAlgorithm";
import { StartingCharactersLength } from "./StartingCharactersLength";
export declare class MoneyGuardCredential {
    Username: string;
    PasswordStartingCharactersHash: string;
    PasswordFragmentLength: StartingCharactersLength;
    HashAlgorithm: HashAlgorithm;
    Domain: string;
    constructor(Username: string, PasswordStartingCharactersHash: string, PasswordFragmentLength: StartingCharactersLength, HashAlgorithm: HashAlgorithm, Domain: string);
}
