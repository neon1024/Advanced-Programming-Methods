/*
    <? extends BaseClass>, allows receiving BaseClass and ChildClass

        A
      /   \
    B       C
 */

package b_exercise_1;

import java.util.ArrayList;

public class Amain {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    A method1(ArrayList<? extends A> list) {
        if (list.isEmpty()) return null;

        return list.get(1);
    }

    void method2(ArrayList<? extends A> list) {
        list.add(null);
    }

    void method3() {
        ArrayList<A> listA = new ArrayList<A>();
        listA.add(new A());

        ArrayList<B> listB = new ArrayList<B>();
        listA.add(new B());

        ArrayList<C> listC = new ArrayList<C>();
        listA.add(new C());

        this.method1(listA);
        this.method1(listB);
        this.method1(listC);
        this.method2(listA);
        this.method2(listB);
        this.method2(listC);
    }
}
