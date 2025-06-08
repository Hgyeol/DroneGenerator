package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.reflections.Reflections;

import annotation.HangyeolController;
import annotation.HangyeolMapping;

public class ReflectionTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Reflections reflections = new Reflections("test");
		Set<Class<?>> haveHangyeolControllerClass = reflections.getTypesAnnotatedWith(HangyeolController.class);
//		Set<Class<?>> haveHangyeolControllerClass = new HashSet<>();
//		haveHangyeolControllerClass.addAll(reflections.getTypesAnnotatedWith(HangyeolController.class));
		for(Class<?> c : haveHangyeolControllerClass) {
			System.out.println(c.getName());
		}
//		Set<Class<?>> haveHangyeolControllerClass = reflections.get(SubTypes.of(TypesAnnotated.with(HangyeolController.class)).asClass());
		
		TestController testController = new TestController();
		
		Method[] methods = testController.getClass().getMethods();
		for(Method method : methods) {
			if(method.isAnnotationPresent(HangyeolMapping.class)) {
				HangyeolMapping hangyeolMapping = method.getAnnotation(HangyeolMapping.class);
				String value = hangyeolMapping.value();
				System.out.println("Method : " + method.getName() + ", Value : " + value);
				
				if(method.getName().equals("getHangyeol")) {
					System.out.println("======Running Method======");
					String result = (String) method.invoke(testController);
					System.out.println("Result : " + result);
				}
				else {
					System.out.println("======Running Method======");
					
					method.invoke(testController, "Fuck up");
					String result = testController.getHangyeol();
					System.out.println("Result : " + result);
				}
			}
		}
		
//		Method method = testController.getClass().getMethod("getHangyeol");
//		
//		if(method.isAnnotationPresent(HangyeolMapping.class)) {
//			HangyeolMapping hangyeolMapping = method.getAnnotation(HangyeolMapping.class);
//			System.out.println("value : " + hangyeolMapping.value());
//		}
	}
}

@HangyeolController
class TestController {
	
	String hg = "hangyeol";
	
	public void hangyeol() {};
	
	@HangyeolMapping(value="1000")
	public String getHangyeol() {
		return hg;
	}
	
	@HangyeolMapping(value="1234")
	public void setHangyeol(String hg) {
		this.hg = hg;
	}
}

@HangyeolController
class Test2Controller {
	
	String hg = "hangyeol";
	
	public void hangyeol() {};
	
	@HangyeolMapping(value="1000")
	public String getHangyeol() {
		return hg;
	}
	
	@HangyeolMapping(value="1234")
	public void setHangyeol(String hg) {
		this.hg = hg;
	}
}

@HangyeolController
class Test3Controller {
	
	String hg = "hangyeol";
	
	public void hangyeol() {};
	
	@HangyeolMapping(value="1000")
	public String getHangyeol() {
		return hg;
	}
	
	@HangyeolMapping(value="1234")
	public void setHangyeol(String hg) {
		this.hg = hg;
	}
}