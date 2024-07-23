package com.arpit.spring_boot_yash_batch.learning;

public class Functions {

    String hello() {
        return "hello";
    }

    String hi() {
        return hello();
    }

    public static void main(String[] args) {  // 6
        
        System.out.println(new Functions().hi());
        
        // int a = 1234;

        // while (a != 0) {
        //     int last = a % 10;
        //     System.out.println(last);
        //     a = a / 10;
        // }
    }
}


