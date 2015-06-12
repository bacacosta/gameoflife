package gameoflife.repository;

import org.junit.Assert;
import org.junit.Test;

public class GameOfLifeRepositoryTests {
	private static final int X_LENGTH = 4;
	private static final int Y_LENGTH = 4;

	@Test
	public void generateFirstGrid() {
		Boolean[][] grid = new Boolean[X_LENGTH][Y_LENGTH];
		grid[0][0] = true;
		Assert.assertEquals(grid[0][0], true);
		grid[0][1] = true;
		Assert.assertEquals(grid[0][1], true);
		grid[0][2] = false;
		Assert.assertEquals(grid[0][2], false);
		grid[0][3] = true;
		Assert.assertEquals(grid[0][3], true);
		grid[1][0] = false;
		Assert.assertEquals(grid[1][0], false);
		grid[1][1] = false;
		Assert.assertEquals(grid[1][1], false);
		grid[1][2] = true;
		Assert.assertEquals(grid[1][2], true);
		grid[1][3] = true;
		Assert.assertEquals(grid[1][3], true);
		grid[2][0] = false;
		Assert.assertEquals(grid[2][0], false);
		grid[2][1] = true;
		Assert.assertEquals(grid[2][1], true);
		grid[2][2] = true;
		Assert.assertEquals(grid[2][2], true);
		grid[2][3] = true;
		Assert.assertEquals(grid[2][3], true);
		grid[3][0] = false;
		Assert.assertEquals(grid[3][0], false);
		grid[3][1] = false;
		Assert.assertEquals(grid[3][1], false);
		grid[3][2] = false;
		Assert.assertEquals(grid[3][2], false);
		grid[3][3] = true;
		Assert.assertEquals(grid[3][3], true);
	}
}
