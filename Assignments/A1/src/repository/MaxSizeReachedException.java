package repository;

public class MaxSizeReachedException extends Exception {
    public MaxSizeReachedException() {
        super("[!] Can't add more elements");
    }
}
