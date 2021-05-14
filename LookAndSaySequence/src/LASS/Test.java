package LASS;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int deps = 0;
		
		System.out.println("최대 Deps를 지정하세요.(0, 음수 제외)");		
		deps = sc.nextInt();
		sc.close();

		StringBuilder pastDepsLine = new StringBuilder();
		StringBuilder currentDepsLine = new StringBuilder();
		StringBuilder sameNumber = new StringBuilder();
		
		char identify = '\0';
		
		if(deps > 0) {
			for(int cycle = 0; cycle < deps; cycle++) {
				if(cycle == 0) {
					identify = '1';
					currentDepsLine.append(identify);
				} else {
					for(int LDL = 0; LDL < pastDepsLine.length(); LDL++) { // Line Detail Loop
						sameNumber.setLength(0);
						
						if(LDL == 0) {
							identify = '1';
							currentDepsLine.append(identify);
							sameNumber.append(pastDepsLine.charAt(LDL));
						} else if(sameNumber.charAt(0) == pastDepsLine.charAt(LDL)) {
							sameNumber.append(pastDepsLine.charAt(LDL));
						} else {
							
						}
						
						currentDepsLine.append(sameNumber.length());
					}
				}
		
				System.out.println(currentDepsLine);
				
				pastDepsLine.setLength(0);
				pastDepsLine.append(currentDepsLine);
				currentDepsLine.setLength(0);
				
			}
		}
	}
}
