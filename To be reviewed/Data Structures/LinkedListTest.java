
public class LinkedListTest{
    public static void reverseList(LinkedList list){
        for(int i = 1; i <= list.getSize(); i++)
            list.insertAtIndex(i, list.removeAtIndex(list.getSize()));
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList<Integer>();
        System.out.println(list);
        System.out.println(list.getSize());
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 4;
        Integer e = 10;
        list.addFirst(d);
        list.addFirst(c);
        list.addFirst(b);
        list.addFirst(a);
        System.out.println("Head: " + list.getFirst());
        System.out.println(list.getSize());
        System.out.println(list);
        list.recursiveReverseList();
        System.out.println(list);
        System.out.println(list.getSize());

    }
}