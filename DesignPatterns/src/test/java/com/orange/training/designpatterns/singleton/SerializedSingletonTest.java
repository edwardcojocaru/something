package com.orange.training.designpatterns.singleton;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Edward
 * Date: 27.10.2013
 * Time: 22:58
 * To change this template use File | Settings | File Templates.
 */
public class SerializedSingletonTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(SerializedSingletonTest.class);

    private SerializedSingleton serializedSingleton;

    @Before
    public void init() {
        this.serializedSingleton = SerializedSingleton.getInstance();
    }

    @Test
    public void testGetInstance() throws Exception {

        SerializedSingleton unserializedSingleton = getSerializedSingleton(serializedSingleton);

        assertTrue(serializedSingleton == unserializedSingleton);
    }

    private <T extends Serializable> T getSerializedSingleton(T object) throws IOException, ClassNotFoundException {

        String name = object.getClass().getSimpleName() + ".ser";
        LOGGER.info("Serializing object in: " + name);
        FileOutputStream fileOutputStream = new FileOutputStream(name);
        ObjectOutputStream out = new ObjectOutputStream(fileOutputStream);

        out.writeObject(object);
        out.close();
        fileOutputStream.close();

        LOGGER.info("Object serialization done.");
        LOGGER.info("De-serializing object from: " + name);
        FileInputStream inputStream = new FileInputStream(name);
        ObjectInputStream in = new ObjectInputStream(inputStream);

        Object unserializedSingleton = in.readObject();
        fileOutputStream.close();

        File file = new File(name);
        if (file.exists()) {
            LOGGER.debug("Deleting temporary file: " + name);
            file.delete();
        }

        return (T)unserializedSingleton;
    }

    @Test
    public void testGetSimpleInstance() throws Exception {

        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();

        SimpleSingleton unserializedObject = getSerializedSingleton(simpleSingleton);

        assertFalse(simpleSingleton == unserializedObject);
    }
}
