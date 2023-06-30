package CafeGamers.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import CafeGamers.Model.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}
