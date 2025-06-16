public interface Tree<E>{
    Position<E> root(); //return the element at the root node. If T is empty, return null
    boolean isRoot(Position<E> p); //return True if node is the root. Otherwise, return False
    Position<E> parent(Position<E> p); //return the parent (element value) of node. null if the node is the root. 

    //I dont know what data type to give to this method
    //T.children(node) 
    //generate an iteration of the children of node

    boolean isLeaf(Position<E> p); //return True if node is leaf, False otherwise
    int size(); //return number of nodes in the tree T
    boolean isEmpty(); //return True if T is empty.  False otherwise
}
