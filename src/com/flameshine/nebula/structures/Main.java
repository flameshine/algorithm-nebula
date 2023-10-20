package com.flameshine.nebula.structures;

public final class Main {

    private Main() {}

    public static void main(String... args) {
        demonstrate(Main::demonstrateArrayList);
        demonstrate(Main::demonstrateLinkedList);
        demonstrate(Main::demonstrateHashTable);
        demonstrate(Main::demonstrateBinaryTree);
        demonstrate(Main::demonstrateBST);
        demonstrate(Main::demonstrateGraph);
        demonstrate(Main::demonstrateStack);
        demonstrate(Main::demonstrateQueue);
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

        System.out.println(binaryTree.contains(1));
        System.out.println(binaryTree.contains(6));

        System.out.println(binaryTree.size());

        System.out.println(binaryTree);
    }

    private static void demonstrateBST() {

        System.out.println("BST: \n");

        BST bst = new BST();

        bst.insert(1);
        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(5);

        System.out.println(bst);

        bst.delete(3);

        System.out.println(bst.size());

        System.out.println(bst.isEmpty());

        System.out.println(bst);
    }

    private static void demonstrateGraph() {

        System.out.println("Graph: \n");

        Graph<String> graph = new Graph<>();

        System.out.println(graph.isNull());

        graph.addVertex("first");

        System.out.println(graph.isTrivial());

        graph.addVertex("second");
        graph.addVertex("third");
        graph.addVertex("fourth");
        graph.addVertex("fifth");

        graph.removeVertex("third");

        graph.addEdge("first", "second");
        graph.addEdge("second", "fourth");
        graph.addEdge("fourth", "fifth");

        graph.removeEdge("second", "fourth");

        System.out.println(graph);
    }

    private static void demonstrateStack() {

        System.out.println("Stack: \n");

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        System.out.println(stack.search(1));

        System.out.println(stack);
    }

    private static void demonstrateQueue() {

        System.out.println("Queue: \n");

        Queue<Integer> queue = new Queue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        System.out.println(queue.dequeue());

        System.out.println(queue.size());

        System.out.println(queue.peek());

        System.out.println(queue);
    }

    private static void demonstrate(Runnable runnable) {
        runnable.run();
        System.out.println();
    }
}