package gameoflife.web;

import gameoflife.service.GameOfLifeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class GameOfLifeController {
	@Autowired
	private GameOfLifeService lifeService;

	@RequestMapping("/")
	public String index(Model model) {
		return "index";
	}

	@RequestMapping("/start")
	public String startGameOfLife(RedirectAttributes attr) {
		lifeService.generateFirstGrid();

		attr.addAttribute("grid", printGrid(lifeService.getGrid()));

		return "redirect:/";
	}

	@RequestMapping("/playNext")
	public String playNextGeneration(RedirectAttributes attr) {
		lifeService.generateNextGrid();

		attr.addAttribute("grid", printGrid(lifeService.getGrid()));

		return "redirect:/";
	}

	private String printGrid(Boolean[][] grid) {
		StringBuffer output = new StringBuffer();

		for (int x = 0; x < grid.length; x++) {
			for (int y = 0; y < grid[x].length; y++) {
				if (grid[x][y]) {
					output.append('o');
				} else {
					output.append(' ');
				}
			}
			output.append("\n");
		}

		return output.toString();
	}
}
