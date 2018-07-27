package fr.gtm.pbavu.presentation;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.gtm.pbavu.domain.Client;
import fr.gtm.pbavu.service.ClientService;

/**
 * Classe représentant le web service de la classe Client.
 *
 * @author AZERI-VALLETTE-USSUNET
 *
 */

@Controller
@RequestMapping("/client")
public class ClientController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	private ClientService service;

	/**
	 * 
	 * @param client
	 *            client de type Client
	 * @return crée un nouveau client
	 */
	@PostMapping({"","/"})
	@ResponseBody
	public Client add(@RequestBody final Client client) {
		ClientController.LOGGER.debug("Client ajouter !!", client.getName(), client.getPrenom(), client.getMail(),
				client.getNumero());

		return this.service.create(client);
	}

	/**
	 * 
	 * @param id
	 *            identifiant du client
	 * @return un client
	 */
	@PostMapping("/{id}")
	@ResponseBody
	public Client get(@PathVariable final Integer id) {

		return this.service.read(id);
	}

	/**
	 * 
	 * @return liste des clients
	 */
	@RequestMapping("/list")
	@ResponseBody
	public List<Client> list() {
		return this.service.getList();
	}

}
