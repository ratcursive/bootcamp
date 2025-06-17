public class LinkedList <E>{
    private Node<E> head;
    private int size;

    public LinkedList(){
    }
    public int getSize(){
        return size;
    }
    public E getFirst(){
        return head.getValue();
    }
    public void empty(){
        head = null;
    }
    public E getLast(){
        Node<E> currentNode = head;
        while(currentNode.getNextNodeLink() != null){
            currentNode = currentNode.getNextNodeLink();
        }
        return currentNode.getValue();
    }
    public boolean isEmpty(){
        return head == null;
    }
    public void addFirst(E newValue){
        Node<E> newNode = new Node<E>(newValue);
        if(isEmpty())
            head = newNode;
        else{
            newNode.setNextNodeLink(head);
            head = newNode;
        }
        size++;
    }
    public void addLast(E newValue){
        if(isEmpty())
            addFirst(newValue);
        else{
            Node newNode = new Node(newValue);
            addNode(getNodeAtIndex(size), newNode);
        }
    }
    private void addNode(Node<E> currentNode ,Node<E> newNode){
        newNode.setNextNodeLink(currentNode.getNextNodeLink());
        currentNode.setNextNodeLink(newNode);
        size++;
    }
    public E removeFirst(){
        if(isEmpty()){
            System.out.println("Error; list is empty");
            return null;
        }
        Node<E> removedItem = head;
        head = head.getNextNodeLink();
        size--;
        return removedItem.getValue();
    }
    public void insertAtIndex(int index, E value){
        if(index == 1)
            addFirst(value);
        else{
            Node newNode = new Node(value);
            addNode(getNodeAtIndex(index-1), newNode);
        }
    }
    public E getValueAtIndex(int index){
        return getNodeAtIndex(index).getValue();
        //Might throw a null Pointer Exception error
    }
    public Node<E> getNodeAtIndex(int index){
        int count = 1;
        Node<E> currentNode = head;
        while(count < index && currentNode.getNextNodeLink() != null){
            count++;
            currentNode = currentNode.getNextNodeLink();
        }
        if(count != index){
            System.out.println("That index does not exist!");
            return null;
        }
        return currentNode;
    }
    public E removeAtIndex(int index){
        E removedValue;
        if(index == 1){
            removedValue = head.getValue();
            head = null;
        }
        else if (getNodeAtIndex(index).nextNodeLink == null) {
            removedValue = getNodeAtIndex(index).getValue();
            getNodeAtIndex(index-1).setNextNodeLink(null);
        }
        else{
            removedValue = getNodeAtIndex(index).getValue();
            getNodeAtIndex(index-1).setNextNodeLink(getNodeAtIndex(index+1));
        }
        size--;
        return removedValue;
    }
    public void reverseList(){
        if(isEmpty()){

        }
        else if(getSize() == 1){

        }
        else{
            Node<E> anchorNode = head;
            Node<E> currentNode = head.nextNodeLink;
            int iterations = getSize();
            for(int i = 1; i < iterations; i++){
                addFirst(currentNode.getValue());
                currentNode = currentNode.getNextNodeLink();
            }
            anchorNode.setNextNodeLink(null);
        }

    }
    public void betterReverseList(){
        Node previousNode = null;
        Node currentNode = head;
        Node nextNode = head.getNextNodeLink();
        while(currentNode.getNextNodeLink() != null){
            currentNode.setNextNodeLink(previousNode);
            previousNode = currentNode;
            currentNode = nextNode;
            nextNode = nextNode.getNextNodeLink();
        }
        currentNode.setNextNodeLink(previousNode);
        head = currentNode;
    }
    public void recursiveReverseList(){
        recursiveReverseList(null, head, head.getNextNodeLink());
    }
    public void recursiveReverseList(Node<E> prevNode, Node<E> curNode, Node<E> nextNode){
        if(curNode.getNextNodeLink() == null){
            curNode.setNextNodeLink(prevNode);
            head = curNode;
        }
        else{
            curNode.setNextNodeLink(prevNode);
            recursiveReverseList(curNode, nextNode, nextNode.getNextNodeLink());
        }
    }
    public String toString(){
        if(!isEmpty()){
            String text = "";
            Node<E> currentNode = head;
            text += currentNode.toString();
            while(currentNode.getNextNodeLink() != null){
                currentNode = currentNode.getNextNodeLink();
                text += currentNode.toString();
            }
            return text;
        }
        return "Its empty!";
    }
    private class Node<E>{
        private E value;
        private Node<E> nextNodeLink;

        public Node(){
        }
        public Node(E value){
            this.value = value;
        }
        public Node(E value, Node<E> nodeLink){
            this.value = value;
            nextNodeLink = nodeLink; 
        }
        public E getValue(){
            return value;
        }
        public Node<E> getNextNodeLink(){
            return nextNodeLink;
        }
        public void setValue(E newValue){
            this.value = newValue;
        }
        public void setNextNodeLink(Node<E> node){
            this.nextNodeLink= node;
        }
        public boolean hasNext(){
            return nextNodeLink != null;
        }
        public String toString(){
            String text = "Node Value: " + value + "\n";
            return text;
        }

    }

}