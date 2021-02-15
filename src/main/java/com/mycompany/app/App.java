package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        var a = new SomeClass();
        var b = new Mapper<>(a, new AnotherClass()).mapNotNull(SomeClass::getNumber, AnotherClass::setInteger)
                .mapNotNull(SomeClass::getNumbers, AnotherClass::setList)
                .mapNotEmpty(SomeClass::getNumbers, AnotherClass::setList).get();

        System.out.println(b.value);
        System.out.println(b.test);
    }
}
