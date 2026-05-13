package web.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.mvc.dao.ProductDAO;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.MyErrorException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
	
	private final ProductDAO productDAO;
	
	@Override
	public List<ProductDTO> select() {
		
		return productDAO.select();
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO selectByCode(String code) throws MyErrorException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		return 0;
	}

}
