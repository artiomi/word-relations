package my.assessment.word.relations.controller;

import java.util.Optional;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import my.assessment.word.relations.WordRelationsSvc;
import my.assessment.word.relations.controller.RelationCreateRequest.Relation;
import org.springframework.data.domain.Page;
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
  public ResponseEntity<Page<RelationResponse>> listRelations(
      @RequestParam Optional<Integer> page,
      @RequestParam Optional<Integer> size,
      @RequestParam(required = false) Relation relationType) {
    ListRequest listRequest = ListRequest.builder().relationType(relationType)
        .page(page.orElse(0))
        .pageSize(size.orElse(100))
        .build();
    Page<RelationResponse> relationResponses = wordRelationsSvc.listRelations(listRequest);
    return ResponseEntity.ok(relationResponses);
  }

}
