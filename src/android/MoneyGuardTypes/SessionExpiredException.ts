class SessionExpiredException extends Error {
    constructor() {
        super("Session expired");
        // Set the prototype explicitly.
        (Object as any).setPrototypeOf(this, SessionExpiredException.prototype);
    }
}
