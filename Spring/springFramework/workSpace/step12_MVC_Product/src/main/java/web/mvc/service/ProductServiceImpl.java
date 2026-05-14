package web.mvc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import web.mvc.dao.ProductDAO;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
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
		int price = productDTO.getPrice();
		if(price < 1000 || price > 10000) {
			throw new MyErrorException(ErrorCode.INVALID_PRICE);
		}
		int result = productDAO.insert(productDTO);
		return result;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		int result = productDAO.delete(code);
		
		if(result == 0)
			throw new MyErrorException(ErrorCode.INVALID_PRODUCT_CODE);
		
		return 1;
	}

	@Override
	public ProductDTO selectByCode(String code) throws MyErrorException {
		ProductDTO product = productDAO.selectByCode(code);
		if(product == null)
			throw new MyErrorException(ErrorCode.INVALID_PRODUCT_CODE);
		
		return product;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		int result = productDAO.updateByCode(productDTO);
		if(result==0) throw new MyErrorException(ErrorCode.FAILD_UPDATE);
		return 1;
	}

}
