package my.assessment.word.relations.repository;

import my.assessment.word.relations.domain.WordRelation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WordRelationsRepo extends JpaRepository<WordRelation, String> {

}
