package org.example;

public class Generator {
    public  static Client getDefault(){
        return new Client("ivanov", "ivanov@ya.ru", "123456");
    }
    public  static Client getDefault2(){
        return new Client("Петров", "petrov@ya.ru", "Петров");
    }
    public  static Client getEmptyPassword(){
        return new Client("ivanova", "ivanova@ya.ru", "12345");
    }
}
