package proxy;

import java.util.function.Function;

public class TypeProxy {
     public static Function<?, String> string2 = String :: valueOf;
     public static Function<String, Integer> integer = Integer::valueOf;
     public static Function<String, Double> doubleOf = Double::valueOf;
     public static Function<String, Float> floatOf = Float::valueOf;



}
