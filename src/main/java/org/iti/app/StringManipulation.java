package org.iti.app;

public class StringManipulation {

    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public boolean isPalindrome(String input){
        return input.equals(reverseString(input)); //iti, level madam, racecar, ... civic, mom, noon
    }
}
