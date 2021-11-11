package ru.netology.sqr;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SQRServiceTest {

    @ParameterizedTest
    @CsvSource (value = {"bottom=min and top=max, 200, 300, 3",
            "bottom<min and top=max, 199, 300, 3",
            "bottom>min and top=max, 201, 300, 3",
            "bottom=min and top>max, 200, 301, 3",
            "bottom=min and top<max, 200, 299, 3",
            "bottom>min and top<max, 201, 299, 3",
            "bottom<min and top>max, 199, 301, 3"}
    )

    void counter(String testName, int min, int max, int expected) {

        SQRService service = new SQRService ();
        int actual = service.counter(min, max);

        assertEquals(expected, actual);
    }
}