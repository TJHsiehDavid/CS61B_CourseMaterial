public class Cat {
   public String name;
   public static String noise;

   public Cat(String name, String noise) {
      this.name = name;
      this.noise = noise;
   }

   public void play() {
      System.out.println(noise + " I'm " + name + " the cat!");
   }

   public static void anger() {
      noise = noise.toUpperCase();
   }
   public static void calm() {
      noise = noise.toLowerCase();
   }
   
   /** 1.a and b are object.
     * 2.Play() only display the noise instead of using particular object since noise is static,
     *   so it save the last value of b object.
     * 3.Fifth line also used the noise store from static method that is second line which b 
     *   modify the value.
     * 
     * (Using this link to know the details:)
     *  https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+Cat+%7B%0A+++public+String+name%3B%0A+++public+static+String+noise%3B%0A%0A+++public+Cat(String+name,+String+noise)+%7B%0A++++++this.name+%3D+name%3B%0A++++++this.noise+%3D+noise%3B%0A+++%7D%0A%0A+++public+void+play()+%7B%0A++++++System.out.println(noise+%2B+%22+I'm+%22+%2B+name+%2B+%22+the+cat!%22)%3B%0A+++%7D%0A%0A+++public+static+void+anger()+%7B%0A++++++noise+%3D+noise.toUpperCase()%3B%0A+++%7D%0A+++public+static+void+calm()+%7B%0A++++++noise+%3D+noise.toLowerCase()%3B%0A+++%7D%0A+++%0A+++public+static+void+main(String%5B%5D+args)+%7B%0A++++++Cat+a+%3D+new+Cat(%22Cream%22,+%22Meow!%22)%3B%0A++++++Cat+b+%3D+new+Cat(%22Tubbs%22,+%22Nyan!%22)%3B%0A++++++a.play()%3B%0A++++++b.play()%3B%0A++++++Cat.anger()%3B%0A++++++a.calm()%3B%0A++++++a.play()%3B%0A++++++b.play()%3B%0A+++%7D%0A%7D&mode=display&showStringsAsObjects=1&curInstr=0)
     * */
   public static void main(String[] args) {
      Cat a = new Cat("Cream", "Meow!");
      Cat b = new Cat("Tubbs", "Nyan!");
      a.play();
      b.play();
      Cat.anger();
      a.calm();
      a.play();
      b.play();
   }
}