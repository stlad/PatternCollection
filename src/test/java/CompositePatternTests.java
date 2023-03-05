import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vaganov.StorageComponent;
import ru.vaganov.StorageComposite;
import ru.vaganov.StorageLeaf;



class LeafTests{
    @Test
    public void leafGetNameCorrect(){
        StorageLeaf pen = new Pen();
        Assertions.assertEquals("Pen", pen.getName());
    };

    @Test
    public void leafGetCustomNameCorrect(){
        StorageLeaf pen = new Pen("Super Pen");
        Assertions.assertEquals("Super Pen", pen.getName());
    }

    @Test
    public void leafHasNoChilds(){
        Pen pen = new Pen();
        Assertions.assertFalse(pen.hasChild());
    }

    @Test
    public void leafThorwsExceptionOnAdd(){
        StorageLeaf pen = new Pen();
        StorageComponent innerPen = new Pen();
        Assertions.assertThrows(Exception.class, ()->pen.add(innerPen));
    }

    @Test
    public void leafThorwsExceptionOnRemove(){
        StorageLeaf pen = new Pen();
        StorageComponent innerPen = new Pen();
        Assertions.assertThrows(Exception.class, ()->pen.remove(innerPen));
    }

}

class CompositeTests {

    @Test
    public void compositeGetName(){
        StorageComposite box = new Box();
        Assertions.assertEquals("Box", box.getName());
    }

    @Test
    public void compositeGetCusotomNameCorrect(){
        StorageComposite box = new Box("Super Box");
        Assertions.assertEquals("Super Box", box.getName());
    }


    @Test
    public void addWorksCorrect(){
        StorageComposite box = new Box();
        StorageLeaf pen1 = new Pen("Pen 1");
        box.add(pen1);
        Assertions.assertEquals(1, box.size());
        Assertions.assertEquals(pen1, box.getChild(0));
    }

    @Test
    public void getChildCorrect(){
        StorageComposite box = new Box();
        StorageLeaf pen1 = new Pen("Pen 1");
        StorageLeaf pen2 = new Pen("Pen 2");
        StorageLeaf pen3 = new Pen("Pen 3");
        StorageLeaf pen4 = new Pen("Pen 4");
        box.add(pen1);
        box.add(pen2);
        box.add(pen3);
        box.add(pen4);

        Assertions.assertEquals(4,box.size());
        Assertions.assertEquals(pen1, box.getChild(0));
        Assertions.assertEquals(pen2, box.getChild(1));
        Assertions.assertEquals(pen4, box.getChild(3));
        Assertions.assertThrows(IndexOutOfBoundsException.class,()-> box.getChild(-10));
        Assertions.assertThrows(IndexOutOfBoundsException.class,()-> box.getChild(5));
    }

    @Test
    public void getInnerCompositeWorks() throws Exception {

        StorageComposite box = new Box();
        StorageComposite innerbox = new Box();
        StorageLeaf pen1 = new Pen("Pen 1");
        StorageLeaf pen2 = new Pen("Pen 2");
        StorageLeaf pen3 = new Pen("Pen 3");

        box.add(pen1);
        box.add(pen2);
        box.add(innerbox);
        innerbox.add(pen3);

        Assertions.assertEquals(3, box.size());
        Assertions.assertEquals(1, innerbox.size());

        Assertions.assertEquals(innerbox, box.getChild(2));
        Assertions.assertEquals(pen1, box.getChild(0));
        Assertions.assertEquals(pen2, box.getChild(1));
        Assertions.assertEquals(pen3, box.getChild(2).getChild(0));

    }
}





public class CompositePatternTests {

}




class Pen extends StorageLeaf {
    private String name;
    public Pen(){
        name = this.getClass().getName();
    }
    public Pen(String name){
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }

}

class Box extends StorageComposite{

    private String name;
    public Box(){
        name = this.getClass().getName();
    }

    public Box(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }
}