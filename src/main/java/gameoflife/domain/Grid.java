package gameoflife.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grid {
	@Id
	private Integer id;
	private Boolean[][] grid;

	protected Grid() {}

	public Grid(Integer id, Boolean[][] grid) {
		this.id = id;
		this.grid = grid;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean[][] getGrid() {
		return grid;
	}

	public void setGrid(Boolean[][] grid) {
		this.grid = grid;
	}
}
