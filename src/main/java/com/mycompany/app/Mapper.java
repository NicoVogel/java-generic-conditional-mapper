package com.mycompany.app;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Mapper<FROM, TO> {
    FROM from;
    TO to;

    public <VALUE_TYPE> void mapNotNull(Function<? super FROM, ? extends VALUE_TYPE> getter,
            BiConsumer<? super TO, VALUE_TYPE> setter) {
        mapCondition(getter, setter, Objects::nonNull);
    }

    public <VALUE_TYPE> void mapCondition(Function<? super FROM, ? extends VALUE_TYPE> getter,
            BiConsumer<? super TO, VALUE_TYPE> setter, Function<VALUE_TYPE, Boolean> condition) {
        VALUE_TYPE value = getter.apply(from);
        if (condition.apply(value)) {
            setter.accept(to, value);
        }
    }
}
