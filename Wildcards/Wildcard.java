public class Wildcard<T> {

    private T member;

    public Wildcard(T member) {
        this.member = member;
    }

    public void shout_out() {
        System.out.println(this.member);
    }
    
    public static void shout_out(String message) {
        System.out.println(message);
    }
}
