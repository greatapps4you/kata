package us.greatapps4you.kata;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BinaryGap {

    private static final Logger logger = LogManager.getLogger(BinaryGap.class.getName());

    // https://www.regular-expressions.info/lookaround.html
    private final Pattern BINARY_GAP_PATTERN = Pattern.compile("(?<=1)(0*?)(?=1)");

    public int getLongestBinaryGapLenght(long input) {
        validateInput(input);
        String binary = Long.toBinaryString(input);
        logger.debug("Binary: {}", binary);

        List<String> found = findBinaryGaps(binary);
        logger.debug("Found: {} binary gaps", found.size());

        logger.debug("Binary Gaps found:");
        for(String bg: found) {
            logger.debug("Binary Gap: {}", bg);
        }
        int longest = findLongestBinaryGapLenght(found);
        logger.debug("Longest Binary Gap Length: {}", longest);
        return longest;
    }

    private void validateInput(long input) {
        if(input > Integer.MAX_VALUE) {
            throw new NumberFormatException(ErrorMessages.MAX_VALUE_ERROR);
        }

        if(input <= 0) {
            throw new NumberFormatException(ErrorMessages.NEGATIVE_INPUT_ERROR);
        }
    }

    private int findLongestBinaryGapLenght(List<String> found) {
        int longest = 0;
        for(String bg: found) {
            if(bg.length() > longest)
                longest = bg.length();
        }
        return longest;
    }

    private List<String> findBinaryGaps(String binary) {
        Matcher binaryGapMatcher = BINARY_GAP_PATTERN.matcher(binary);
        List<String> found = new ArrayList<>();
        while (binaryGapMatcher.find()) {
            found.add(binaryGapMatcher.group());
        }
        return found;
    }
}
