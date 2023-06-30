package CafeGamers.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CafeGamers.Model.Player;
import CafeGamers.Repository.PlayerRepository;


@Service
public class PlayerService {

	@Autowired
	private PlayerRepository repo;
	
	//Add player
	public Player addplayer(Player p) {
		return repo.save(p);
	}
	
	//add many
	public List<Player> addPlayers(List<Player> p){
		return repo.saveAll(p);
	}
	
	//find one
	public Player findPlayer(Integer id) {
		return repo.findById(id).orElseThrow(()->new RuntimeException("You serch id not availble"));
	}
	
	//findAll
	public List<Player> findallPlayers(){
		return repo.findAll();
	}
	
	//update player
	public Player updatePlayer(Player p,Integer id) {
		Player oldP= repo.findById(id).orElseThrow(()->new RuntimeException("Can not find given player id"));
		oldP.setName(p.getName());
		oldP.setAddress(p.getAddress());
		oldP.setAge(p.getAge());
		oldP.setEmail(p.getEmail());
		oldP.setGame(p.getGame());
		return repo.save(oldP);
	}
	
	//delete player
	 public String deletePlayer(Integer id) {
	        if (repo.existsById(id)) 
	        {
	            repo.deleteById(id);
	            return "Player deleted successfully";
	        } else {
	            return "Player not available";
	        }
	    }
	
}
