package my.assessment.word.relations;

import my.assessment.word.relations.controller.ListRequest;
import my.assessment.word.relations.controller.RelationCreateRequest;
import my.assessment.word.relations.controller.RelationResponse;
import my.assessment.word.relations.domain.RelationTypes;
import my.assessment.word.relations.domain.WordRelation;
import my.assessment.word.relations.repository.WordRelationsRepo;
import my.assessment.word.relations.util.RelationMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class WordRelationsSvc {

  private final WordRelationsRepo relationsRepo;

  public WordRelationsSvc(WordRelationsRepo relationsRepo) {
    this.relationsRepo = relationsRepo;
  }

  public RelationResponse createWordRelation(RelationCreateRequest request) {
    WordRelation wordRelation = RelationMapper.createRequest2WordRelation(request);
    WordRelation saved = relationsRepo.save(wordRelation);

    return RelationMapper.wordRelation2RelationResponse(saved);
  }

  public Page<RelationResponse> listRelations(ListRequest listRequest) {
    Page<WordRelation> pages;
    if (listRequest.hasRelationType()) {
      pages = relationsRepo.findAllByRelationType(RelationTypes.valueOf(listRequest.getRelationType().toString()),
          listRequest.computePageable());
    } else {
      pages = relationsRepo.findAll(listRequest.computePageable());
    }

    return pages.map(RelationMapper::wordRelation2RelationResponse);
  }
}
