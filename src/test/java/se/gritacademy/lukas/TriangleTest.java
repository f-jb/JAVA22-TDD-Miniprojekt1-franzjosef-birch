package se.gritacademy.lukas;

import java.io.ByteArrayInputStream;
import java.lang.NumberFormatException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class TriangleTest {

    void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }
    @Test
    void intConstructedTriangle_InputTheSameNumbers_ReturnsAnEquilateralTriangle() {
        int lengthOfSides = 5;
        Triangle triangleIntConstructor = new Triangle(lengthOfSides, lengthOfSides, lengthOfSides);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangleIntConstructor.getCurrent_type());
    }

    @Test
    void stringArrayConstructedTriangle_InputTheSameNumbers_ReturnsAnEquilateralTriangle() {
        String[] lengthOfSides = new String[]{"5", "5", "5"};
        Triangle triangleStringArrayConstructor = new Triangle(lengthOfSides);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangleStringArrayConstructor.getCurrent_type());
    }


    @Test
    void emptyConstructedTriangle_InputTheSameNumbers_ReturnsAnEquilateralTriangle() {
        int lengthOfSides = 5;
        Triangle triangleEmptyConstructor = new Triangle();
        triangleEmptyConstructor.setCurrent_type(lengthOfSides, lengthOfSides, lengthOfSides);
        assertEquals(Triangle.TYPE.EQUILATERAL, triangleEmptyConstructor.getCurrent_type());
    }


    @Test
    void intConstructedTriangle_InputTwoSameNumbers_ReturnsAnIsoscelesTriangle() {
        int lengthOfSides = 5;
        int lengthOfRemainingSide = 2;
        Triangle triangleIntConstructor = new Triangle(lengthOfSides, lengthOfSides, lengthOfRemainingSide);
        assertEquals(Triangle.TYPE.ISOSCELES, triangleIntConstructor.getCurrent_type());
    }

    @Test
    void stringArrayConstructedTriangle_InputTwoSameNumbers_ReturnsAnIsoscelesTriangle() {
        String[] lengthOfSides = new String[]{"5", "5", "2"};
        Triangle triangleStringArrayConstructor = new Triangle(lengthOfSides);
        assertEquals(Triangle.TYPE.ISOSCELES, triangleStringArrayConstructor.getCurrent_type());
    }

    @Test
    void emptyConstructedTriangle_InputTwoSameNumbers_ReturnsAnIsoscelesTriangle() {
        int lengthOfSides = 5;
        int lengthOfRemainingSide = 2;
        Triangle triangleEmptyConstructor = new Triangle();
        triangleEmptyConstructor.setCurrent_type(lengthOfSides, lengthOfSides, lengthOfRemainingSide);
        assertEquals(Triangle.TYPE.ISOSCELES, triangleEmptyConstructor.getCurrent_type());
    }

    @Test
    void intConstructedTriangle_InputThreeDifferentNumbers_ReturnsAnScaleneTriangle() {
        int lengthOfFirstSide = 5;
        int lengthOfSecondSide = 2;
        int lengthOfThirdSide = 4;
        Triangle triangleIntConstructor = new Triangle(lengthOfFirstSide, lengthOfSecondSide, lengthOfThirdSide);
        assertEquals(Triangle.TYPE.SCALENE, triangleIntConstructor.getCurrent_type());
    }

    @Test
    void stringArrayConstructedTriangle_InputThreeDifferentNumbers_ReturnsAnScaleneTriangle() {
        String[] lengthOfSides = new String[]{"5", "2", "4"};
        Triangle triangleStringArrayConstructor = new Triangle(lengthOfSides);
        assertEquals(Triangle.TYPE.SCALENE, triangleStringArrayConstructor.getCurrent_type());
    }

    @Test
    void emptyConstructedTriangle_InputThreeDifferentNumbers_ReturnsAnScaleneTriangle() {
        int lengthOfFirstSide = 5;
        int lengthOfSecondSide = 2;
        int lengthOfThirdSide = 4;
        Triangle triangleEmptyConstructor = new Triangle();
        triangleEmptyConstructor.setCurrent_type(lengthOfFirstSide, lengthOfSecondSide, lengthOfThirdSide);
        assertEquals(Triangle.TYPE.SCALENE, triangleEmptyConstructor.getCurrent_type());
    }

    @Test
    void intConstructedTriangle_InputAZero_ReturnsNull() {
        int lengthOfFirstSide = 0;
        int lengthOfOtherSides = 1;
        Triangle triangleIntConstructor = new Triangle(lengthOfFirstSide, lengthOfOtherSides, lengthOfOtherSides);
        assertNull(triangleIntConstructor.getCurrent_type());
    }

    @Test
    void stringArrayConstructedTriangle_InputAZero_ReturnsNull() {
        String[] lengthOfSides = new String[]{"5", "0", "4"};
        Triangle triangleStringArrayConstructor = new Triangle(lengthOfSides);
        assertNull(triangleStringArrayConstructor.getCurrent_type());
    }

    @Test
    void emptyConstructedTriangle_InputAZero_ReturnsNull() {
        int lengthOfFirstSide = 5;
        int lengthOfSecondSide = 2;
        int lengthOfThirdSide = 0;
        Triangle triangleEmptyConstructor = new Triangle();
        triangleEmptyConstructor.setCurrent_type(lengthOfFirstSide, lengthOfSecondSide, lengthOfThirdSide);
        assertNull(triangleEmptyConstructor.getCurrent_type());
    }

    @Test
    void stringArrayConstructedTriangle_InputNotANumber_ThrowsANumberFormatException() {
        String[] lengthOfSides = new String[]{"a", "b", "saldfisadf"};

        assertThrows(NumberFormatException.class, () -> {
                    Triangle triangle = new Triangle(lengthOfSides);
                }
        );
    }

    @Test
    void stringArrayConstructedTriangle_InputMoreArgumentsThanRequested_returnsNull() {
        String[] lengthOfSides = new String[]{"1", "2", "3", "4"};

        Triangle triangle = new Triangle(lengthOfSides);
        assertNull(triangle.getCurrent_type());
    }
    @Test
    void getUserInput_InputNumbers_NotNullResult() {
        Triangle triangle = new Triangle();
        provideInput("2,2,2");
        triangle.getUserInput();
        assertNotNull(triangle.getCurrent_type());
    }

    @Test
    void getUserInput_InputNotNumbers_ThrowsANumberFormatException() {
        Triangle triangle = new Triangle();
        provideInput("a,b,c");
        assertThrows(NumberFormatException.class, triangle::getUserInput);
    }
    @Test
    void getUserInput_TooManyArguments_ThrowsANumberFormatException() {
        Triangle triangle = new Triangle();
        provideInput("1,2,3,4");
        triangle.getUserInput();
        assertNull(triangle.getCurrent_type());
    }

}


