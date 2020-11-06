public class Life implements ILife {
  public static final int ZELLENANZAHL = 600;
  public static boolean[][] zelle = new boolean[ZELLENANZAHL][ZELLENANZAHL];
  int startzellen = 100;
  static int gen = 0;
  
  public static void main(String[] args) {
    Life l = new Life(new String[] {  ".....",
                                      ".....",
                                      ".***.",
                                      ".....",
                                      "....." });
    l = (Life) l.nextGeneration();
  }


  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != '.')
          setAlive(x, y);
  }


  @Override
  public void nukeAll() {
  

  }

  @Override
  public void setAlive(int x, int y) {
    if (neighbours(x, y)==3 && !zelle[x][y]){
      zelle[x][y] = true;
    }
  }

  @Override
  public void setDead(int x, int y) {
    if(neighbours(x, y)>3){
      zelle [x][y] = false;
    }

  }

  @Override
  public boolean isAlive(int x, int y) {
    if(neighbours(x, y)==2 || neighbours(x, y)==3){
      //Zelle bleibt unverändert
    }
    return false;
  }

  @Override
  public ILife nextGeneration() {
    gen++;
    System.out.println("Generation "+ gen);

    for(int x=0; x<ZELLENANZAHL; x++){
      for(int y=0; y<ZELLENANZAHL; y++){
        int n = neighbours(x, y);
      }
    }
    return null;
  }

  public static int neighbours(int x, int y){
    int count = 0;

    int[] xoff = {1,1,0,-1,-1,-1,0,1};
    int[] yoff = {0,1,1,1,0,-1,-1,-1};

    for(int i=0; i<8; i++){
      try{
        if(zelle[x+xoff[i]][y+yoff[i]]){ count++;}
      }catch(Exception e){
        e.printStackTrace();
      }
    }
    return count;
  }
}