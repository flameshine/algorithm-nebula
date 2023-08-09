package com.flameshine.nebula.structures;

public final class Main {

    private Main() {}

    public static void main(String... args) {
        demonstrateArrayList();
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
}