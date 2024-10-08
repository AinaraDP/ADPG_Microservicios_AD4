package rest.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import rest.entities.Comercial;
import rest.entities.Pedido;


public interface ComercialRepository extends JpaRepository<Comercial, Integer>{

	
	@Query ("SELECT p.comercial FROM Pedido p WHERE p.cliente.idCliente = :idCliente")
	public List<Comercial> findComercialPorCliente (int idCliente);
	
	@Query("SELECT p.comercial FROM Pedido p")
	List<Comercial> findComercialesConPedidos();
	
	@Query("SELECT p FROM Pedido p WHERE p.comercial.idComercial = :idComercial")
	List<Pedido> findPedidosByComercial(int idComercial);
	
	
}
