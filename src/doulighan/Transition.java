package doulighan;



public class Transition {

   protected final Pair pair;
   protected final String direction;

   public Transition(Pair p, String d) {
      pair = p;
      direction = d;
   }

   public String getState() {
      return pair.getState();
   }

   public String getSymbol() {
      return pair.getSymbol();
   }

   public String getDirection() {
      return direction;
   }
   
   public String toString() {
      return "[" + pair.toString() + "], Direction: " + direction;
   }
}
