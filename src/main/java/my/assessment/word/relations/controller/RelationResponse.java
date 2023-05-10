package my.assessment.word.relations.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class RelationResponse {
  private String id;
  private String wordOne;
  private String wordTwo;
  private String relationType;
}
