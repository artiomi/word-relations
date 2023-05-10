package my.assessment.word.relations;

import my.assessment.word.relations.controller.RelationCreateRequest;
import my.assessment.word.relations.domain.WordRelation;
import my.assessment.word.relations.repository.WordRelationsRepo;
import my.assessment.word.relations.util.RelationMapper;
import org.springframework.stereotype.Service;

@Service
public class WordRelationsSvc {
  private final WordRelationsRepo relationsRepo;

  public WordRelationsSvc(WordRelationsRepo relationsRepo) {
    this.relationsRepo = relationsRepo;
  }

  public WordRelation createWordRelation(RelationCreateRequest request){
    WordRelation wordRelation = RelationMapper.createRequest2WordRelation(request);
    return relationsRepo.save(wordRelation);
  }
}
