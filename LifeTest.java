import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));
    }


    @Test
    public void destroyLonelyCell() {
       // Arrange: zwei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit einem Nachbarn sollte jetzt nicht mehr leben
        assertTrue(!nextGen.isAlive(0, 1));
    }


    @Test
    public void keepAliveCell() {
       // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit zwei Nachbarn sollte leben
        assertTrue(nextGen.isAlive(0, 1));
    }


    @Test
    public void destroyCrowdedCell() {
       // Arrange: fünf lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);
        l.setAlive(1, 0);
        l.setAlive(1, 1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit vier Nachbarn sollte jetzt nicht mehr leben
        assertTrue(!nextGen.isAlive(0, 1));
    }


}
