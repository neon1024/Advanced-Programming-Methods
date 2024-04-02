package C_2;

import java.util.ArrayList;

/*
    Compute the most specific signatures for the class Amain methods
    (method1 and method2) such that the entire program is correct.
    If it is not possible to find the types justify your answer.
    Discuss line by line the correctness of the above program.

    A
    |
    B
    |
    C
 */

public class Amain {

    A method1(ArrayList<? extends A> list) {
        if(list.isEmpty()) {
            return null;
        }

        return list.get(1);
    }

    /**
        Why did we use <? super C> here?<br>

        We must use a wildcard that allows writing.
        <? extends> is only a read wildcard.
        <? super> is a read-write wildcard.
     */
    void method2(ArrayList<? super C> list, C elem) {
        list.add(elem);
    }

    void method3(C elem) {
        ArrayList<A> listA = new ArrayList<A>(); listA.add(new A());
        ArrayList<B> listB = new ArrayList<B>(); listB.add(new B());
        ArrayList<C> listC = new ArrayList<C>(); listC.add(new C());

        this.method1(listA); this.method1(listB); this.method1(listC);
        this.method2(listA, elem); this.method2(listB, elem); this.method2(listC, elem);
    }
}
