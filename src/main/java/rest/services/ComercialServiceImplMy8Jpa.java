package rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rest.entities.Comercial;
import rest.repositories.ComercialRepository;

@Service
public class ComercialServiceImplMy8Jpa implements ComercialService {

	@Autowired
	private ComercialRepository comercialRepository;
	

	@Override
	public Comercial createOne(Comercial comercial) {
		return comercialRepository.save(comercial);
	}

	@Override
	public Comercial updateOne(Comercial comercial) {
		try {
			return comercialRepository.save(comercial);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public boolean deleteOne(int idComercial) {
		try {
			if (findOne(idComercial) != null) {
				comercialRepository.deleteById(idComercial);
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Comercial findOne(int idComercial) {
		return comercialRepository.findById(idComercial).orElse(null);
	}

	@Override
	public List<Comercial> findAll() {
		return comercialRepository.findAll();
	}

}
