package jpa.spi;

import javax.persistence.spi.PersistenceProvider;
import java.util.Iterator;
import java.util.ServiceLoader;

public class Main {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Iterator<PersistenceProvider> iterator = ServiceLoader.load(PersistenceProvider.class, loader).iterator();
    }
}
