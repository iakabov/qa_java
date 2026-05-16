package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Test
    public void testEatMeat() throws Exception {
        // Проверка, что внутри метода вызывается getFood("Хищник")
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getFamily();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getFamily();
    }

    @Test
    public void testGetKittens() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens();
    }

    @Test
    public void testGetKittensWithCount() {
        int count = 3;
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens(count);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens(count);
    }


    @Test
    public void testGetKittensWithZeroCount() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens(0);
    }

    @Test
    public void testGetKittensWithNegativeCount() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens(-1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens(-1);
    }

    @Test
    public void testMultipleEatMeatCalls() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        spyFeline.eatMeat();
        Mockito.verify(spyFeline, Mockito.times(2)).getFood("Хищник");
    }

    @Test
    public void testMultipleGetFamilyCalls() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getFamily();
            spyFeline.getFamily();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline, Mockito.times(2)).getFamily();
    }

    @Test
    public void testMultipleGetKittensCalls() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens();
            spyFeline.getKittens();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline, Mockito.times(2)).getKittens();
    }

    @Test
    public void testMultipleGetKittensWithCountCalls() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens(2);
            spyFeline.getKittens(3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens(2);
        Mockito.verify(spyFeline).getKittens(3);
    }

    @Test
    public void testNoUnexpectedMethodCallsInConstructor() {
        Feline spyFeline = Mockito.spy(new Feline());
        Mockito.verify(spyFeline, Mockito.never()).getFamily();
        Mockito.verify(spyFeline, Mockito.never()).getKittens();
        Mockito.verify(spyFeline, Mockito.never()).getKittens(Mockito.anyInt());
    }

    @Test
    public void testEatMeatDoesNotCallOtherMethods() throws Exception {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.eatMeat();
        Mockito.verify(spyFeline).getFood("Хищник");
        Mockito.verify(spyFeline, Mockito.never()).getFamily();
        Mockito.verify(spyFeline, Mockito.never()).getKittens();
    }

    @Test
    public void testGetFamilyDoesNotCallOtherMethods() {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.getFamily();
        Mockito.verify(spyFeline).getFamily();
        Mockito.verify(spyFeline, Mockito.never()).getKittens();
        try {
            Mockito.verify(spyFeline, Mockito.never()).getFood(Mockito.anyString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetKittensDoesNotCallOtherMethods() {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.getKittens();
        Mockito.verify(spyFeline).getKittens();
        Mockito.verify(spyFeline, Mockito.never()).getFamily();
        try {
            Mockito.verify(spyFeline, Mockito.never()).getFood(Mockito.anyString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetKittensWithCountDoesNotCallOtherMethods() {
        Feline spyFeline = Mockito.spy(new Feline());
        try {
            spyFeline.getKittens(5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline).getKittens(5);
        Mockito.verify(spyFeline, Mockito.never()).getFamily();
        try {
            Mockito.verify(spyFeline, Mockito.never()).getFood(Mockito.anyString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.verify(spyFeline, Mockito.never()).getKittens();
    }

    @Test
    public void testGetKittensDoesNotCallEatMeat() {
        Feline spyFeline = Mockito.spy(new Feline());
        spyFeline.getKittens();
        try {
            Mockito.verify(spyFeline, Mockito.never()).getFood(Mockito.anyString());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}