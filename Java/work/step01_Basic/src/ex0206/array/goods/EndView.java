package ex0206.array.goods;
/**
  요청 결과를 출력할 view
*/
public class EndView{
   /**
     성공여부 메시지를 출력하는 메소드 
   */
   public static void printMessage(String message){
      System.out.println(message+"\n");
   }

   /**
     전체검색 결과를 출력하는 메소드
   */
   public static void printSelectAll(Goods [] arr){//service에 있는 주소가 전달되었다.
	  System.out.println("----------------상품정보"+GoodsService.count+"---------------");
	  for(int i=0;i<GoodsService.count;i++) {
		   System.out.printf("상품코드: %s|",arr[i].getCode());
		   System.out.printf("상품명: %s|",arr[i].getName());
		   System.out.printf("상품가격: %s|",arr[i].getPrice());
		   System.out.printf("상품설명: %s|",arr[i].getExplain());
	  }
   }

   /**
     상품코드에 해당하는 상세정보 출력하는 메소드 
   */
   public static void printSelectByCode(Goods goods){
	   System.out.printf("상품코드: %s|",goods.getCode());
	   System.out.printf("상품명: %s|",goods.getName());
	   System.out.printf("상품가격: %s|",goods.getPrice());
	   System.out.printf("상품설명: %s|",goods.getExplain());
   }


}