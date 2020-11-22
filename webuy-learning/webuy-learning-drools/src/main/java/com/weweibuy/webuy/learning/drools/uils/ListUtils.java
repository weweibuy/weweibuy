package com.weweibuy.webuy.learning.drools.uils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/11/13 21:17
 **/
public class ListUtils {


    public static boolean containsAll(Collection collection1, Collection collection2) {
        return collection1.containsAll(collection2);
    }

    public static List<String> stringToList(String str) {
       return Arrays.stream(str.split(","))
                .collect(Collectors.toList());
    }


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);

        List<String> arrayList2 = new ArrayList<>();
        arrayList2.add("A");
        arrayList2.add("B");
        arrayList2.add("C");
        System.err.println(arrayList);
        System.err.println(arrayList2);

    }

}
