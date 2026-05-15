package web.mvc.dao;

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

	private final List<ProductDTO> list; //영속성 = db역할(CRUD작업)
	
	@PostConstruct
	public void init() {
		log.info("list = {}" , list);
	}
	
	@Override
	public List<ProductDTO> select() {
		
		return list;
	}

	@Override
	public int insert(ProductDTO productDTO) throws MyErrorException {
		//상품코드가 중복인지 체크한다.
		if( this.selectByCode(productDTO.getCode()) != null) {//등록하려는 코드가 있다!!
			//중복이다.
			throw new MyErrorException(ErrorCode.DUPLICATE_PRODUCT_CODE);
		}
		
		//추가
		return list.add(productDTO) ? 1 : 0;
		
		//return 1;
	}

	@Override
	public int delete(String code) throws MyErrorException {
		ProductDTO dto = this.selectByCode(code);
		
		if(dto==null)throw new MyErrorException(ErrorCode.INVALID_PRODUCT_CODE);
		
		return list.remove(dto) ? 1 : 0 ;
		
	}

	@Override
	public ProductDTO selectByCode(String code) {
		for(ProductDTO dto : list) {
			if(dto.getCode().equals(code)) {
				return dto; //찾았다!!
			}
		}
		
		return null; //못찾았다.
	}
	
	

	@Override
	public int updateByCode(ProductDTO productDTO) throws MyErrorException {
		
		ProductDTO savedDTO =  this.selectByCode(productDTO.getCode());
		
		if(savedDTO==null)throw new MyErrorException(ErrorCode.FAILD_UPDATE);
		
		//수정
		savedDTO.setName(productDTO.getName());
		savedDTO.setPrice(productDTO.getPrice());
		savedDTO.setDetail(productDTO.getDetail());
		
		return 1;
	}

}
