package ex0223.io;

import java.io.File;

import javax.swing.JOptionPane; //swing -> GUI 

public class FileExam {
    public FileExam() throws Exception{
    	String path = JOptionPane.showInputDialog("파일경로는?");//입력창
    	
    	System.out.println(path);
    	
    	File file = new File(path);
    	
    	if(file.exists()) {//존재한다면
    		System.out.println(path+"는 있습니다.^^");
    		
    		if(file.isDirectory()) {//폴더인 경우
    			System.out.println("폴더안에 정보를 확인 해볼게요!!");
    			String fileNames [] = file.list();//list -> 디렉토리 내의 파일 이름과 정보 추출, listFiles -> 디렉토리 내의 실제 있는 것들을 객체로 가져온다
    			for(String fname : fileNames) {
    				System.out.println(fname);
    			}
    			
    		}else {//파일인 경우
    			System.out.println("**파일의 정보를 확인해볼께요!!***");
    			System.out.println("file.canRead() = " + file.canRead());
    			System.out.println("file.canWrite() = " + file.canWrite());
    			System.out.println("file.length() = " + file.length());
    			System.out.println("file.getName() = " + file.getName());
    			System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());
    			System.out.println("file.lastModified() = " + file.lastModified());
    			
    		}
    		
    	}else {//파일, 폴더 동시에는 생성 못함
    		System.out.println(path+"가 없으니 생성할께요.");
    		//파일생성
    		file.createNewFile(); //IOException을 가지고 있음
    		
    		//폴더 생성
    		//file.mkdir();
    	}
    	
    	
    }
	public static void main(String[] args)throws Exception {
		new FileExam();

	}

}
