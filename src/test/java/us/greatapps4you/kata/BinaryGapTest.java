package us.greatapps4you.kata;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BinaryGapTest {

    @Test
    void given_TooBigInput_then_ExpectNumberFormatException() {
        //max Input: 2,147,483,647
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            BinaryGap gap = new BinaryGap();
            gap.getLongestBinaryGapLenght(3_000_000_000L);
        });
        Assertions.assertEquals(exception.getMessage(), ErrorMessages.MAX_VALUE_ERROR);
    }

    @Test
    void given_NegativeInteger_then_ExpectNumberFormatException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            BinaryGap gap = new BinaryGap();
            gap.getLongestBinaryGapLenght(-32);
        });
        Assertions.assertEquals(exception.getMessage(), ErrorMessages.NEGATIVE_INPUT_ERROR);
    }

    @Test
    void given_Zero_then_ExpectNumberFormatException() {
        Exception exception = assertThrows(NumberFormatException.class, () -> {
            BinaryGap gap = new BinaryGap();
            gap.getLongestBinaryGapLenght(0);
        });
    }

    @Test
    void given_PositiveInteger_when_ContainsTwoBinaryGaps_then_returnLongestLenght() {
        BinaryGap gap = new BinaryGap();
        int expected = 4; // 529 = 1000010001
        int actual = gap.getLongestBinaryGapLenght(529);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void given_PositiveInteger_when_InputContainsTraillingZeroes_then_returnZero() {
        BinaryGap gap = new BinaryGap();
        int expected = 0; // 32 = 100000
        int actual = gap.getLongestBinaryGapLenght(32);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void given_PositiveInteger_when_InputContainsOnlyOnes_then_returnZero() {
        BinaryGap gap = new BinaryGap();
        int expected = 0; // 15 = 1111
        int actual = gap.getLongestBinaryGapLenght(15);
        Assertions.assertEquals(expected, actual);
    }

}