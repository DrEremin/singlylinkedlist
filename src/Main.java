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

        System.out.println("\npushFront(\"Hello\") to firstList: " + firstList.pushFront("Hello"));

        System.out.println("\nfirstList: " + firstList);
        System.out.println("thirdList: " + thirdList);
        System.out.println("fourthList: " + fourthList);

        System.out.println("\npopFront(999999) to thirdList = " + thirdList.popFront(999999));

        System.out.println("\nSize of thirdList = " + thirdList.getSizeList());
        System.out.println("thirdList: " + thirdList);

        System.out.println("\npopFront(\"default\") to of firstList = " + firstList.popFront("default"));
        System.out.println("popFront(\"default\") to of firstList = " + firstList.popFront("default"));

        System.out.println("\nSize of firstList = " + firstList.getSizeList());
        System.out.println("firstList: " + firstList);

        System.out.println("\npushBack to thirdList: " + thirdList.pushBack(99));
        System.out.println("thirdList: " + thirdList);

        System.out.println("\npushBack(\"first\") to firstList: " + firstList.pushBack("first"));
        System.out.println("pushBack(\"second\") to firstList: " + firstList.pushBack("second"));
        System.out.println("pushFront(\"third\") to firstList: " + firstList.pushFront("third"));
        System.out.println("pushBack(null) to firstList: " + firstList.pushFront(null));
        System.out.println("firstList: " + firstList);

        System.out.println("\npopBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("thirdList: " + thirdList);
        System.out.println("popBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("popBack(999) to thirdList = " + thirdList.popBack(999));
        System.out.println("thirdList: " + thirdList);

        System.out.println("\nfirstList: " + firstList);
        System.out.println("pushAfter(1, \"one\") to firstList = " + firstList.pushAfter(1, "one"));
        System.out.println("firstList: " + firstList);
        System.out.println("pushAfter(0, \"zero\") to firstList = " + firstList.pushAfter(0, "zero"));
        System.out.println("firstList: " + firstList);
        System.out.println("pushAfter(4, \"last\") to firstList = " + firstList.pushAfter(4, "last"));
        System.out.println("pushAfter(4, null) to firstList = " + firstList.pushAfter(4, null));
        System.out.println("pushAfter(-1, \"error\") to firstList = " + firstList.pushAfter(-1, "error"));
        System.out.println("pushAfter(6, \"error\") to firstList = " + firstList.pushAfter(6, "error"));
        System.out.println("firstList: " + firstList);

        System.out.println("\nsecondList: " + secondList);
        System.out.println("popAfter(0, 999) to secondList = " + secondList.popAfter(0, 999));
        System.out.println("secondList: " + secondList);

        System.out.println("\npopAfter(5, \"default\") to firstList = " + firstList.popAfter(5, "default"));
        System.out.println("popAfter(6, \"default\") to firstList = " + firstList.popAfter(6, "default"));
        System.out.println("popAfter(-1, \"default\") to firstList = " + firstList.popAfter(-1, "default"));
        System.out.println("firstList: " + firstList);
        System.out.println("popAfter(4, \"default\") to firstList = " + firstList.popAfter(4, "default"));
        System.out.println("firstList: " + firstList);
        System.out.println("popAfter(0, \"default\") to firstList = " + firstList.popAfter(0, "default"));
        System.out.println("firstList: " + firstList);
    }
}
