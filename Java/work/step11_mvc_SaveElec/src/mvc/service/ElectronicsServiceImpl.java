package mvc.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    
    private File file;
    
    
    /** 
     * 외부에서 객체 생성안됨. 
     * InitInfo.properties파일을 로딩하여  List에 추가하여
     * 초기치 데이터를 만든다.
     * 리스트를 저장한 파일이 존재하는지 여부에 따라서 InitInfo.properties 읽을지, 역직렬화를 할 지 결정
     * if(객체를 파일에 저장한 파일이 존재한다면) else(getBundle)
     */
    private ElectronicsServiceImpl() {
    	System.out.println("user.dir = "+System.getProperty("user.dir")); //사용자의 디렉터리
    	System.out.println("user.home = "+System.getProperty("user.home"));
    	String path = System.getProperty("user.dir")+"/save.txt";
    	file = new File(path);
    	try {
	    	if(file.exists()) {
	    		System.out.println(1);
	    		try(ObjectInputStream ois = 
	    				new ObjectInputStream(new BufferedInputStream(
	    						new FileInputStream(file)))){
	    			Object obj = ois.readObject();
	    			if(obj instanceof List) {
	    				list = (List<Electronics>) obj;
	    			}
	    		}
	    	}else {
	    		ResourceBundle rb = ResourceBundle.getBundle("InitInfo");//InitInfo.properties
	            for(String key : rb.keySet()) {
	            	String value =  rb.getString(key); //100,\uC120\uD48D\uAE30,35000,\uC0BC\uC131 \uC120\uD48D\uAE30
	         	   	String data[] = value.split(",");
	         	    list.add(new Electronics( Integer.parseInt(data[0]) ,data[1],   
	         	    	 Integer.parseInt( data[2]), data[3]) );
	            }
	    	}
    	}catch(Exception e) {
    		e.getMessage();
    	}
        
        System.out.println(list);
      
    }
    
    public static ElectronicsService getInstance() {
		return instance;
	}

	@Override
	public void insert(Electronics electronics) 
			  throws ElectronicsArrayBoundsException, DuplicateModelNoException {
		//성공 여부는 try-catch 에서 판단할 수 있기 때문에 유저에게 보여줄 게 아니라면 void를 사용한다.
		if(list.size()>MAX_SIZE) {
			throw new ElectronicsArrayBoundsException("등록할 수 있는 상품의 개수를 초과했습니다.");
		}
		
		//모델 번호 중복 체크, 찾는 게 있으면 안 되는 상황
		//searchByModelNo를 사용해라.
		//this.searchByModelNo(electronics.getModelNo());
		//여기서 호출하고 searchByModelNo을 사용하면 거기서 예외를 던지니깐 여기서 try-catch로 받는다.
		//이렇게 하면 searchByModelNo에서 결과가 정상적으로 리턴될 때 예외가 발생하도록 try-catch를 구상해야 한다.
		//정상적으로 예외가 발생하지 않을 때 새롭게 추가하는 것
		try {
			this.searchByModelNo(electronics.getModelNo());
			throw new DuplicateModelNoException(electronics.getModelNo()+"는 이미 존재합니다.");
		}catch(SearchNotFoundException e) {
			//예외가 발생했다는 것이 중복이 아니다라는 것을 뜻 함.
			list.add(electronics);
		}
		
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
		throw new SearchNotFoundException(modelNo+"에 해당하는 상품이 없습니다.");
	}

	@Override
	public void update(Electronics electronics) throws SearchNotFoundException {
		Electronics e = this.searchByModelNo(electronics.getModelNo());
		e.setModelDetail(electronics.getModelDetail());
	}

	@Override
	public void delete(int modelNo) throws SearchNotFoundException {
		list.remove(this.searchByModelNo(modelNo));
	}

	@Override
	public void saveObject() throws Exception {
		try(ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(file)));) {
			os.writeObject(list);
		}		
	}

	@Override
	public List<Electronics> selectSortByPrice() {//Functional Interface를 람다식으로 표현
		List<Electronics> sortList = new ArrayList<>(list);//원본 복사
		Collections.sort(sortList, (e1, e2)-> e1.getModelPrice()==e2.getModelPrice() ?
				e1.getModelNo()-e2.getModelNo() : e1.getModelPrice()-e2.getModelPrice());
		return sortList;
	}
	
	
    
} // 클래스 끝 