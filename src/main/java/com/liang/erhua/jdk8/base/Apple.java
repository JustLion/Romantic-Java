package com.liang.erhua.jdk8.base;

import java.util.Objects;

/**
 * @author liangjia
 * @version 1.0
 * @date 22:26/2019-11-27
 * @description
 */
public class Apple {
    private Integer weight;

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public Apple(String color) {
        this.color = color;
    }

    private String color;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apple apple = (Apple) o;
        return Objects.equals(weight, apple.weight) &&
                Objects.equals(color, apple.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(weight, color);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Apple() {
    }

    public Apple(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }
}
