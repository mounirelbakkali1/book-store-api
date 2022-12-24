package com.exemple.utils;

import com.exemple.utils.beans.EIGHTGENERATOR;

import java.util.Random;

@EIGHTGENERATOR
public class ISBNGeneratorV2 implements Generator {
    @Override
    public String generateISBN() {
        return "8-7832"+Math.abs(new Random().nextInt())+"-2022";
    }
}
