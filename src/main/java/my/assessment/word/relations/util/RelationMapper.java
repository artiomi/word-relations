package my.assessment.word.relations.util;

import lombok.experimental.UtilityClass;
import my.assessment.word.relations.controller.RelationCreateRequest;
import my.assessment.word.relations.controller.RelationResponse;
import my.assessment.word.relations.domain.RelationTypes;
import my.assessment.word.relations.domain.WordRelation;

@UtilityClass
public class RelationMapper {

  public WordRelation createRequest2WordRelation(RelationCreateRequest request) {
    return WordRelation.builder()
        .id(IdGenerator.generate(request.getWordOne(), request.getWordTwo()))
        .wordOne(IdGenerator.trimAndLowercase(request.getWordOne()))
        .wordTwo(IdGenerator.trimAndLowercase(request.getWordTwo()))
        .relationType(RelationTypes.valueOf(request.getRelation().toString()))
        .build();
  }

  public RelationResponse wordRelation2RelationResponse(WordRelation relation) {
    return RelationResponse.builder()
        .id(relation.getId())
        .wordOne(relation.getWordOne())
        .wordTwo(relation.getWordTwo())
        .relationType(relation.getRelationType().toString())
        .build();
  }
}
