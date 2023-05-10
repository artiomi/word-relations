package my.assessment.word.relations.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
public class RelationCreateRequest {

  @NotEmpty
  private String wordOne;
  @NotEmpty
  private String wordTwo;
  @NotNull
  private Relation relation;

  public enum Relation {
    SYNONYM, ANTONYM, RELATED

  }

}
