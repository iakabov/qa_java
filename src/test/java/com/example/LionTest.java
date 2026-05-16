package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyString;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String UNSUPPORTED_SEX = "unsupported sex";

    @Mock
    private Feline feline;

    @Test
    public void testGetKittensCallsFelineMethod() throws Exception {
        when(feline.getKittens()).thenReturn(7);
        Lion lion = new Lion(MALE, feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveManeForMaleCallsNoExternalMethods() throws Exception {
        Lion lion = new Lion(MALE, feline);
        lion.doesHaveMane();
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testDoesHaveManeForFemaleCallsNoExternalMethods() throws Exception {
        Lion lion = new Lion(FEMALE, feline);
        lion.doesHaveMane();
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testGetFoodCallsFelineMethod() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(MALE, feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test(expected = Exception.class)
    public void testInvalidSexThrowsException() throws Exception {
        new Lion(UNSUPPORTED_SEX, feline);
    }

    @Test
    public void testInvalidSexDoesNotCallFelineMethods() throws Exception {
        try {
            new Lion(UNSUPPORTED_SEX, feline);
        } catch (Exception e) {
            verify(feline, never()).getKittens();
            verify(feline, never()).getFood(anyString());
        }
    }


    @Test
    public void testMaleConstructorDoesNotThrowException() throws Exception {
        new Lion(MALE, feline);
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testFemaleConstructorDoesNotThrowException() throws Exception {
        new Lion(FEMALE, feline);
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testGetKittensReturnsFromFeline() throws Exception {
        when(feline.getKittens()).thenReturn(5);
        Lion lion = new Lion(MALE, feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void testGetFoodReturnsFromFeline() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));
        Lion lion = new Lion(FEMALE, feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testDoesHaveManeForMaleReturnsBoolean() throws Exception {
        Lion lion = new Lion(MALE, feline);
        lion.doesHaveMane();
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testDoesHaveManeForFemaleReturnsBoolean() throws Exception {
        Lion lion = new Lion(FEMALE, feline);
        lion.doesHaveMane();
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

    @Test
    public void testGetFoodForMaleLion() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(MALE, feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetFoodForFemaleLion() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(FEMALE, feline);
        lion.getFood();
        verify(feline).getFood("Хищник");
    }

    @Test
    public void testGetKittensForMaleLion() throws Exception {
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion(MALE, feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void testGetKittensForFemaleLion() throws Exception {
        when(feline.getKittens()).thenReturn(4);
        Lion lion = new Lion(FEMALE, feline);
        lion.getKittens();
        verify(feline).getKittens();
    }

    @Test
    public void testMultipleGetKittensCalls() throws Exception {
        when(feline.getKittens()).thenReturn(2).thenReturn(3);
        Lion lion = new Lion(MALE, feline);
        lion.getKittens();
        lion.getKittens();
        verify(feline, org.mockito.Mockito.times(2)).getKittens();
    }

    @Test
    public void testMultipleGetFoodCalls() throws Exception {
        when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(FEMALE, feline);
        lion.getFood();
        lion.getFood();
        verify(feline, org.mockito.Mockito.times(2)).getFood("Хищник");
    }

    @Test
    public void testConstructorWithValidSexInitializesFeline() throws Exception {
        new Lion(MALE, feline);
        verify(feline, never()).getKittens();
        verify(feline, never()).getFood(anyString());
    }

}