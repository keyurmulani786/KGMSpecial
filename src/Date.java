
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author keyur
 */
public class Date {

    public static void main(String[] args) throws ParseException {
        convertDateFormat();

    }

    public static String convertDateFormat() throws ParseException {
        String str = "1st mar 1984";
        String[] dateStr = str.split(" ");
        String day = dateStr[0].replaceAll("[^0-9]", "");
        String month = dateStr[1];
        String year = dateStr[2];
        System.out.println("day::" + day + " , month::" + month + " year::" + year);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        java.util.Date d = sdf.parse(day+"-"+month+"-"+year);
        sdf.applyPattern("yyyy-MM-dd");
        String output = sdf.format(d);
        System.out.println("out::"+output);
//        int year = 2003;
//        int month = 12;
//        int day = 12;
//
//        SimpleDateFormat sdfSource = new SimpleDateFormat("dd MM/yy");
//        Date date = sdfSource.parse("12/11/09");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
//        System.out.println(sdfDestination.format(date));
//        
//        
//        
//
//        String date = year + "/" + month + "/" + day;
//        java.util.Date utilDate = null;
//
//        try {
//            SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
//            utilDate = formatter.parse(date);
//            System.out.println("utilDate:" + utilDate);
//        } catch (ParseException e) {
//            System.out.println(e.toString());
//            e.printStackTrace();
//        }
        return null;

    }
}

package com.javacodegeeks.java.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPAddressFormatValidator{

    private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN = 
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IPAddressFormatValidator(){
	  pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

    public boolean validate(final String ipAddress){		  
	  matcher = pattern.matcher(ipAddress);
	  return matcher.matches();	    	    
    }
}




/******************************************************************************
 *  Compilation:  javac Parentheses.java
 *  Execution:    java Parentheses < file.txt
 *  Dependencies: StdIn.java Stack.java
 *
 *  Reads in a text file and checks to see if the paretheses, curly
 *  braces, and square brackets are balanced.
 *
 *  % java  java Parentheses
 *  [()]{}{[()()]()}
 *  true
 *
 *  % java Parentheses
 *  [(])
 *  false
 *
 ******************************************************************************/

public class Parentheses {
    private static final char L_PAREN    = '(';
    private static final char R_PAREN    = ')';
    private static final char L_BRACE    = '{';
    private static final char R_BRACE    = '}';
    private static final char L_BRACKET  = '[';
    private static final char R_BRACKET  = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {

            if      (s.charAt(i) == L_PAREN)   stack.push(L_PAREN);

            else if (s.charAt(i) == L_BRACE)   stack.push(L_BRACE);

            else if (s.charAt(i) == L_BRACKET) stack.push(L_BRACKET);

            else if (s.charAt(i) == R_PAREN) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_PAREN) return false;
            }

            else if (s.charAt(i) == R_BRACE) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACE) return false;
            }

            else if (s.charAt(i) == R_BRACKET) {
                if (stack.isEmpty())        return false;
                if (stack.pop() != L_BRACKET) return false;
            }

            // ignore all other characters

        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        String s = StdIn.readAll();
        System.out.println(isBalanced(s));
    }

}


Copyright © 2000–2011, Robert Sedgewick and Kevin Wayne. 
Last updated: Tue Aug 4 11:38:32 EDT 2015.