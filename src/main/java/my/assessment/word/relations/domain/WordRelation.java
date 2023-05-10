package my.assessment.word.relations.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "word_relations")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WordRelation {

  @Id
  private String id;
  @Column(name = "word_one")
  private String wordOne;
  @Column(name = "word_two")
  private String wordTwo;
  @Enumerated(value = EnumType.STRING)
  @Column(name = "relation_type")
  private RelationTypes relationType;

}
