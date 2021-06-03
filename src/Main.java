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

        System.out.println("pushFront(\"Hello\") to firstList: " + firstList.pushFront("Hello"));

        System.out.println("firstList: " + firstList);
        System.out.println("thirdList: " + thirdList);
        System.out.println("fourthList: " + fourthList);

        System.out.println("popFront(999999) to thirdList = " + thirdList.popFront(999999));

        System.out.println("Size of thirdList = " + thirdList.getSizeList());
        System.out.println("thirdList: " + thirdList);

        System.out.println("popFront(\"default\") to of firstList = " + firstList.popFront("default"));
        System.out.println("popFront(\"default\") to of firstList = " + firstList.popFront("default"));

        System.out.println("Size of firstList = " + firstList.getSizeList());
        System.out.println("firstList: " + firstList);

        System.out.println("pushBack to thirdList: " + thirdList.pushBack(99));
        System.out.println("thirdList: " + thirdList);

        System.out.println("pushBack(\"first\") to firstList: " + firstList.pushBack("first"));
        System.out.println("pushBack(\"second\") to firstList: " + firstList.pushBack("second"));
        System.out.println("pushFront(\"third\") to firstList: " + firstList.pushFront("third"));
        System.out.println("pushBack(null) to firstList: " + firstList.pushFront(null));
        System.out.println("firstList: " + firstList);

        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("thirdList: " + thirdList);
        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to of thirdList = " + thirdList.popBack(999));
        System.out.println("thirdList: " + thirdList);
    }
}
