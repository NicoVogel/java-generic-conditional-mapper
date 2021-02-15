package com.mycompany.app;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mapper<FROM, TO> {
    private FROM from;
    private TO to;

    public TO get() {
        return this.to;
    }

    public <VALUE_TYPE> Mapper<FROM, TO> mapCondition(Function<? super FROM, ? extends VALUE_TYPE> getter,
            BiConsumer<? super TO, VALUE_TYPE> setter, Predicate<VALUE_TYPE> predicate) {
        VALUE_TYPE value = getter.apply(from);
        if (predicate.test(value)) {
            setter.accept(to, value);
        }
        return this;
    }

    public <VALUE_TYPE> Mapper<FROM, TO> mapNotNull(Function<? super FROM, ? extends VALUE_TYPE> getter,
            BiConsumer<? super TO, VALUE_TYPE> setter) {
        return mapCondition(getter, setter, Objects::nonNull);
    }

    public <VALUE_TYPE extends List<?>> Mapper<FROM, TO> mapNotEmpty(
            Function<? super FROM, ? extends VALUE_TYPE> getter, BiConsumer<? super TO, VALUE_TYPE> setter) {
        return mapCondition(getter, setter, andPredicates(Objects::nonNull, List::isEmpty));
    }

    @SafeVarargs
    public static <R> Predicate<R> andPredicates(Predicate<R>... predicates) {
        return Arrays.stream(predicates).reduce(Predicate::and).orElse(x -> true);
    }
}
