package com.liang.erhua.jdk8.stream;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector.Characteristics;

/**
 * @author liangjia
 * @version 1.0
 * @date 21:09/2019-12-08
 * @description T是流中要收集的项目的泛型
 *              A是累加器的类型，累加器是在收集过程中用于累积部分结果的对象。
 *              R是收集操作得到的对象（通常但并不一定是集合）的类型。
 */
public interface Collector<T, A, R> {
    /**
     * 建立新的结果容器： supplier方法
     * @return
     */
    Supplier<A> supplier();

    /**
     * 将元素添加到结果容器： accumulator方法
     * @return
     */
    BiConsumer<A, T> accumulator();

    /**
     * 对结果容器应用最终转换： finisher方法
     * @return
     */
    Function<A, R> finisher();

    /**
     *合并两个结果容器： combiner方法
     * @return
     */
    BinaryOperator<A> combiner();

    /**
     *characteristics会返回一个不可变的Characteristics集合，它定义
     * 了收集器的行为——尤其是关于流是否可以并行归约，以及可以使用哪些优化的提示。
     * @return
     */
    Set<Characteristics> characteristics();
}
