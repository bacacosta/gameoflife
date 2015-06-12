package gameoflife.repository;

import gameoflife.domain.Grid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GameOfLifeRepository {
	private static final int X_LENGTH = 4;
	private static final int Y_LENGTH = 4;
	private static final int GRID_ID = 1;

	@Autowired
	private GridRepository gridRepository;

	public void generateFirstGrid() {
		Boolean[][] grid = new Boolean[X_LENGTH][Y_LENGTH];

		// generates randomly a first grid
		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				grid[x][y] = Math.random() < 0.5;
			}
		}

		gridRepository.save(new Grid(GRID_ID, grid));
	}

	public void generateNextGrid() {
		Boolean[][] grid = gridRepository.findOne(1).getGrid();
		Boolean[][] nextGen = new Boolean[X_LENGTH][Y_LENGTH]; // next generation

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				nextGen[x][y] = survive(grid, x, y);
			}
		}

		gridRepository.save(new Grid(GRID_ID, nextGen));
	}

	public Boolean[][] getGrid() {
		return gridRepository.findOne(1).getGrid();
	}

	private Boolean survive(Boolean[][] grid, int x, int y) {
		Integer count = getNeighboursCount(grid, x, y);

		// live cells with 2 or 3 live neighbours survive
		if (grid[x][y] && count >= 2 && count <= 3) return true;

		// dead cells with 3 live neighbours revive
		if (!grid[x][y] && count == 3) return true;

		// all other cells die
		return false;
	}

	public Integer getNeighboursCount(Boolean[][] grid, int x, int y) {
		Integer count = 0;

		if (isWithinBorders(y + 1, Y_LENGTH) && grid[x][y + 1]) count++;
		if (isWithinBorders(x + 1, X_LENGTH) && isWithinBorders(y + 1, Y_LENGTH) && grid[x + 1][y + 1]) count++;
		if (isWithinBorders(x + 1, X_LENGTH) && grid[x + 1][y]) count++;
		if (isWithinBorders(x + 1, X_LENGTH) && isWithinBorders(y - 1, Y_LENGTH) && grid[x + 1][y - 1]) count++;
		if (isWithinBorders(y - 1, Y_LENGTH) && grid[x][y - 1]) count++;
		if (isWithinBorders(x - 1, X_LENGTH) && isWithinBorders(y - 1, Y_LENGTH) && grid[x - 1][y - 1]) count++;
		if (isWithinBorders(x - 1, X_LENGTH) && grid[x - 1][y]) count++;
		if (isWithinBorders(x - 1, X_LENGTH) && isWithinBorders(y + 1, Y_LENGTH) && grid[x - 1][y + 1]) count++;

		return count;
	}

	private Boolean isWithinBorders(int pos, int length) {
		return pos >= 0 && pos < length;
	}
}
