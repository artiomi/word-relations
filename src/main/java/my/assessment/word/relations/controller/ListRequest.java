package my.assessment.word.relations.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import my.assessment.word.relations.controller.RelationCreateRequest.Relation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

@AllArgsConstructor
@Builder
@Getter
public class ListRequest {

  private int page;
  private int pageSize;
  private Relation relationType;

  public boolean hasRelationType() {
    return this.relationType != null;
  }

  public Pageable computePageable() {

    return PageRequest.of(page, pageSize, Sort.by(Direction.ASC, "id"));
  }
}
