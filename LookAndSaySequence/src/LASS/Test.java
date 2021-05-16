package LASS;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		/**
		
		Look And Say Sequence Coding Test 

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
		12221231123121133112213111 �ʹ� ����..
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
		
		// DEPS ���̸� ����ڷκ��� �޾ƿ´�.
		Scanner sc = new Scanner(System.in);
		int deps = 0;
		
		System.out.println("deps ũ�⸦ �������ּ���.(0 ������ ���� ����)");		
		deps = sc.nextInt();
		sc.close();

		StringBuilder lastDepsLine = new StringBuilder();
		StringBuilder currentDepsLine = new StringBuilder();
		StringBuilder sameNumber = new StringBuilder();
		
		char identify = '\0';
		
		for(int cycle = 0; cycle < deps; cycle++) {
			if(cycle == 0) {
				currentDepsLine.append('1');
			}
			
			if(cycle == 1) {
				currentDepsLine.append('1');
				currentDepsLine.append('1');
			}
			
			if(cycle > 1) {
				for(int i = 0; i < lastDepsLine.length(); i++) {
					if(i == 0) {
						currentDepsLine.append(lastDepsLine.charAt(0));
					}
					
					if(i != 0 && lastDepsLine.charAt(i-1) == lastDepsLine.charAt(i)) {
						sameNumber.append('s'); // ������ length �� �� �Ŷ� append ���� ��� ����
					} else {
						currentDepsLine.append(sameNumber.length()+1);
						identify = lastDepsLine.charAt(i);
						currentDepsLine.append(identify);
					}
				}
			}
			
			System.out.println(currentDepsLine);
			
			lastDepsLine.setLength(0);
			lastDepsLine.append(currentDepsLine);
			currentDepsLine.setLength(0);
			sameNumber.setLength(0);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		if(deps > 0) {
//			for(int cycle = 0; cycle < deps; cycle++) {
//				if(cycle == 0) {
//					identify = '1';
//					currentDepsLine.append(identify);
//				} else {
//					for(int LDL = 0; LDL < pastDepsLine.length(); LDL++) { // Line Detail Loop
//						sameNumber.setLength(0);
//						
//						if(LDL == 0) {
//							identify = '1';
//							currentDepsLine.append(identify);
//							sameNumber.append(pastDepsLine.charAt(LDL));
//						} else if(sameNumber.charAt(0) == pastDepsLine.charAt(LDL)) {
//							sameNumber.append(pastDepsLine.charAt(LDL));
//						} else {
//							
//						}
//						
//						currentDepsLine.append(sameNumber.length());
//					}
//				}
//		
//				System.out.println(currentDepsLine);
//				
//				pastDepsLine.setLength(0);
//				pastDepsLine.append(currentDepsLine);
//				currentDepsLine.setLength(0);
//				
//			}
//		}
	}
}