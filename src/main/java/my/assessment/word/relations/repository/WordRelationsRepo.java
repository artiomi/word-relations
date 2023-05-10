package my.assessment.word.relations.repository;

import my.assessment.word.relations.domain.RelationTypes;
import my.assessment.word.relations.domain.WordRelation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRelationsRepo extends JpaRepository<WordRelation, String> {

  Page<WordRelation> findAllByRelationType(RelationTypes relationType, Pageable pageable);

}
