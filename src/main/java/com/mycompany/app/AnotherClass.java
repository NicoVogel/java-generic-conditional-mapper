package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;

public class AnotherClass {
    int value;
    List<Integer> test = new ArrayList<>();

    public void setInteger(int value) {
        this.value = value;
    }

    public void setList(List<Integer> numbers) {
        test = numbers;
    }
}
