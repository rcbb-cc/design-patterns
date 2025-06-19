package cc.rcbb.design.partterns.decorator.example3;

import java.util.Set;

/**
 * <p>
 * Main
 * </p>
 *
 * @author rcbb.cc
 * @date 2025/6/18
 */
public class Main {

    public static void main(String[] args) {
        Set<String> set = new HistorySet<>();
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        System.out.println(set);
        set.remove("2");
        System.out.println(set);
        set.remove("3");
        System.out.println(set);
    }

}
