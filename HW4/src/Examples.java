import org.junit.Test;

import static org.junit.Assert.*;

public class Examples {
    @Test
    public void testTests(){
        assertEquals(1, 1);
        assertFalse(false);
        assertTrue(true);
    }

    BTEmpty<Integer> mt = new BTEmpty<Integer>();

    IBinTree<Integer> exMaxHeap =
            new BTNode<>(7,
                    new BTNode<>(3,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(2, mt, mt)),
                    new BTNode<>(5, mt,
                            new BTNode<>(4, mt, mt)));

    IBinTree<Integer> randHeap =
            new BTNode<>(43,
                    new BTNode<>(341234,
                            new BTNode<>(1432, mt, mt),
                            new BTNode<>(2432, mt, mt)),
                    new BTNode<>(1235, mt,
                            new BTNode<>(443, mt, mt)));

    IBinTree<Integer> afterAdd6 =
            new BTNode<>(7,
                    new BTNode<>(6,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(3,
                                    new BTNode<>(2, mt, mt), mt)),
                    new BTNode<>(5, mt,
                            new BTNode<>(4, mt, mt)));

    IBinTree<Integer> otherAfterAdd6 =
            new BTNode<>(7,
                    new BTNode<>(6,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(3,
                                    new BTNode<>(2, mt, mt), mt)),
                    new BTNode<>(5,
                            new BTNode<>(4, mt, mt), mt));

    IBinTree<Integer> badAfterAdd6 =
            new BTNode<>(7,
                    new BTNode<>(6,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(2,
                                    new BTNode<>(3, mt, mt), mt)),
                    new BTNode<>(5,
                            new BTNode<>(4, mt, mt), mt));

    IBinTree<Integer> afterRemove5 =
            new BTNode<>(7,
                    new BTNode<>(3,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(2, mt, mt)),
                    new BTNode<>(4, mt, mt));

    IBinTree<Integer> alsoGoodAfterRemove5 =
            new BTNode<>(7,
                    new BTNode<>(3,
                            new BTNode<>(2, mt, mt),
                            new BTNode<>(1, mt, mt)),
                    new BTNode<>(4, mt, mt));

    IBinTree<Integer> badAfterRemove5 =
            new BTNode<>(7,
                    new BTNode<>(3,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(2, mt, mt)), mt);

    IBinTree<Integer> alsoBadAfterRemove5 =
            new BTNode<>(7,
                    new BTNode<>(2,
                            new BTNode<>(1, mt, mt),
                            new BTNode<>(3, mt, mt)),
                    new BTNode<>(4, mt, mt));

    IBinTree<Integer> exMinHeap =
            new BTNode<>(1,
                    new BTNode<>(2,
                            new BTNode<>(3, mt, mt),
                            new BTNode<>(4, mt, mt)),
                    new BTNode<>(5, mt,
                            new BTNode<>(6, mt, mt)));

    IBinTree<Integer> exMinHeapAdd7 =
            new BTNode<>(1,
                    new BTNode<>(2,
                            new BTNode<>(3, mt, mt),
                            new BTNode<>(4, mt, mt)),
                    new BTNode<>(5,
                            new BTNode<>(7, mt, mt),
                            new BTNode<>(6, mt, mt)));

    IBinTree<Integer> exMinHeapRemove5 =
            new BTNode<>(1,
                    new BTNode<>(2,
                            new BTNode<>(3, mt, mt),
                            new BTNode<>(4, mt, mt)),
                    new BTNode<>(6, mt, mt));

    IBinTree<Integer> badExMinHeapRemove5 =
            new BTNode<>(1,
                    new BTNode<>(2,
                            new BTNode<>(3, mt, mt),
                            new BTNode<>(4, mt, mt)),
                    mt);

    IBinTree<Integer> alsoBadExMinHeapRemove5 =
            new BTNode<>(4,
                    new BTNode<>(2,
                            new BTNode<>(3, mt, mt),
                            new BTNode<>(1, mt, mt)),
                    mt);

    @Test
    public void testAdd6OK(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validAdd(exMaxHeap, 6, afterAdd6));
    }

    @Test
    public void testAdd6ALSOGOOD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validAdd(exMaxHeap, 6, otherAfterAdd6));
    }

    @Test
    public void testAdd6BAD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 6, badAfterAdd6));
    }

    @Test
    public void testAdd6RAND(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 6, randHeap));
    }

    @Test
    public void testAdd6NOADD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validAdd(exMaxHeap, 6, exMaxHeap));
    }


    @Test
    public void testRemove5OK(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validRemove(exMaxHeap, 5, afterRemove5));
    }

    @Test
    public void testRemove5ALSOGOOD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertTrue(maxHValid.validRemove(exMaxHeap, 5, alsoGoodAfterRemove5));
    }
    @Test
    public void testRemove5BAD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(exMaxHeap, 5, badAfterRemove5));
    }

    @Test
    public void testRemove5RAND(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(exMaxHeap, 5, randHeap));
    }

    @Test
    public void testRemove5ALSOBAD(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(exMaxHeap, 5, alsoBadAfterRemove5));
    }

    @Test
    public void testRemove5NOREMOVE(){
        ValidatorMaxHeap<Integer> maxHValid = new ValidatorMaxHeap<>();
        assertFalse(maxHValid.validRemove(exMaxHeap, 5, exMaxHeap));
    }

    @Test
    public void testMinAdd7OK(){
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertTrue(minHValid.validAdd(exMinHeap, 7, exMinHeapAdd7));
    }

    @Test
    public void testMinRemove5OK(){
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertTrue(minHValid.validRemove(exMinHeap, 5, exMinHeapRemove5));
    }

    @Test
    public void testMinRemove5BAD(){
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertFalse(minHValid.validRemove(exMinHeap, 5, badExMinHeapRemove5));
    }

    @Test
    public void testMinRemove5NOCHANGE(){
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertFalse(minHValid.validRemove(exMinHeap, 5, exMinHeap));
    }

    @Test
    public void testMinRemove5INVARIANT(){
        ValidatorMinHeap<Integer> minHValid = new ValidatorMinHeap<>();
        assertFalse(minHValid.validRemove(exMinHeap, 5, alsoBadExMinHeapRemove5));
    }

}
