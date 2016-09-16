package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import doulighan.FiniteStateMachine;
import doulighan.Tape;
import doulighan.Transition;

public class UniversalTuringMachine {
  
   private Tape tape;
   private FiniteStateMachine machine;
   
   public UniversalTuringMachine(File file){
         String[] input = readFile(file);
         machine = new FiniteStateMachine(input);
         tape = new Tape(input);
   }
   
   public void simulate() {
      Transition function = machine.tick(tape.read());
      while(function != null) {
         System.out.println(tape.toString());
         tape.write(function.getSymbol());
         tape.scroll(function.getDirection());
         function = machine.tick(tape.read());
      }
      System.out.println(tape.toString());
      System.out.println("FUNC NULL");
   }
   
   private static String[] readFile(File file) {
      Scanner count = null;
      Scanner read = null;
      try {
         count = new Scanner(file);
         read = new Scanner(file);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
         System.exit(-1);
      }
      int numLines = 0;
      while (count.hasNextLine()) {
         numLines++;
         count.nextLine();
      }
      count.close();
      String[] lines = new String[numLines];
      for (int i = 0; i < lines.length; i++) {
         lines[i] = read.nextLine();
      }
      read.close();
      return lines;
   }
   
   public static void main(String[] args) {
         File input1 = new File("C:/Users/Devin/workspace/input_files/turing_input.txt");
         File input2 = new File("C:/Users/Devin/workspace/input_files/turing_input2.txt");
         UniversalTuringMachine turing = new UniversalTuringMachine(input1);
         turing.simulate();
         turing = new UniversalTuringMachine(input2);
         turing.simulate();     
   }
   
}
