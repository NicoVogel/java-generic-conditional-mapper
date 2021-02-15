package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        var a = new SomeClass();
        var b = new AnotherClass();

        var mapper = new Mapper<>(a, b);
        mapper.mapNotNull(SomeClass::getNumber, AnotherClass::setInteger);
        mapper.mapNotNull(SomeClass::getNumbers, AnotherClass::setList);

        System.out.println(b.value);
        System.out.println(b.test);
    }
}
