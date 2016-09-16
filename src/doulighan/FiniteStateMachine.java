package doulighan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FiniteStateMachine {

   private final Map<Pair, Transition> INSTRUCTIONS;
   private String haltState;
   private String currentState;


   public FiniteStateMachine(String[] file) {
      currentState = file[3];
      haltState = file[4];
      INSTRUCTIONS = constructTable(file);
   }

   public Transition tick(String symbol) {
      if(!currentState.equals(haltState)) {
         Transition function = INSTRUCTIONS.get(new Pair(currentState, symbol));
         currentState = function.getState();
         return function;
      }
         return null;
   }


   public Map<Pair, Transition> constructTable(String[] input) {
      Map<Pair, Transition> map = new HashMap<Pair, Transition>();
      for (int i = 5; i < input.length; i++) {
         String left = input[i].split(" = ")[0];
         String right = input[i].split(" = ")[1];
         Pair a = new Pair(left.split(" ")[0], left.split(" ")[1]);
         Pair b = new Pair(right.split(" ")[0], right.split(" ")[1]);
         String d = right.split(" ")[2];
         Transition t = new Transition(b, d);
         map.put(a, t);
         // System.out.println("KEY:[" + a.toString() + "] VALUE:[" + t.toString() + "]");
      }
      return Collections.unmodifiableMap(map);
   }

   public String getCurrentState() {
      return currentState;
   }

   public String getHaltState() {
      return haltState;
   }

   public void setCurrentState(String state) {
      currentState = state;
   }

}
