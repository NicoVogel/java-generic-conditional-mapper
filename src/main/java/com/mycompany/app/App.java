/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/

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
