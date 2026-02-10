package ex0206.array.goods;

/**
  각 요청에 대한 로직(기능)을 담당할 클래스
  (등록 , 전체검색, 부분검색, 수정, 삭제 등등.....)
*/
public class GoodsService{

	//상품을 관리할 배열 선언
	private Goods [] goodsArr = new Goods [10];
	public static int count;//0 배열방에 저장 객체의 개수 

   /**
      초기치 데이터를 세팅하는 메소드
	  String [][] data = new String [][]{
			 {"A01" , "새우깡" , "2500" , "짜고 맛나다."},  //---> Goods 
			 {"A02" , "고구마깡" , "3500" , "고구맛이고 달다."},  //---> Goods 
			 {"A03" , "감자깡" , "5000" , "감자맛에 고소한맛."}, // ---> Goods 
			 {"A04" , "허니버터칩" , "2200" , "달콤 하다."},
			 {"A05" , "콘칩" , "3000" , "고소하다."}
			 
		};
   */
   public void init(String [][] data){
	  
	   for(int i=0;i<data.length;i++) {
		   goodsArr[count++] = this.create(data[i]);
	   }
	   System.out.println("--------초기화 완료--------");

   }//메소드끝

   /**
      Goods를 생성해서 값을 설정하고 생성된 Goods를 리턴하는 메소드 
   */
   private Goods create(String [] row){//{"A01" , "새우깡" , "2500" , "짜고 맛나다."}
         Goods goods = new Goods();
         goods.setCode(row[0]);
         goods.setName(row[1]);
         goods.setPrice(Integer.parseInt(row[2]));
         goods.setExplain(row[3]);
         return goods;
   }

   /**
     등록(등록실패 - 중복인경우, 배열의 길이 벗어난경우)
	 @return : 
			 0이면 상품코드 중복 ,
			 1이면 등록성공, 
			 -1이면 배열의 길이 벗어남
   */
   public int insert(Goods goods){

	   // 배열의 길이 체크
	   if(goodsArr.length==GoodsService.count) {
		   return -1;
	   }

	   //중복체크 
	   if(this.selectByCode(goods.getCode())!=null) {
		   return 0;
	   }
	   //중복이 아니라면 새로 등록하기
	   goodsArr[GoodsService.count++] = goods;
	   return 1;
   }

   /**
     전체검색
   */
   public Goods[]  selectAll( ){
	   
	   return goodsArr;//
   }

   /**
     상품코드에 해당하는 상품 검색
	 @return : 만약 code에 해당하는 값이 있으면 Goods를 리턴하고
	           없으면 null 리턴
   */
   public Goods selectByCode(String code){
	   for(int i=0;i<count;i++) {
		   Goods searchedGoods = goodsArr[i];
		   //대소문자 구분 없앰.
		   String c = searchedGoods.getCode();
		   String convertUpper = c.toUpperCase();
		   
		   if(convertUpper.equals(code.toUpperCase())) {
			   return searchedGoods;
		   }
	   }
       return null;
   }

   /**
    상품코드에 해당하는 가격, 설명 수정하기 
	@return : true이면 수정완료, false이면 수정실패
   */
   public boolean update(Goods goods){ //수정하려는 코드, 변경값 - 가격, 설명
	   //굳이 반복문을 또 작성하지 말고 이미 만들어 둔 메소드를 활용하기
	   Goods findGoods = this.selectByCode(goods.getCode());	
	   
	   if(findGoods != null) {
		   findGoods.setPrice(goods.getPrice());
		   findGoods.setExplain(goods.getExplain());
		   
		   return true;
	   }
//	   for(int i=0;i<count;i++) {
//		   	if(goodsArr[i].getCode()==goods.getCode()) {
//			   goodsArr[i].setPrice(goods.getPrice());
//			   goodsArr[i].setExplain(goods.getExplain());
//			   return true;
//		   	}
//	   	}
	  
	   return false;
   }
   
   /**
    * 상품 삭제
    * @return : true이면 삭제 완료, false 삭제 불가
    * */
   public int findLocate(String code) {
	   for (int i = 0; i < count ; i++) {
		   if(goodsArr[i].getCode().equals(code) ) {
	   		return i;
		   }
	   }
	   return -1; //못찾았다!
   }
   
   public int delete(String code) {
	 	int locate = this.findLocate(code);
	   	if(locate == -1)return -1;
	   		goodsArr[locate]=null; //위치를 null로 초기화
	   
	   	for (int i = locate; i < count-1; i++) { //count = 5  -1 = 4
	   			goodsArr[i] = goodsArr[i+1];
	   	}
	
	   goodsArr[--count]=null;
	   		
	   	return 1;
	  }

   
   
}