public class ValidatorMinHeap<E extends Comparable<E>> implements IBTValidator<E> {
    @Override
    public boolean validAdd(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        boolean inNewTree = containsElt(elt, newTree);
        boolean oldInNew = containsAll(oldTree, newTree);
        boolean sizeCheck = newTree.size() == oldTree.size() + 1;
        boolean bstInv = minheapInvariant(newTree);
        return inNewTree && oldInNew && sizeCheck && bstInv;
    }

    public boolean biggerThanAll(E elt, IBinTree<E> someTree){
        if(someTree.isEmpty()) { return true; }
        else {
            E root = someTree.getRoot();
            IBinTree<E> left = someTree.getLeft();
            IBinTree<E> right = someTree.getRight();
            return elt.compareTo(root) > 0 && this.biggerThanAll(elt, left) &&
                                              this.biggerThanAll(elt, right);
        }
    }

    public boolean smallerThanAll(E elt, IBinTree<E> someTree){
        if(someTree.isEmpty()) { return true; }
        else {
            E root = someTree.getRoot();
            IBinTree<E> left = someTree.getLeft();
            IBinTree<E> right = someTree.getRight();
            return elt.compareTo(root) < 0 && this.smallerThanAll(elt, left) &&
                    this.smallerThanAll(elt, right);
        }
    }

    public boolean minheapInvariant(IBinTree<E> someTree){
        if(someTree.isEmpty()) { return true; }
        else {
            E root = someTree.getRoot();;
            IBinTree<E> left = someTree.getLeft();
            IBinTree<E> right = someTree.getRight();

            return smallerThanAll(root, left) &&
                    smallerThanAll(root, right) &&
                    minheapInvariant(left) &&
                    minheapInvariant(right);
        }
    }

    public boolean containsElt(E elt, IBinTree<E> newTree){
        if(newTree.isEmpty()){
            return false;
        }
        else{
            E root = newTree.getRoot();
            IBinTree<E> left = newTree.getLeft();
            IBinTree<E> right = newTree.getRight();
            if(elt.equals(root)){
                return true;
            }
            else {
                return this.containsElt(elt, left) || this.containsElt(elt, right);
            }
        }
    }

    public boolean containsAll(IBinTree<E> elements, IBinTree<E> container){
        if(elements.isEmpty()){
            return true;
        }
        else{
            E root = elements.getRoot();
            IBinTree<E> left = elements.getLeft();
            IBinTree<E> right = elements.getRight();
            if(! this.containsElt(root, container)){
                return false;
            }
            else{
                return this.containsAll(left, container) &&
                        this.containsAll(right, container);
            }
        }
    }





    @Override
    public boolean validRemove(IBinTree<E> oldTree, E elt, IBinTree<E> newTree) {
        boolean notInNewTree = !containsElt(elt, newTree);
        boolean newInOld = containsAll(newTree, oldTree);
        boolean sizeCheck = newTree.size() == oldTree.size() - 1;
        boolean bstInv = minheapInvariant(newTree);
        return notInNewTree && newInOld && sizeCheck && bstInv;
    }
}
