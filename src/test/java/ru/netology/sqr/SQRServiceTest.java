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
            "bottom<min and top>max, 199, 301, 3",
            "0 Square, 260, 280, 0",
            "Square=min, 225, 300, 3",
            "Square=max, 200, 289, 3"}
    )

    void count(String testName, int min, int max, int expected) {

        SQRService service = new SQRService ();
        int actual = service.countSquare(min, max);

        assertEquals(expected, actual);
    }
}