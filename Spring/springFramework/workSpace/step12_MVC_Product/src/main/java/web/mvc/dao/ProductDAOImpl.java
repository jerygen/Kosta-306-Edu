package web.mvc.dao;

import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
import web.mvc.exception.ErrorCode;
import web.mvc.exception.MyErrorException;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ProductDAOImpl implements ProductDAO {

	private final List<ProductDTO> list; //영속성 = db역할 (CRUD 작업)
	
	@PostConstruct
	public void init() {
		log.info("list={}",list);
	}
	
	@Override
	public List<ProductDTO> select() {
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		for(ProductDTO p: list) {
			if(p.getCode().equals(productDTO.getCode()))
				throw new MyErrorException(ErrorCode.DUPLICATE_PRODUCT_CODE);
		}
		list.add(productDTO);
		return 1;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		Iterator<ProductDTO> it = list.iterator();
		while(it.hasNext()) {
			ProductDTO product = it.next();
			if(product.getCode().equals(code)) {
				it.remove();
				return 1;
			}
		}
		return 0;
	}

	@Override
	public ProductDTO selectByCode(String code) {
		for(ProductDTO p : list) {
			if(p.getCode().equals(code)) return p;
		}
		
		return null;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		int price = productDTO.getPrice();
		if(price < 1000||price>10000) throw new MyErrorException(ErrorCode.INVALID_PRICE);
		
		for(int i =0; i<list.size(); i++) {
			ProductDTO p = list.get(i);
			if(p.getCode().equals(productDTO.getCode())) {
				list.set(i, productDTO);
				return 1;
			}
		}
		return 0;
	}

}
