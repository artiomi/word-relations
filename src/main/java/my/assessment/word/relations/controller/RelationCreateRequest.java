package my.assessment.word.relations.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RelationCreateRequest {

  @NotEmpty(message = "not allowed to be null or empty")
  private String wordOne;
  @NotEmpty(message = "not allowed to be null or empty")
  private String wordTwo;
  @NotNull(message = "not allowed to be null")
  private Relation relation;

  public enum Relation {
    SYNONYM, ANTONYM, RELATED

  }

}
