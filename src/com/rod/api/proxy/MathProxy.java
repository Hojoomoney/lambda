package com.rod.api.proxy;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MathProxy {
    public static Function<Integer, Integer> absInt = Math::abs;
    public static Function<Double, Double> absDouble = Math::abs;
    public static BiFunction<Integer, Integer, Integer> maxInt = Math::max;
    public static BiFunction<Integer, Integer, Integer> minInt = Math::min;
    public static BiFunction<Integer, Integer, Integer>  randomInt = (a, b) -> (int) (Math.random() * (b-a) + a);
    public static Supplier<Double> randomDouble = Math::random;
    public static BiFunction<Integer, Integer, Integer> powInt = (a, b) -> (int) Math.pow(a,b);
    public static BiFunction<Double, Double, Double> powDouble = Math::pow;
    public static Function<Double, Long> roundInt = Math::round;
    public static Function<Double, Double> sqrtDouble = Math::sqrt;
    public static Function<Double, Double> ceilDouble = Math::ceil;
    public static Function<Double, Double> floorDouble = Math::floor;


}
