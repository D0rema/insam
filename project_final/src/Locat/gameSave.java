package Locat;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class gameSave {
	static String cwd = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	static File file = new File(cwd+"data.txt"); // �����ο� txt ����

	public static void save() {
		try {
			
			// ���Ͽ� ���ڿ��� ����.
			// ������ �̹� ������ �����ϸ� ��� ������ �����ϰ� ������ �����
			FileWriter fw = new FileWriter(file);
			fw.write(Stage.stage); // ����� �����ִµ� char��
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int loading() {
		int savedstage = -1;
		int temp = -1;
		try { // file�� ���ڷ� FileReader��ü�� �����ߴ�.
				// �� ��ü�� ���� ������ ���� �� �ִ�.
			if (checkBeforeFile(file)) {
				FileReader fr = new FileReader(file);

				// FileReader ��ü�� ���� ������ �ѱ��ھ� �о� code������ �Ҵ��Ѵ�.
				// .read() �޼ҵ��� ������ int���̱� ������ ch�� int�� �������־�� �Ѵ�.

				while ((temp = fr.read()) != -1) {// ��� ������ �б� ������ ���尪�� 4����Ʈ�̹Ƿ�
					savedstage = temp;
				}

			} else {
				System.out.println("���Ͽ� ������ �� �����ϴ�.");
				return savedstage;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		Stage.stage=savedstage;
		return 1;
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