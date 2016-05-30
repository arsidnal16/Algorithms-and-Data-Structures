package p2;

import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rachan Hegde
 */
public class Assignment1Solution {
	
	
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
  
    
    public static boolean validateClass(String s){
    	Stack<Character> stack = new Stack<Character>();
    	int comment= 0;
        for (int i = 0; i < s.length(); i++) {
        	
        	if(s.charAt(i)== '/' && s.charAt(i+1)=='*'){
        		comment=1;
        		continue;
        	}
        	if(comment == 1){
	        	 if (s.charAt(i)=='/' && s.charAt(i-1) == '*'){
	        		comment = 0;
	        	 }
        	}
        	
        	if(comment==0){
	            if (s.charAt(i) == L_BRACE){
	            	stack.push(L_BRACE);
	            } else if (s.charAt(i) == R_BRACE) {
	                if (stack.isEmpty()){
	                	return false;
	                }
	                else stack.pop();
	            }
        	}
        }
        return stack.isEmpty();
    }

}