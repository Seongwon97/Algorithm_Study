/*
연산은  +, -, * 으로만 이루어진다.
연산 우선순위를 정하는데 동일한 우선순위를 가질 수는 없다.

연산을 하였을 때 음수면 절댓값으로 변환-> 결과가 가장 큰 값을 return하라

1. +, -, *의 모든 조합(6)번 test해야함. (함수를 구현)
2. expression이 string으로 주어지며 해당 String을 연산과 숫의 배열로 각각 나열해야함
3. 연산 => 값의 배열에서 연산자 위치, 연산자 위치+1에 해당하는 값들을 연산하면 된다.
*/

import java.util.*;
class Solution {
    public static long solution(String expression) {
        
    	// Expression을 숫자와 연산자를 따로 분리
        String express = expression.replaceAll("[*+-]"," ");
        System.out.println(express);
        
        ArrayList<Long> values = new ArrayList<>();
        for (int i: Arrays.stream(express.split(" ")).mapToInt(Integer::parseInt).toArray()){
        	values.add((long)i);
        }
        
        express = expression.replaceAll("[0-9]", "");
        ArrayList<Character> operators = new ArrayList<>();
        for (String i: express.split("")){
        	operators.add(i.charAt(0));
        }
        
        // 연산자의 우선순위 조합
        char[][] combination = {{'*','+','-'}, {'*','-','+'}, {'+','*','-'}, {'+','-','*'}, {'-','+','*'}, {'-','*','+'}};
        
        long max = -1;
        long result;

        for (char[] combi: combination) {
        	result = calculate(combi, values, operators);
        	if (result > max) max = result;
        	System.out.println(result);
        }
        
        return max;
    }
    
    public static long calculate(char[] operatorPriority, ArrayList<Long> values, ArrayList<Character> operators) {
        // values와 operators를 deep copy를 하며 복사본 생성
    	ArrayList<Long> valuesTemp = new ArrayList<>();
    	ArrayList<Character> operatorsTemp  = new ArrayList<>();;
		for (Long value: values) {
			valuesTemp.add(value);
		}
		for (char operator: operators) {
			operatorsTemp.add(operator);
		}
    	
    	int index = -1;
    	for (char c: operatorPriority) {
    		if (c =='*') {
    			while (operatorsTemp.contains('*')) {
    				index = operatorsTemp.indexOf('*'); 
    				valuesTemp.set(index, valuesTemp.get(index)*valuesTemp.get(index+1));
					valuesTemp.remove(index+1);
					operatorsTemp.remove(index);
    			}
    		}
    		else if (c == '+') {
    			while (operatorsTemp.contains('+')) {
    				index = operatorsTemp.indexOf('+'); 
    				valuesTemp.set(index, valuesTemp.get(index)+valuesTemp.get(index+1));
					valuesTemp.remove(index+1);
					operatorsTemp.remove(index);
    			}
    			
    		}
    		else if (c =='-') {
    			while (operatorsTemp.contains('-')) {
    				index = operatorsTemp.indexOf('-'); 
    				valuesTemp.set(index, valuesTemp.get(index)-valuesTemp.get(index+1));
					valuesTemp.remove(index+1);
					operatorsTemp.remove(index);
    			}
    		}
    	}
    	
    	return Math.abs(valuesTemp.remove(0));
    }
}
