package Locat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class gameSave {
   static File file = new File("C:\\data.txt"); // 저장경로에 txt 파일

   public static void save() {
      try {
         // 파일에 문자열을 쓴다.
         // 하지만 이미 파일이 존재하면 모든 내용을 삭제하고 그위에 덮어쓴다
         FileWriter fw = new FileWriter(file);
         fw.write(MainFrame.currentStage); // 여기다 변수넣는데 char로
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static int loading() {
      int savedstage = -1;
      int temp=-1;
      try { // file을 인자로 FileReader객체를 선언했다.
            // 이 객체를 통해 파일을 읽을 수 있다.
         if (checkBeforeFile(file)) {
            FileReader fr = new FileReader(file);

            // FileReader 객체를 통해 파일을 한글자씩 읽어 code변수에 할당한다.
            // .read() 메소드의 리턴이 int형이기 때문에 ch를 int로 선언해주어야 한다.
            
            while ((temp = fr.read()) != -1) {// 모든 내용을 읽기 어차피 저장값은 4바이트이므로
               savedstage=temp;
               System.out.print(savedstage); //저장 스테이지 위치
            }
            
         } else {
            System.out.println("파일에 접근할 수 없습니다.");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
      return savedstage;
   }

   static boolean checkBeforeFile(File file) {
      // 파일이 존재하고
      if (file.exists()) {
         // 그 파일이 파일이고, 읽을 수 있다면 true를 리턴한다.
         if (file.isFile() && file.canRead()) {
            return true;
         }
      }
      return false;
   }

}