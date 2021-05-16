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
		12221231123121133112213111 너무 많다..
		.
		.
		.

		[해결 순서]

		1. First Cycle에서 1을 출력한다.
		
		2. Second Cycle부터 Last DEPS의 수열들을 불러와 읽는다.
		
		3. 기본으로 가지는 숫자를 담 변수를 identify, 중복되는 숫자를 담는 변수를 sameNumber로 한다.
		
		4. 반복문의 i가 0일 경우 identify에 Last DEPS의 index(0)를 담는다.(1은 첫 번째에 append 되어야 한다.)
		   > Current DEPS에 identify를 append.
		   
		   반복문 두 번째부터 - Last DEPS의 현재 index(i) 값이 다음 index(i+1) 값과 동일하면 sameNumber에 아무거나 append,
		                   동일하지 않으면 sameNumber의 length+1을 해준 뒤(값이 동일하지 않을 경우 sameNumber.length()이기 때문.)
		                   Current DEPS에 sameNumber.length()를 append해준다. 후 identify에 index(i)를 append해준다.
		
		5. DEPS Cycle의 가장 마지막에 Current DEPS를 출력, 후 identify, sameNumber, Current DEPS 초기화한다.
		   Last DEPS 초기화 후 Current DEPS를 Last DEPS에 append한 후 초기화한다.
		   
		
		*/
		
		// DEPS 길이를 사용자로부터 받아온다.
		Scanner sc = new Scanner(System.in);
		int deps = 0;
		
		System.out.println("deps 크기를 지정해주세요.(0 이하의 숫자 제외)");		
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
						sameNumber.append('s'); // 어차피 length 로 쓸 거라서 append 값은 상관 없음
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