package com.exemple.utils;

import java.util.Random;

public class ISBNGenerator implements Generator{
    @Override
    public String generateISBN() {
        return "13-7832"+Math.abs(new Random().nextInt());
    }
}
