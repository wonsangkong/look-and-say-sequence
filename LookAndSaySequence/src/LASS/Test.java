package LASS;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		/**
		
		Look And Say Sequence Coding Test [공원상]
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
		
		Scanner sc = new Scanner(System.in); // Scanner를 통해 사용자로부터 DEPS 값을 받아옵니다.
		int deps = 0;
		
		System.out.println("deps 크기를 지정해주세요.(0 이하의 숫자 제외)");		
		deps = sc.nextInt();
		sc.close();

		StringBuilder lastDepsLine = new StringBuilder(); // 마지막 DEPS를 담는 StringBuilder입니다.
		StringBuilder currentDepsLine = new StringBuilder(); // 현재 DEPS를 담는 StringBuilder입니다.
		StringBuilder sameNumber = new StringBuilder(); // 중복되는 수의 최종 개수를 length로 가져오기 위한 StringBuilder입니다.
		
		char identify = '\0'; // '숫자가 몇 개 있다'에서 숫자를 담기 위한 변수입니다.
		
		for(int cycle = 0; cycle < deps; cycle++) { // cycle은 사용자가 입력한 DEPS의 반복 횟수입니다.
			if(cycle == 0) {
				currentDepsLine.append('1'); // 첫 Cycle이 진행되었을 때 1을 출력합니다.
			}
			
			if(cycle == 1) { // 두 번째 Cycle이 진행되었을 때 11을 출력합니다.(하단 for문의 index 초과 Exception을 피하기 위함입니다.)
				currentDepsLine.append('1');
				currentDepsLine.append('1');
			}
			
			if(cycle > 1) {
				for(int i = 0; i < lastDepsLine.length(); i++) { // Last DEPS Line을 읽기 위한 for문입니다.
					if(i == 0) {
						currentDepsLine.append(lastDepsLine.charAt(0)); // DEPS의 가장 첫 수는 1이어야 하기 때문입니다.
					} else {
						if(lastDepsLine.charAt(i-1) == lastDepsLine.charAt(i)) {
							sameNumber.append('s'); // length()만 사용할 것이기 때문에 append 내용은 상관이 없었습니다. 
							
							if(i == lastDepsLine.length()-1) {
								currentDepsLine.append(sameNumber.length()+1); // length에 +1은 sameNumber.length()가 0에서 시작하기 때문입니다.
							}
						} 
						
						if(lastDepsLine.charAt(i-1) != lastDepsLine.charAt(i)) {
							currentDepsLine.append(sameNumber.length()+1); // 중복이 끝나면 그 숫자를 append 해줍니다.
							identify = lastDepsLine.charAt(i); // 바로 뒤에 다음 숫자를 append 해줍니다.
							currentDepsLine.append(identify);
							
							sameNumber.setLength(0); // identify가 최종적으로 하나가 남았을 때 append 해주기 위해 sameNumber를 초기화 합니다.
							
							if(i == lastDepsLine.length()-1) {
								currentDepsLine.append(sameNumber.length()+1); // 최종적으로 남은 identify의 개수를 append 합니다.
							}
						}
					}
				}
			}
			
			System.out.println(cycle + 1 + "번 Deps : " + currentDepsLine); // 현재 DEPS를 출력합니다.
			
			lastDepsLine.setLength(0); // Last DEPS StringBuilder를 초기화합니다.
			lastDepsLine.append(currentDepsLine); // 다음 Cycle을 위해 현재 DEPS를 Last DEPS에 append 합니다.
			currentDepsLine.setLength(0); // 다음 Cycle에서 새로 append 하기 위해 append가 끝난 현재 DEPS를 초기화 합니다.
			sameNumber.setLength(0); // 다음 사용을 위해 초기화 합니다.
		}
	}
}