package com.liang.erhua.jdk8.collectionutil;

import java.util.Comparator;

/**
 * @author liangjia
 * @version 1.0
 * @date 10:42/2020-02-19
 * @description
 */
public class TreeComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int i, j, k;
        i = o1.indexOf(' ');
        j = o2.indexOf(' ');
        k = o1.substring(i).compareToIgnoreCase(o2.substring(j));
        if (k == 0) {
            return o1.compareToIgnoreCase(o2);
        } else {
            return k;
        }
    }
}
