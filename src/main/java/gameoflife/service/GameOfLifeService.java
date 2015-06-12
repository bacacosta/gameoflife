package gameoflife.service;

import gameoflife.repository.GameOfLifeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameOfLifeService {
	@Autowired
	private GameOfLifeRepository lifeRepository;

	public void generateFirstGrid() {
		lifeRepository.generateFirstGrid();
	}

	public void generateNextGrid() {
		lifeRepository.generateNextGrid();
	}

	public Boolean[][] getGrid() {
		return lifeRepository.getGrid();
	}
}
