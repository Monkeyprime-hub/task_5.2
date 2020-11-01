import java.io.*;

public class DeepClone {


    public Object deepCopy(Object obj) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        ObjectOutputStream os = new ObjectOutputStream(buf);
        os.writeObject(obj);
        // получаем копии:
        ObjectInputStream in = new ObjectInputStream(
                new ByteArrayInputStream(buf.toByteArray()));
        return in.readObject();
    }
}