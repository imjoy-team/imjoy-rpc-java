package net.imjoy.rpc;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface Handler<T> extends Function<Object, T> {
	// a function with two inputs - a list and a map, and one output of type T
}