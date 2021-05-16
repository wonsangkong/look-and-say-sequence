package LASS;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		/**
		
		Look And Say Sequence Coding Test [������]
		1
		11
		12
		1121
		122111
		112213
		12221131
		1123123111
		12213111213113
		11221131132111311231
		12221231123121133112213111 
		.
		.
		.
		
		[�ذ� ����]
		1. First Cycle���� 1�� ����Ѵ�.
		
		2. Second Cycle���� Last DEPS�� �������� �ҷ��� �д´�.
		
		3. �⺻���� ������ ���ڸ� �� ������ identify, �ߺ��Ǵ� ���ڸ� ��� ������ sameNumber�� �Ѵ�.
		
		4. �ݺ����� i�� 0�� ��� identify�� Last DEPS�� index(0)�� ��´�.(1�� ù ��°�� append �Ǿ�� �Ѵ�.)
		   > Current DEPS�� identify�� append.
		   
		   �ݺ��� �� ��°���� - Last DEPS�� ���� index(i) ���� ���� index(i+1) ���� �����ϸ� sameNumber�� �ƹ��ų� append,
		                   �������� ������ sameNumber�� length+1�� ���� ��(���� �������� ���� ��� sameNumber.length()�̱� ����.)
		                   Current DEPS�� sameNumber.length()�� append���ش�. �� identify�� index(i)�� append���ش�.
		
		5. DEPS Cycle�� ���� �������� Current DEPS�� ���, �� identify, sameNumber, Current DEPS �ʱ�ȭ�Ѵ�.
		   Last DEPS �ʱ�ȭ �� Current DEPS�� Last DEPS�� append�� �� �ʱ�ȭ�Ѵ�.
		   
		*/
		
		Scanner sc = new Scanner(System.in); // Scanner�� ���� ����ڷκ��� DEPS ���� �޾ƿɴϴ�.
		int deps = 0;
		
		System.out.println("deps ũ�⸦ �������ּ���.(0 ������ ���� ����)");		
		deps = sc.nextInt();
		sc.close();

		StringBuilder lastDepsLine = new StringBuilder(); // ������ DEPS�� ��� StringBuilder�Դϴ�.
		StringBuilder currentDepsLine = new StringBuilder(); // ���� DEPS�� ��� StringBuilder�Դϴ�.
		StringBuilder sameNumber = new StringBuilder(); // �ߺ��Ǵ� ���� ���� ������ length�� �������� ���� StringBuilder�Դϴ�.
		
		char identify = '\0'; // '���ڰ� �� �� �ִ�'���� ���ڸ� ��� ���� �����Դϴ�.
		
		for(int cycle = 0; cycle < deps; cycle++) { // cycle�� ����ڰ� �Է��� DEPS�� �ݺ� Ƚ���Դϴ�.
			if(cycle == 0) {
				currentDepsLine.append('1'); // ù Cycle�� ����Ǿ��� �� 1�� ����մϴ�.
			}
			
			if(cycle == 1) { // �� ��° Cycle�� ����Ǿ��� �� 11�� ����մϴ�.(�ϴ� for���� index �ʰ� Exception�� ���ϱ� �����Դϴ�.)
				currentDepsLine.append('1');
				currentDepsLine.append('1');
			}
			
			if(cycle > 1) {
				for(int i = 0; i < lastDepsLine.length(); i++) { // Last DEPS Line�� �б� ���� for���Դϴ�.
					if(i == 0) {
						currentDepsLine.append(lastDepsLine.charAt(0)); // DEPS�� ���� ù ���� 1�̾�� �ϱ� �����Դϴ�.
					} else {
						if(lastDepsLine.charAt(i-1) == lastDepsLine.charAt(i)) {
							sameNumber.append('s'); // length()�� ����� ���̱� ������ append ������ ����� �������ϴ�. 
							
							if(i == lastDepsLine.length()-1) {
								currentDepsLine.append(sameNumber.length()+1); // length�� +1�� sameNumber.length()�� 0���� �����ϱ� �����Դϴ�.
							}
						} 
						
						if(lastDepsLine.charAt(i-1) != lastDepsLine.charAt(i)) {
							currentDepsLine.append(sameNumber.length()+1); // �ߺ��� ������ �� ���ڸ� append ���ݴϴ�.
							identify = lastDepsLine.charAt(i); // �ٷ� �ڿ� ���� ���ڸ� append ���ݴϴ�.
							currentDepsLine.append(identify);
							
							sameNumber.setLength(0); // identify�� ���������� �ϳ��� ������ �� append ���ֱ� ���� sameNumber�� �ʱ�ȭ �մϴ�.
							
							if(i == lastDepsLine.length()-1) {
								currentDepsLine.append(sameNumber.length()+1); // ���������� ���� identify�� ������ append �մϴ�.
							}
						}
					}
				}
			}
			
			System.out.println(cycle + 1 + "�� Deps : " + currentDepsLine); // ���� DEPS�� ����մϴ�.
			
			lastDepsLine.setLength(0); // Last DEPS StringBuilder�� �ʱ�ȭ�մϴ�.
			lastDepsLine.append(currentDepsLine); // ���� Cycle�� ���� ���� DEPS�� Last DEPS�� append �մϴ�.
			currentDepsLine.setLength(0); // ���� Cycle���� ���� append �ϱ� ���� append�� ���� ���� DEPS�� �ʱ�ȭ �մϴ�.
			sameNumber.setLength(0); // ���� ����� ���� �ʱ�ȭ �մϴ�.
		}
	}
}