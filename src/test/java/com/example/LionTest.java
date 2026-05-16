package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    private static final String MALE = "Самец";
    private static final String FEMALE = "Самка";
    private static final String UNSUPPORTED_SEX = "unsupported sex";
    private static final String TEXT_EXCEPTION = "Используйте допустимые значения пола животного - самей или самка";

    @Mock
    private Feline feline;

    @Test
    public void testGetKittens() throws Exception {
        // Используем Mockito.when для возврата значения
        Mockito.when(feline.getKittens()).thenReturn(7);
        Lion lion = new Lion(MALE, feline);
        int kittensCount = lion.getKittens();
        assertThat(kittensCount).isEqualTo(7);
        Mockito.verify(feline).getKittens();
    }

    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lionMale = new Lion(MALE, feline);
        assertThat(lionMale.doesHaveMane()).isTrue();

        Lion lionFemale = new Lion(FEMALE, feline);
        assertThat(lionFemale.doesHaveMane()).isFalse();
    }

    @Test
    public void testGetFood() throws Exception {
        // Можно задать поведение getFood
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо"));
        Lion lion = new Lion(MALE, feline);
        List<String> food = lion.getFood();
        assertThat(food).contains("Мясо");
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void testInvalidSexThrowsException() {
        Throwable throwable = catchThrowable(() -> {
            new Lion(UNSUPPORTED_SEX, feline);
        });
        assertThat(throwable)
                .isInstanceOf(Exception.class)
                .hasMessage(TEXT_EXCEPTION);
    }
}