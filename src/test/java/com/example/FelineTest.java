package com.example;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline = new Feline();

    @Test
    public void testEatMeat() throws Exception {
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        feline.getFamily();
        Mockito.verify(feline).getFamily();
    }

    @Test
    public void testGetKittens() {
        feline.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testGetKittensWithCount() {
        int count = 3;
        feline.getKittens(count);
        Mockito.verify(feline).getKittens(count);
    }
}