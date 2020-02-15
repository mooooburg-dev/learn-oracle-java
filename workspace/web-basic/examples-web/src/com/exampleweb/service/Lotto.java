package com.exampleweb.service;

public class Lotto {

	public int[] selectGoldenNumbers() {

		int[] numbers = null;
		int average = 0;
		do {
			numbers = selectBasicNumbers();
			
			average = calculateMean(numbers);
			
		} while (average < 20 || average > 26);//3. 평균 검사 (20 ~ 26, 실패하면 1부터 다시)
			
		return numbers;
	}
				
	
	public int[] selectBasicNumbers() {
		int[] numbers = new int[6];
		for (int i = 0; i < 6; i = i + 1) {
			numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45
			for (int j = 0; j < i; j = j + 1) {
				if (numbers[i] == numbers[j]) {
					//i = i - 1;//i의 위치를 감소시켜서 증감식의 증가 효과를 제거
					i = -1; //처음부터 다시 뽑기
				}
			}
		}
		return numbers;
	}
	
	public int calculateMean(int[] numbers) {
		int sum = 0; //각 숫자를 더하기 전에 기존에 저장된 값을 제거
		for (int i = 0; i < 6; i = i + 1) {
			sum = sum + numbers[i];
		}
		int average = sum / 6;
		
		return average;
	}

}

















