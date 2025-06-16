public class BTree<E> implements Tree<E>{
    private Node<E> root;
    private int size;

    public Position<E> root(){return root;}
    public boolean isEmpty(){return root == null;}
    public int size(){return size;}

    public boolean isRoot(Position<E> p){
        Node<E> n = validate(p);
        return n.getParent() == null;
    }
    public boolean isLeaf(Position<E> p){
        Node<E> n = validate(p);
        return n.getLeft() == null && n.getRight() == null;
    }
    public Position<E> parent(Position<E> p){
        Node<E> n = validate(p);
        return n.getParent();
    }
    public Position<E> left(Position<E> p){
        Node<E> n = validate(p);
        return n.getLeft();
    }
    public Position<E> right(Position<E> p){
        Node<E> n = validate(p);
        return n.getRight();
    }
    //Add Left, Add right
    public void addLeft(Position<E> p, E elem){
        Node<E> targetNode = validate(p);
        Node<E> newNode = new Node(elem, targetNode, null, null);
        if(targetNode.getLeft() != null){
            newNode.setLeft(targetNode.getLeft());
            targetNode.getLeft().setParent(newNode);
        }
        targetNode.setLeft(newNode);
    }
    public void addRight(Position<E> p, E elem){
        Node<E> targetNode = validate(p);
        Node<E> newNode = new Node(elem, targetNode, null, null);
        if(targetNode.getRight() != null){
            newNode.setLeft(targetNode.getRight());
            targetNode.getRight().setParent(newNode);
        }
        targetNode.setRight(newNode);
    }
    private Node<E> validate(Position<E> p){
        if(!(p instanceof Node<E>))
            throw new IllegalArgumentException("The position entered is not a node");
        return (Node<E>)p;
    }
    private Position<E> position(Node <E> node){
        return node;
    }
    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> parent;
        private Node<E> left;
        private Node<E> right;
        public Node(E e, Node<E> p, Node<E> l, Node<E> r){
            element = e;
            parent = p;
            left = l;
            right = r;
        }
        public E getElement(){return element;}

        public Node<E> getParent(){return parent;}
        public Node<E> getLeft(){return left;}
        public Node<E> getRight(){return right;}
        public void setElement(E e){element = e;}
        public void setParent(Node<E> p){parent = p;}
        public void setLeft(Node<E> l){left = l;}
        public void setRight(Node<E> r){right = r;}
    }
}
