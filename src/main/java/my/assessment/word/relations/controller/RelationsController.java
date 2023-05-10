package my.assessment.word.relations.controller;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import my.assessment.word.relations.WordRelationsSvc;
import my.assessment.word.relations.domain.WordRelation;
import my.assessment.word.relations.util.RelationMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    var relationResponse = wordRelationsSvc.createWordRelation(request);
    log.info("Relation create request processed successfully.{}", request);
    return ResponseEntity.ok(relationResponse);
  }

  @GetMapping
  public ResponseEntity<Page<RelationResponse>> listRelations(Pageable pageable){
    Page<RelationResponse> relationResponses = wordRelationsSvc.listRelations(pageable);
    return ResponseEntity.ok(relationResponses);
  }

}
