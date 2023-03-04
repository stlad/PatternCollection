import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import ru.vaganov.StorageLeaf;

import java.security.Permission;

public class CompositeTests {

    @Test
    public void leafGetNameCorrect(){
        StorageLeaf pen = new Pen();
        Assertions.assertEquals("Pen", pen.getName());
        }

}
class Pen extends StorageLeaf {
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}