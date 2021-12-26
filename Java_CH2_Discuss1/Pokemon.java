public class Pokemon {
    public String name;
    public int level;

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public static void main(String[] args) {
        Pokemon p = new Pokemon("Pikachu", 17);
        int level = 100;
        change(p, level);
        System.out.println("Name: " + p.name + ", Level: " + p.level);
    }
    
    /** 1.The parameter "poke" in the function change is a pointer pointing to p address. 
      * 2.First line will change the value of level to 100. 
      * 3.Second line is a local variable, so not change anything outside. 
      * 4.Last line assign poke this pointer to an real object, so poke will allocate 
      *   memory different from origin p that is "two object". 
      * 
      * (Using this link to see the details in java visualizer: 
      *  https://cscircles.cemc.uwaterloo.ca/java_visualize/#code=public+class+Pokemon+%7B%0A++++public+String+name%3B%0A++++public+int+level%3B%0A%0A++++public+Pokemon(String+name,+int+level)+%7B%0A++++++++this.name+%3D+name%3B%0A++++++++this.level+%3D+level%3B%0A++++%7D%0A%0A++++public+static+void+main(String%5B%5D+args)+%7B%0A++++++++Pokemon+p+%3D+new+Pokemon(%22Pikachu%22,+17)%3B%0A++++++++int+level+%3D+100%3B%0A++++++++change(p,+level)%3B%0A++++++++System.out.println(%22Name%3A+%22+%2B+p.name+%2B+%22,+Level%3A+%22+%2B+p.level)%3B%0A++++%7D%0A++++%0A++++public+static+void+change(Pokemon+poke,+int+level)+%7B%0A++++++++poke.level+%3D+level%3B%0A++++++++level+%3D+50%3B%0A++++++++poke+%3D+new+Pokemon(%22Gengar%22,+1)%3B%0A++++%7D%0A%7D&mode=display&curInstr=0&showStringsAsObjects=1)
      * */
    public static void change(Pokemon poke, int level) {
        poke.level = level;
        level = 50;
        poke = new Pokemon("Gengar", 1);
    }
}