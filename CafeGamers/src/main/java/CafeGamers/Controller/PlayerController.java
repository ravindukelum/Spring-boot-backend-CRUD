package CafeGamers.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CafeGamers.Model.Player;
import CafeGamers.Service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService ser;
	
	//Add player
	@PostMapping("/save")
	public Player addplayer(@RequestBody Player p) {
		return ser.addplayer(p);
	}
	
	//add many
	@PostMapping("/saveall")
	public List<Player> addPlayers(@RequestBody List<Player> p){
		return ser.addPlayers(p);
	}
	
	//find one
	@GetMapping("/find/{id}")
	public Player findPlayer(@PathVariable Integer id) {
		return ser.findPlayer(id);
	}
	
	//findAll
	@GetMapping("/findall")
	public List<Player> findallPlayers(){
		return ser.findallPlayers();
	}
	
	//update player
	@PutMapping("/update/{id}")
	public Player updatePlayer(@RequestBody Player p,@PathVariable Integer id) {
		return ser.updatePlayer(p, id);
	}
	
	//delete player
	@DeleteMapping("/deleteplayer/{id}")
	public String deletePlayer(@PathVariable Integer id) {
		return ser.deletePlayer(id);
	}
	
}
