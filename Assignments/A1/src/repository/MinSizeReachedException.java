package repository;

public class MinSizeReachedException extends Exception {
    public MinSizeReachedException() {
        super("[!] No more elements to remove");
    }
}
