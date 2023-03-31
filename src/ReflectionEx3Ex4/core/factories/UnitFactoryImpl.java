package ReflectionEx3Ex4.core.factories;

import ReflectionEx3Ex4.interfaces.Unit;
import ReflectionEx3Ex4.interfaces.UnitFactory;
import ReflectionEx3Ex4.models.units.Gunner;
import ReflectionEx3Ex4.models.units.Horseman;
import ReflectionEx3Ex4.models.units.Archer;
import ReflectionEx3Ex4.models.units.Pikeman;
import ReflectionEx3Ex4.models.units.Swordsman;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		/*switch(unitType){
			case "Gunner":
				return new Gunner();
			case "Archer":
				return new Archer();
			case "Horseman":
				return new Horseman();
			case "Pikeman":
				return new Pikeman();
			case "Swordsman":
				return new Swordsman();
		}
		return null;*/
		//Reflection variant
		try {
			Class unitClass = Class.forName("ReflectionEx3Ex4.models.units." + unitType);
			Constructor<Unit> constructor = unitClass.getConstructor();
			return constructor.newInstance();
		}catch(ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
		}
		return null;
	}
}
