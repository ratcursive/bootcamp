public class PositionalLinkedListTest {
    public static void main(String[] args) {
        PositionalLinkedList list = new PositionalLinkedList<>();
        Integer a = 1;
        Integer b = 2;
        Double c = 4.5;
        Integer d = 100;
        String word = "Why am I in a list??";
        list.addLast(word);
        list.addFirst(a);
        list.addLast(b);
        list.addFirst(c);
        list.addFirst(d);
        list.addLast(b);
        list.addFirst(d);
        System.out.println(list.last().getElement());
        System.out.println(list);
        list.addAfterIndex(4, word);
        Object oldNum = list.removeAtIndex(1);
        Object oldElem = list.setAtIndex(2, "Oh! I know why!");
        System.out.println(list);
        System.out.println("Reversed list!");
        list.reverseListRecur();
        System.out.println(list);
        System.out.println("Insert!:");
        list.insertAfterNSteps(2, "Inserted!");
        System.out.println(list);
    }
}
