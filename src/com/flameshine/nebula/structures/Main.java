package com.flameshine.nebula.structures;

public final class Main {

    private Main() {}

    public static void main(String... args) {
        demonstrateArrayList();
        demonstrateLinkedList();
    }

    private static void demonstrateArrayList() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);

        arrayList.remove(3);

        System.out.println(arrayList.get(0));

        System.out.println(arrayList.indexOf(1));

        System.out.println(arrayList);
    }

    private static void demonstrateLinkedList() {

        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.remove(3);

        System.out.println(linkedList.get(0));

        System.out.println(linkedList.indexOf(1));

        System.out.println(linkedList);
    }
}