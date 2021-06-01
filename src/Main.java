import impl.SinglyLinkedList;

public class Main {
    public static void main (String[] args) {
        SinglyLinkedList<String> firstList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> secondList = new SinglyLinkedList<>(1);
        SinglyLinkedList<Integer> thirdList = new SinglyLinkedList<>(
                new Integer[]{100, 200, 300, 400});
        //SinglyLinkedList<Integer> fourth = new SinglyLinkedList<>(secondList);
        thirdList.pushFront(25);
        System.out.println("Size of firstList = " + firstList.getSizeList());
        System.out.println("Size of secondList = " + secondList.getSizeList());
        System.out.println("Size of thirdList = " + thirdList.getSizeList());
    }
}
