import impl.SinglyLinkedList;

public class Main {
    public static void main (String[] args) {
        SinglyLinkedList<String> firstList = new SinglyLinkedList<>();
        SinglyLinkedList<Integer> secondList = new SinglyLinkedList<>(1);
        SinglyLinkedList<Integer> thirdList = new SinglyLinkedList<>(
                new Integer[]{100, 200, 300, 400});
        SinglyLinkedList<Integer> fourthList = new SinglyLinkedList<>(thirdList);
        thirdList.pushFront(25);
        System.out.println("Size of firstList = " + firstList.getSizeList());
        System.out.println("Size of secondList = " + secondList.getSizeList());
        System.out.println("Size of thirdList = " + thirdList.getSizeList());
        System.out.println("Size of fourthList = " + fourthList.getSizeList());
        System.out.println("thirdList: " + thirdList);
        System.out.println("fourthList: " + fourthList);
    }
}
