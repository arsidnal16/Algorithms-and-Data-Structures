package p2;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;
/**
 *
 * @author Rachan Hegde
 */
public class Assignment1Test {
    public static void main(String[] args) throws FileNotFoundException, IOException {
      Assignment1Solution soln = new Assignment1Solution();
      
         
      /**
       * LOAD INPUT FILE HERE
       */
      Path path = Paths.get(".");
      String inputFile = readFile(path.toAbsolutePath() + "/src/p2/Cook.java");
     // System.out.println(inputFile);
      if (soln.validateClass(inputFile)) {
            System.out.println("Its a valid Java Class File"); 
            printFileStats(inputFile);
        } else {
            System.out.println("Its not a valid Java Class File"); 
        }
      
      
    }
 

    private static void printFileStats(String inputFile) {
    	
    	int comment= 0;
    	String transfile = "";
        for (int i = 0; i < inputFile.length(); i++) {
        	
        	if(inputFile.charAt(i)== '/' && inputFile.charAt(i+1)=='*'){
        		comment=1;
        		continue;
        	}
        	if(comment == 1){
	        	 if (inputFile.charAt(i)=='/' && inputFile.charAt(i-1) == '*'){
	        		comment = 0;
	        	 }
        	}
        	
        	if(comment==0){
        		transfile += inputFile.charAt(i);
        		
        	}
        }
    	StringTokenizer st = new StringTokenizer(transfile,":,<>*;=_})]{([+//.-''\n \t  !@ \r \f \t\n\r\f% && \" " );
    	
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	HashMap<String, Integer> keywords_List = new HashMap<String, Integer>();

        keywords_List.put("abstract", 0); 
        keywords_List.put("continue", 0);
        keywords_List.put("for", 0); 
        keywords_List.put("new", 0); 
        keywords_List.put("switch", 0);
        keywords_List.put("assert", 0);
        keywords_List.put("default", 0);
        keywords_List.put("goto", 0);
        keywords_List.put("package", 0);
        keywords_List.put("synchronized", 0);
        keywords_List.put("boolean", 0);
        keywords_List.put("do", 0);
        keywords_List.put("if", 0);
        keywords_List.put("private", 0);
        keywords_List.put("this", 0);
        keywords_List.put("break", 0);
        keywords_List.put("double", 0);
        keywords_List.put("implements", 0);
        keywords_List.put("protected", 0);
        keywords_List.put("throw", 0);
        keywords_List.put("byte", 0);
        keywords_List.put("else", 0);
        keywords_List.put("import", 0);
        keywords_List.put("public", 0);
        keywords_List.put("throws", 0);
        keywords_List.put("case", 0);
        keywords_List.put("enum", 0);
        keywords_List.put("instanceof", 0);
        keywords_List.put("return", 0);
        keywords_List.put("transient", 0);
        keywords_List.put("catch", 0);
        keywords_List.put("extends", 0);
        keywords_List.put("int", 0);
        keywords_List.put("short", 0);
        keywords_List.put("try", 0);
        keywords_List.put("char", 0);
        keywords_List.put("final", 0);
        keywords_List.put("interface", 0);
        keywords_List.put("static", 0);
        keywords_List.put("void", 0);
        keywords_List.put("class", 0);
        keywords_List.put("finally", 0);
        keywords_List.put("long", 0);
        keywords_List.put("strictfp", 0);
        keywords_List.put("volatile", 0);
        keywords_List.put("const", 0);
        keywords_List.put("float", 0);
        keywords_List.put("native", 0);
        keywords_List.put("super", 0);
        keywords_List.put("while", 0);

        //Pattern p = Pattern.compile(".+\\s(.+?)(;|=)");
    	//Matcher m = p.matcher(inputFile);

    	//while(m.find()){
        
        
    		while (st.hasMoreTokens()) {
    			
    			
    			//System.out.println(st.nextToken());
    			String token = st.nextToken();
    			
    			token.toLowerCase();
    			if(keywords_List.containsKey(token)){
    				keywords_List.put(token, keywords_List.get(token) + 1);    				
    			}else{
    				int isNumeric = 1;
    				/// ABCD1
    				/// 1234
    				/// 123A
    				for (char c : token.toCharArray()) {
    			        if (!Character.isDigit(c)){
    			        	isNumeric = 0;
    			        	break;
    			        }
    				}
    			    if(isNumeric == 0){       
	    				if(map.containsKey(token)){
	    					map.put(token, map.get(token) + 1);
	    				}
	    				else{
	    					map.put(token, 1);
	    				}
    			    }
    			}
    		}
    	        
    	
    	
    	
    	//System.out.println("Identifiers - "+map.toString());
    		System.out.println("IDENTIFIERS - " +map.size() +" "+"OCCURENCES");
    		
    		for(String k : map.keySet()){
        		
        		System.out.println(k+"="+map.get(k));
        		}
    		
    		System.out.println("---------------------------------");
    	System.out.println("KEYWORDS - "+keywords_List.size() +" "+"OCCURENCES");
    	for(String k : keywords_List.keySet()){
    		if(keywords_List.get(k) > 0){
    		System.out.println(k+"="+keywords_List.get(k));
    		}
    	}
    	
        /**
         * TODO -- implement this
         */
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * DO NOT CHANGE THIS
     * @param fileName
     * @return
     * @throws IOException 
     */
    
    public static String readFile(String fileName) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    try {
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = br.readLine();
        }
        return sb.toString();
    } finally {
        br.close();
    }
}
}