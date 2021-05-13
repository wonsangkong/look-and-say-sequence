package LASS;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder lastLine = new StringBuilder();
		StringBuilder currentLine = new StringBuilder();

		int input = 0;
		char num = '\0'; 
		char count = '1';
		int indexForNum = 0;
		
		System.out.println("최대 Deps를 지정하세요.(0, 음수 제외)");		
		input = sc.nextInt();
		
		System.out.println(input);
		
		lastLine.append("1");
		
		if(input > 0) {
			for(int depsCount = 0; depsCount < input; depsCount++) {
				if(lastLine.length() > 1) {
					for(int lastLineCount = 0; lastLineCount < lastLine.length(); lastLineCount++) {
						if(lastLine.charAt(lastLineCount) == lastLine.charAt(lastLineCount + 1)) {
							
							num = lastLine.charAt(indexForNum);
							count++;
							indexForNum++;
							lastLineCount++;
						}
						
						currentLine.append(num);
						currentLine.append(count);
					}
				} else {
					lastLine.append("1");
				}
					
				System.out.println(depsCount + 1 + " : " + currentLine);
				
				lastLine.setLength(0);
				lastLine.append(currentLine);
				currentLine.setLength(0);
			}			
		}
	
		sc.close();
	}

	
//	do {
//	count++;
//	indexForNum++;
//	lastLineCount++;
//} while(lastLine.charAt(lastLineCount) == lastLine.charAt(lastLineCount + 1));

//if(lastLine.charAt(lastLineCount) == lastLine.charAt(lastLineCount + 1)) {
//	count++;
//} else {
//	indexForNum++;
//}
}
