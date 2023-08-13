package com.flameshine.nebula.structures;

public final class Main {

    private Main() {}

    public static void main(String... args) {

        demonstrateArrayList();

        System.out.println();

        demonstrateLinkedList();

        System.out.println();

        demonstrateHashTable();

        System.out.println();

        demonstrateBinaryTree();
    }

    private static void demonstrateArrayList() {

        System.out.println("ArrayList: \n");

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

        System.out.println("LinkedList: \n");

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

    private static void demonstrateHashTable() {

        System.out.println("HashTable: \n");

        HashTable<Integer, String> hashTable = new HashTable<>();

        hashTable.put(1, "one");
        hashTable.put(2, "two");
        hashTable.put(3, "three");
        hashTable.put(4, "four");
        hashTable.put(5, "five");

        hashTable.remove(3);

        System.out.println(hashTable.get(5));

        hashTable.entrySet().forEach(System.out::println);

        System.out.println(hashTable.containsKey(1));
        System.out.println(hashTable.containsKey(6));

        System.out.println(hashTable.containsValue("one"));
        System.out.println(hashTable.containsValue("six"));

        System.out.println(hashTable);
    }

    private static void demonstrateBinaryTree() {

        System.out.println("BinaryTree: \n");

        BinaryTree<Integer> binaryTree = new BinaryTree<>();

        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);

        System.out.println(binaryTree);
    }
}