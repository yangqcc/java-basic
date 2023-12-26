package basic.collection.testSet;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * SortSet���Զ�����
 *
 * @author yangqc
 */
public class CharTreeSet {
    public static void main(String[] args) {
        SortedSet<String> sortSet = new TreeSet<>();
        sortSet.add("tt");
        sortSet.add("aa");
        sortSet.add("iii");
        System.out.println(sortSet);
    }
}
