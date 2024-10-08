package rest.services;

import java.util.List;

import rest.entities.Comercial;

public interface ComercialService {
	
	Comercial createOne(Comercial comercial);
	Comercial updateOne(Comercial comercial);
	boolean deleteOne(int idComercial);
	Comercial findOne(int idComercial);
	List<Comercial> findAll();
	
	

}
