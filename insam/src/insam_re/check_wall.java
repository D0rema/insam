package insam_re;

public class check_wall {
	int wall_count = 5;
	int wall[][] = new int [wall_count][4];
	moving_test m1 = new moving_test();
	int flat_count = 2;//�÷��� ����
	int flat[][] = new int [flat_count][4];//�÷��� �Լ� [0] ������ ����x�� [1] ������ �� x�� [2] ������ y�� [3] �켱 y���ε� ���� ��������� ����
	
	public int on_flat = 0;//������ ������ ture�� �Ǿ� �ٴ��� ������ y������ ����
	public int on_bottom = 0; //�⺻���� �ٴ� ���⼭�� 468�� ����

	public int ff; //���� ��� �ִ� ������ y���� �����ϱ� ���� �ʿ��� �Լ�


	public void check_wall(){
		is_bottom();
		in_flat();
		flat[0][0]= 200;// ���� �׽�Ʈ �ϱ� ���� ���� ����
		flat[0][1]= 300;
		flat[0][2]= 388;
		flat[0][3]= 400;
		
		flat[1][0]= 400;
		flat[1][1]= 500;
		flat[1][2]= 228;
		flat[1][3]= 400;
	}
	public void is_bottom() { // �߷��� ����� ���� �Լ�
		if(on_flat==0) { // ���ǿ� ���� �������� �׻� �ٴ��� 468
			moving_test.g_y = 468;
		}
		if(!moving_test.try_jump) { // �����Ҷ��� �߷� ���� x
		if(moving_test.y>=moving_test.g_y) { //g_y �����϶� �ٲ�� �ֱ⶧���� ������ ����
			on_bottom = 1; //ĳ���Ͱ� �ٴڿ� ������� 1 
		}else {on_bottom = 0;}
		if(on_bottom==0) { // �ٴڿ� ���� �ʾ������� �׻� ������
			moving_test.y+=16;
		}
		}
	}
	public void in_flat() { //�����϶� üũ�ϴ� �Լ�
		for(int i = 0;i<flat_count;i++) { // ��� ������ üũ 
			if(flat[i][0]<moving_test.x&&flat[i][1]>moving_test.x&&flat[i][2]==moving_test.y) { // ���� ĳ������ ��ǥ�� ���� ��ǥ �ȿ� �ִ��� üũ i�� ��� ���� üũ

				on_flat=1; // ���� ��ǥ �ȿ� ������ ������ ��� ������ 1
				ff=i; //�׶��� ���� ������ �Ʒ��� ���
				moving_test.g_y = flat[ff][2]; // ���� ����ִ� ������ y���� �ٴ����� ���
			}else if(flat[ff][0]>moving_test.x||flat[ff][1]<moving_test.x){
						on_flat=0; // ����(ff�� ����) ��� �ִ� ������ x���� ����� ������ ��� ���� ���������� ó�� 
			}
		}
	}
 public void on_wall() {
	if(moving_test.y<=48) {
		moving_test.playerMove=false;
		moving_test.not_key=1;
	}
	if(moving_test.y>=484) {
		moving_test.playerMove=false;
		moving_test.not_key=2;
	}

	if(moving_test.x<=24) {
		moving_test.playerMove=false;
		moving_test.not_key=3;
	}

	if(moving_test.x>=596) {
		moving_test.playerMove=false;
		moving_test.not_key=4;
	}
	if(moving_test.y>=48&&moving_test.y<=484&&moving_test.x<=596&&moving_test.x>=24) {
		moving_test.not_key=0;
	}

		
	 
 }
}
