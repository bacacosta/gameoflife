package gameoflife.repository;

import gameoflife.domain.Grid;

import org.springframework.data.repository.CrudRepository;

public interface GridRepository extends CrudRepository<Grid, Integer> {

}
