package doulighan;

import java.util.Stack;

public class Tape {

   private final String TAPE0;
   private final String REGEX;
   private final String BLANK = "_";
   // private final String RIGHT = ">";
   // private final String LEFT = "<";

   private Stack<String> right = new Stack<String>();
   private Stack<String> left = new Stack<String>();
   private String current;

   
   public Tape(String[] input) {
      TAPE0 = input[0];
      REGEX = "[^" + input[1] + BLANK + "]+";
      for (int i = TAPE0.length() - 1; i >= 0; i--) {
         String c = String.valueOf(TAPE0.charAt(i));
         right.push(c);
      }
      current = right.pop();
   }

   public void scroll(String direction) {
      if (direction.equals(">")) {
         headRight();
      } else if (direction.equals("<")) {
         headLeft();
      } else {
         System.out.println("!!!scrolling error");
         System.exit(-1);
      }
   }

   private void headLeft() {
      right.push(current);
      if (left.empty()) {
         current = BLANK;
      } else {
         current = left.pop();
      }
   }

   private void headRight() {
      left.push(current);
      if (right.empty()) {
         current = BLANK;
      } else {
         current = right.pop();
      }
   }

   public int size() {
      return right.size() + left.size() + 1;
   }

   public String read() {
      return current;
   }

   public void write(String s) {
      current = s;
   }
/*
   public String pad(int n) {
      String pad = "";
      for (int i = 0; i < n; i++) {
         pad += BLANK;
      }
      return pad;
   }
*/
   public static String padRight(String s, int n) {
      return String.format("%1$-" + n + "s", s);
   }

   public static String padLeft(String s, int n) {
      return String.format("%1$" + n + "s", s);
   }

   public String toString() {
      int n = 26 - (right.size() + 1);
      String leftPad = left.toString().replaceAll(REGEX, "");
      String rightPad =
            new StringBuilder(right.toString().replaceAll(REGEX, "")).reverse().toString();
      String a =
            String.format(String.format("%40s", leftPad) + "[" + current + "]" + String
                  .format("%-40s", rightPad)).replace(' ', BLANK.charAt(0));
      return a;

   }

}
