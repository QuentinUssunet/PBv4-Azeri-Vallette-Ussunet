package fr.gtm.pbavu.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.gtm.pbavu.domain.Client;

/**
 * L'interface ClientRepository permet d'accorder une entité Client à un JPA repository 
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

	
	public Client findByNumero(String numero);

}
