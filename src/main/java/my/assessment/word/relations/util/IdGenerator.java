package my.assessment.word.relations.util;

import java.util.Objects;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

@UtilityClass
public class IdGenerator {

  public static String generate(String wordOne, String wordTwo) {
    Objects.requireNonNull(wordOne, "wordOne can not be null");
    Objects.requireNonNull(wordTwo, "wordTwo can not be null");
    String lowerWordOne = trimAndLowercase(wordOne);
    String lowerWordTwo = trimAndLowercase(wordTwo);

    if (StringUtils.compare(lowerWordOne, lowerWordTwo) <= 0) {
      return String.format("%s_%s", lowerWordOne, lowerWordTwo);
    } else {
      return String.format("%s_%s", lowerWordTwo, lowerWordOne);
    }

  }

  public static String trimAndLowercase(String value) {
    return StringUtils.trim(StringUtils.lowerCase(value));
  }
}
