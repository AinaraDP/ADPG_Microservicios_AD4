package rest.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rest.entities.Comercial;
import rest.entities.Pedido;
import rest.repositories.ComercialRepository;
import rest.services.ComercialService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/comercial")
public class ComercialRestController {

	@Autowired
	private ComercialService comercialService;
	@Autowired
	private ComercialRepository comercialRepository;
	
	/**
	 * RAIZ / BUSCAR TODOS
     * Obtiene una lista de todos los comerciales.
     * 
     * @return lista de comerciales.
     */
	@GetMapping({"","/"})
	public List<Comercial> all() {
		return comercialService.findAll();
	}

	/**
	 * CREATE
     * Crea un nuevo comercial.
     * 
     * @param comercial el comercial a crear.
     * @return el comercial creado.
     */
	@PostMapping("/alta")
	public Comercial create(@RequestBody Comercial comercial) {
		return comercialService.createOne(comercial);
	}

    /**
     * FIND ONE
     * Obtiene un comercial específico por su ID.
     * 
     * @param idComercial el ID del comercial.
     * @return el comercial solicitado.
     */
	@GetMapping("/uno/{idComercial}")
	public Comercial read(@PathVariable int idComercial) {
		return comercialService.findOne(idComercial);
	}

    /**
     * UPDATE
     * Actualiza la información de un comercial.
     * 
     * @param comercial el comercial con la información actualizada.
     * @return el comercial actualizado.
     */
	@PutMapping("/modificar")
	public Comercial update(@RequestBody Comercial comercial) {
		return comercialService.updateOne(comercial);
	}

    /**
     * DELETE ONE
     * Elimina un comercial específico por su ID.
     * 
     * @param idComercial el ID del comercial a eliminar.
     * @return mensaje que indica si el comercial fue eliminado correctamente o no.
     */
	@DeleteMapping("/eliminar/{idComercial}")
	public String delete(@PathVariable int idComercial) {
		if (comercialService.deleteOne(idComercial))
			return "Comercial eliminado correctamente";
		else
			return "Comercial no se ha podido eliminar";
	}

    /**
     * BUSCAR POR CLIENTE ASOCIADO
     * Obtiene una lista de comerciales asociados a un cliente específico.
     * 
     * @param idCliente el ID del cliente.
     * @return lista de comerciales asociados al cliente.
     */
	@GetMapping("/bycliente/{idCliente}")
	public List<Comercial> findByCliente(@PathVariable int idCliente) {
		return comercialRepository.findComercialPorCliente(idCliente);
	}

    /**
     * BUSCAR COMERCIALES CON PEDIDOS ASOCIADOS
     * Obtiene una lista de comerciales que tienen pedidos asociados.
     * 
     * @return lista de comerciales con pedidos.
     */
	@GetMapping("/conpedidos")
	public List<Comercial> findConPedidos() {
		return comercialRepository.findComercialesConPedidos();
	}
	
    /**
     * PEDIDOS ASOCIADOS A UN COMERCIAL
     * Obtiene una lista de todos los pedidos asociados a un comercial específico.
     * 
     * @param idComercial el ID del comercial.
     * @return lista de pedidos del comercial.
     */
	@GetMapping("/pedidos/{idComercial}")
	public List<Pedido> todos(@PathVariable int idComercial){
		return comercialRepository.findPedidosByComercial(idComercial);
		
	}
}
