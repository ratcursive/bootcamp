

public class PositionalLinkedList<E> implements PositionalList<E>{
    int size;
    //Initialized as dummy nodes in the contructor
    //Head point to prev null and next tail
    //Tail points to prev head and next null
    private Node<E> head;
    private Node<E> tail;
    
    public PositionalLinkedList(){
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, head, null);
        head.setNext(tail);
    }
    public int size(){return size;}
    public boolean isEmpty(){return head.getNext() == tail;}

    public Position<E> first(){
        //validate that its a node
        return position(head.getNext());
    }
    public Position<E> last(){
        //validate
        return position(tail.getPrev());
    }
    public Position<E> before(Position<E> p){
        //validate
        Node<E> currNode = validate(p);
        return position(currNode.getPrev());
    }
    public Position<E> after(Position<E> p){
        //validate
        Node<E> currNode = validate(p);
        return position(currNode.getNext());
    }
    public Position<E> addFirst(E e){
        Node<E> newNode = new Node<E>(e, head, head.getNext());
        head.getNext().setPrev(newNode);
        head.setNext(newNode);
        size++;
        return position(newNode);
    }
    public Position<E> addLast(E e){
        Node<E> newNode = new Node<E>(e, tail.getPrev(), tail);
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        size++;
        return newNode;
    }
    public Position<E> addBefore(Position<E> p, E e){
        Node<E> validNode = validate(p);
        Node<E> newNode = new Node<E>(e, validNode.getPrev(), validNode);
        validNode.getPrev().setNext(newNode);
        validNode.setPrev(newNode);
        size++;
        return newNode;
    }
    public Position<E> addAfter(Position<E> p, E e){
        Node<E> validNode = validate(p);
        Node<E> newNode = new Node<E>(e, validNode, validNode.getNext());
        validNode.getNext().setPrev(newNode);
        validNode.setNext(newNode);
        size++;
        return newNode;
    }
    public E set(Position<E> p, E e){
        Node<E> currNode = validate(p);
        E oldElement = currNode.getElement();
        currNode.setElement(e);
        return oldElement;
    }
    public E remove(Position<E> p){
        if(isEmpty())
            throw new IllegalStateException("The list is already empty");
        Node<E> currNode = validate(p);
        currNode.getNext().setPrev(currNode.getPrev());
        currNode.getPrev().setNext(currNode.getNext());
        size--;
        return currNode.getElement();
    }
    public String toString(){
        String builder = "";
        int index = 1;
        Node<E> currNode = head;
        while(currNode.getNext() != tail){
            builder += index+": " + currNode.getNext().getElement().toString()+"\n";
            currNode = currNode.getNext();
            index++;
        }
        return builder;
    }
    public void reverseList(){
        Node<E> anchorNode = tail.getPrev();
        Node<E> currNode = head.getNext();
        if(currNode != tail || currNode.getNext() != tail){
            while(currNode != anchorNode){
                moveBehind(currNode,anchorNode);
                currNode = head.getNext();
            }
        }  
    }
    public void reverseListRecur(){
        reverseListRecur(head.getNext(),tail.getPrev());
    }
    private void reverseListRecur(Node<E> currentP, Node<E> anchorP){
        if(size > 1 && currentP != anchorP){
            moveBehind(currentP,anchorP);
            reverseListRecur(head.getNext(), anchorP);
        }
    }
    public void insertAfterNSteps(int n, E elem){
        Node<E> currNode = head.getNext();
        int steps = 0;
        while(currNode != null){ 
            for(int i = 0; i < n; i++){
                currNode = currNode.getNext();
                steps++;
            }
            if(currNode != null)
                addBeforeIndex(steps, elem);
        }
    }
    //Methods only used to test the class
    public void addBeforeIndex(int index, E e){
        addBefore(selectPositionAt(index), e);
    }
    public void addAfterIndex(int index, E e){
        addAfter(selectPositionAt(index), e);
    }
    public E removeAtIndex(int index){
        return remove(selectPositionAt(index));
    }
    public E setAtIndex(int index, E newElement){
        return set(selectPositionAt(index), newElement);
    }
    private Position<E> selectPositionAt(int index){
        int count = 0;
        Node<E> currNode = head;
        while(count < index && currNode.getNext().getNext() != null){
            count++;
            currNode = currNode.getNext();
        }
        if(count != index)
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
        return position(currNode);
    }
    //End of test methods
    private void moveBehind(Position<E> p, Position<E> t){
        Node<E> node = validate(p);
        Node<E> target = validate(t);
        node.getNext().setPrev(node.getPrev());
        node.getPrev().setNext(node.getNext());
        node.setNext(target.getNext());
        node.setPrev(target);
        target.getNext().setPrev(node);
        target.setNext(node);
    }
    private Node<E> validate(Position<E> p){
        if(!(p instanceof Node<E>))
            throw new IllegalArgumentException("The position entered is not a node");
        return (Node<E>)p;
    }
    private Position<E> position(Node <E> node){
        //If head or tail, return null
        if( node.getNext() == null || node.getPrev() == null )
            return null;
        return node;
    }
    private static class Node<E> implements Position<E>{
        private E element;
        private Node<E> prev;
        private Node<E> next;
        public Node(E e, Node<E> p, Node<E> n){
            element = e;
            prev = p;
            next = n;
        }
        public E getElement(){
            if (next == null)
                throw new IllegalStateException("Position no longer valid");
            return element;
        }
        public Node<E> getPrev(){return prev;}
        public Node<E> getNext(){return next;}
        public void setElement(E e){element = e;}
        public void setPrev(Node<E> p){prev = p;}
        public void setNext(Node<E> n){next = n;}
    }
}