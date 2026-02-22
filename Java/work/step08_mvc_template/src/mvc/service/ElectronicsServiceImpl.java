package mvc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

import mvc.dto.Electronics;
import mvc.exception.DuplicateModelNoException;
import mvc.exception.ElectronicsArrayBoundsException;
import mvc.exception.SearchNotFoundException;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

public class ElectronicsServiceImpl implements ElectronicsService {
	//클래스 다이어그램의 data: String[][]는 무시
	//작성할 때는 검색 기능을 완성한 다음에 수정 기능 완성하는 식으로 작성하기 Controller 한 번에 완성, Service 한 번에 완성 이렇게 하지 말기
	
	private static ElectronicsService instance = new ElectronicsServiceImpl(); 
    private static final int MAX_SIZE=10;
    List<Electronics> list = new ArrayList<Electronics>();
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 
     */
    private ElectronicsServiceImpl() {
    	System.out.println("**private constructor init.....");
    	ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
        for(String key : rb.keySet()) {
        	String value =  rb.getString(key); //100,\uC120\uD48D\uAE30,35000,\uC0BC\uC131 \uC120\uD48D\uAE30
     	   	String data[] = value.split(",");
     	   	//System.out.println(key +" = " + value);
     	  
     	    list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
     	    	 Integer.parseInt( data[2]), data[3]) );
     	  
        }
        
        System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			  throws ElectronicsArrayBoundsException, DuplicateModelNoException {
		if(list.size()>MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("등록할 수 있는 상품의 개수를 초과했습니다.");
		}
		for(Electronics elec : list) {
			if(elec.getModelNo()==electronics.getModelNo()) {
				throw new DuplicateModelNoException("같은 상품 번호의 상품이 있습니다.");
			}
		}
		list.add(electronics);
	}

	@Override
	public List<Electronics> selectAll() {
		return list;
	}

	@Override
	public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
		for(Electronics e: list) {
			if(e.getModelNo()==modelNo) {
				return e;
			}
		}
		throw new SearchNotFoundException("해당 번호의 상품이 없습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics e = searchByModelNo(electronics.getModelNo());
		e.setModelDetail(electronics.getModelDetail());
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		list.remove(searchByModelNo(modelNo));
	}

	@Override
	public List<Electronics> selectSortByPrice() {
		List<Electronics> shallowCopy = new ArrayList<>(list);
		Collections.sort(shallowCopy, (e1, e2)-> e1.getModelPrice()==e2.getModelPrice() ?
				e1.getModelNo()-e2.getModelNo() : e1.getModelPrice()-e2.getModelPrice());
		return shallowCopy;
	}
    
} // 클래스 끝 