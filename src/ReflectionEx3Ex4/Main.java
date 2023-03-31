package ReflectionEx3Ex4;

import ReflectionEx3Ex4.interfaces.Repository;
import ReflectionEx3Ex4.interfaces.Runnable;
import ReflectionEx3Ex4.interfaces.UnitFactory;
import ReflectionEx3Ex4.core.Engine;
import ReflectionEx3Ex4.core.factories.UnitFactoryImpl;
import ReflectionEx3Ex4.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
