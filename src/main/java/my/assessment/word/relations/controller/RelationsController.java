package my.assessment.word.relations.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import my.assessment.word.relations.WordRelationsSvc;
import my.assessment.word.relations.domain.WordRelation;
import my.assessment.word.relations.util.RelationMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(path = "/word/relations", produces = "application/json")
public class RelationsController {

  private final WordRelationsSvc wordRelationsSvc;

  public RelationsController(WordRelationsSvc wordRelationsSvc) {
    this.wordRelationsSvc = wordRelationsSvc;
  }

  @PostMapping
  public ResponseEntity<RelationResponse> createRelation(@Valid @RequestBody RelationCreateRequest request) {
    log.info("Relation create request received.{}", request);
    WordRelation wordRelation = wordRelationsSvc.createWordRelation(request);
    log.info("Relation create request processed successfully.{}", request);
    return ResponseEntity.ok(RelationMapper.wordRelation2RelationResponse(wordRelation));
  }


}
