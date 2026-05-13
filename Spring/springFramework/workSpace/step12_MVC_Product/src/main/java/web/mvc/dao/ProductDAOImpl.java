package web.mvc.dao;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import web.mvc.dto.ProductDTO;
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
		
		return 0;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDTO selectByCode(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		// TODO Auto-generated method stub
		return 0;
	}

}
