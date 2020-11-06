public class Life implements ILife {

  boolean[][] generations = null;

  public static void main(String[] args) {
    Life l = new Life(new String[] { ".....", ".....", ".***.", ".....", "....." });
    l = (Life) l.nextGeneration();
  }

  public Life() {
    nukeAll();
  }

  public Life(String[] setup) {
    this();
    generations = new boolean[setup.length][setup[0].length()];
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != '.')
          setAlive(x, y);
        else
          setDead(x, y);

  }

  public Life(boolean[][] nextGeneration){
    this();
    generations = nextGeneration;
  }

  @Override
  public void nukeAll() {
    // TODO Auto-generated method stub
    if (generations == null)
      return;
    for (int y = 0; y < generations.length; y++) {
      int lineLength = generations[y].length;
      for (int x = 0; x < lineLength; x++) {
        generations[x][y] = false;
      }
    }
  }

  @Override
  public void setAlive(int x, int y) {
    // TODO Auto-generated method stub
    generations[x][y] = true;

  }

  @Override
  public void setDead(int x, int y) {
    // TODO Auto-generated method stub
    generations[x][y] = false;

  }

  @Override
  public boolean isAlive(int x, int y) {
    // TODO Auto-generated method stub
    if (y < 0 || x < 0)
      return false;
    if (y >= generations.length || x >= generations[0].length) {
      return false;
    }
    return generations[x][y];
  }

  @Override
  public ILife nextGeneration() {
    boolean[][] nextGeneration = new boolean[generations.length][generations[0].length];
    for (int y = 0; y < generations.length; y++) {
      int lineLength = generations[y].length;
      for (int x = 0; x < lineLength; x++) {
        int num = numLivingNeighbours(x, y);
        if (isAlive(x, y)) {
         
          if (num == 2 || num == 3)
            nextGeneration[x][y] = true;
          else
            nextGeneration[x][y] = false;
        }else{
          if(num == 3)
            nextGeneration [x][y] = true;
          else
            nextGeneration [x][y] = false;
          
        }
      }
    }
    return null;
  }

  public int numLivingNeighbours(int x, int y) {
    int counter = 0;
    if (isAlive(x, y - 1))
      counter++;
    if (isAlive(x + 1, y - 1))
      counter++;
    if (isAlive(x + 1, y))
      counter++;
    if (isAlive(x + 1, y + 1))
      counter++;
    if (isAlive(x, y + 1))
      counter++;
    if (isAlive(x - 1, y + 1))
      counter++;
    if (isAlive(x - 1, y))
      counter++;
    if (isAlive(x - 1, y - 1))
      counter++;
    return counter;
  }
}