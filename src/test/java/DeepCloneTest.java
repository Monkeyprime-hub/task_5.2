import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeepCloneTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeepCloneTest.class);

    ArrayList<Person> list = new ArrayList<>();
    Person person = new Person("Vasya", 13);
    String str = "Hello ! ! !";
    String strExpected = "Hello ! ! !";


    @Before
    public void createObjects() {
        Person person_1 = new Person("Vasya", 14);
        Person person_2 = new Person("Petya", 115);
        Person person_3 = new Person("Nastya", 23);

        list.add(person_1);
        list.add(person_2);
        list.add(person_3);
    }


    @Test
    public void deepCopyPersonTest() throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone();
        Object copyPerson = deepClone.deepCopy(person);
        Assert.assertEquals(person, copyPerson);
        LOGGER.info("expected: " + person + "\n" + "result:         " + copyPerson);
//        if (copy_1.equals(copy_1)) {
//            System.out.println("true");
//        }
    }

    @Test
    public void deepCopyListTest() throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone();
        Object copyListPersons = deepClone.deepCopy(list);
        Assert.assertEquals(list, copyListPersons);
        LOGGER.info("expected: " + list + "\n" + "result:         " + copyListPersons);
//        if (copyList_1.equals(list)) {
//            System.out.println("true");
//        }
    }

    @Test
    public void deepCopyStringTest() throws IOException, ClassNotFoundException {
        DeepClone deepClone = new DeepClone();
        Object strResult = deepClone.deepCopy(str);
        Assert.assertEquals(this.strExpected, strResult);
        LOGGER.info("expected: " + strExpected + "\n" + "result:         " + strResult);
//        if (str.equals(str_1)) {
//            System.out.println("true");
//        }
    }
}