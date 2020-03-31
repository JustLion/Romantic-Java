package com.liang.erhua.jdk8.base;

import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.*;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:37/2019-11-25
 * @description
 */
public class BaseCondition {
    public static void main(String[] args) throws Exception {

        for (String arg : args) {
            System.out.println(arg);
        }
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        //
        //int read = System.in.read();


    }

    /**
     * Lambda表达式以及方法引用
     */
    public static void lambda() {
        Callable<Integer> callable = () -> 42;


        PrivilegedAction<Integer> p = () -> 32;

        //存在类型推断的
        Comparator<Apple> comparable = (a1, a2) -> a1.getWeight().compareTo(a2.getWeight());
        //lambda表达式引用的局部变量必须是最终（final）的，不是final的一旦被再次赋值就无法通过编译
        final int num = 1393;
        Runnable runnable = () -> System.out.println(num);


        Comparator<Apple> comparator2 = Comparator.comparing(Apple::getWeight);


        List<String> str = Arrays.asList("a", "b", "A", "B");
        str.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        str.sort(String::compareToIgnoreCase);

        Function<String, Integer> strToInt = Integer::parseInt;
        BiPredicate<List<String>, String> contains = List::contains;


        Supplier<Apple> supplier = Apple::new;
        //get方法创建一个新的Apple对象
        supplier.get();

        //采用一个参数构造方法
        Function<Integer, Apple> function = (weight) -> new Apple(weight);
        Function<Integer, Apple> appleFunction = Apple::new;
        Apple apple = function.apply(120);

        //调用下面map函数
        map(Arrays.asList(7, 3, 4, 10), Apple::new);


        //采用两个构造函数方法
        BiFunction<Integer, String, Apple> biFunction = (weight, color) -> new Apple(weight, color);
        BiFunction<Integer, String, Apple> appleBiFunction = Apple::new;
        biFunction.apply(120, "green");
    }


    /**
     * lambda表达式之构造函数引用
     *
     * @param list
     * @param f
     * @return
     */
    public static List<Apple> map(List<Integer> list,
                                  Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for (Integer e : list) {
            result.add(f.apply(e));
        }
        return result;
    }

    /**
     * 四种方式解决问题
     * 1：传递代码
     * 2：使用匿名类
     * 3：使用Lambda表达式
     * 4：使用方法引用
     */
    public static void finalScheme() {

    }

    /**
     * 复合Lambda表达式的有用方法
     */
    public static void multiple() {

        //-----比较器复合
        List<Apple> inventory = new ArrayList<>();
        Comparator<Apple> comparing = Comparator.comparing(Apple::getWeight);
        //按重量递减排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        //先根据重量递减排序，然后根据颜色排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));


        // -----谓词复合
        Predicate<Apple> predicate = "red"::equals;
        //取非
        Predicate<Apple> negate = predicate.negate();
        // 并且
        predicate.and(apple -> apple.getWeight() > 150);
        // 或者
        predicate.or("green"::equals);
        //-----函数复合
        Function<Integer, Integer> function1 = x -> x + 1;
        Function<Integer, Integer> function2 = x -> x * 2;
        //结果是 4 从前向后执行
        Function<Integer, Integer> function3 = function1.andThen(function2);
        // 结果是 3 从后向前执行
        Function<Integer, Integer> function4 = function1.compose(function2);
        function3.apply(1);

        // for example
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> stringStringFunction = addHeader.andThen(Letter::checkSpelling).andThen(Letter::addFooter);
    }
}
