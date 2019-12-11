package Locat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class gameSave {
   static File file = new File("C:\\data.txt"); // �����ο� txt ����

   public static void save() {
      try {
         // ���Ͽ� ���ڿ��� ����.
         // ������ �̹� ������ �����ϸ� ��� ������ �����ϰ� ������ �����
         FileWriter fw = new FileWriter(file);
         fw.write(MainFrame.currentStage); // ����� �����ִµ� char��
         fw.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public static int loading() {
      int savedstage = -1;
      int temp=-1;
      try { // file�� ���ڷ� FileReader��ü�� �����ߴ�.
            // �� ��ü�� ���� ������ ���� �� �ִ�.
         if (checkBeforeFile(file)) {
            FileReader fr = new FileReader(file);

            // FileReader ��ü�� ���� ������ �ѱ��ھ� �о� code������ �Ҵ��Ѵ�.
            // .read() �޼ҵ��� ������ int���̱� ������ ch�� int�� �������־�� �Ѵ�.
            
            while ((temp = fr.read()) != -1) {// ��� ������ �б� ������ ���尪�� 4����Ʈ�̹Ƿ�
               savedstage=temp;
               System.out.print(savedstage); //���� �������� ��ġ
            }
            
         } else {
            System.out.println("���Ͽ� ������ �� �����ϴ�.");
         }

      } catch (Exception e) {
         e.printStackTrace();
      }
      return savedstage;
   }

   static boolean checkBeforeFile(File file) {
      // ������ �����ϰ�
      if (file.exists()) {
         // �� ������ �����̰�, ���� �� �ִٸ� true�� �����Ѵ�.
         if (file.isFile() && file.canRead()) {
            return true;
         }
      }
      return false;
   }

}