package test;

import java.lang.reflect.Method;

import annotation.HangyeolController;
import annotation.HangyeolMapping;

public class ReflectionTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException {
		TestController testController = new TestController();
		
		Method[] methods = testController.getClass().getMethods();
		for(Method method : methods) {
			if(method.isAnnotationPresent(HangyeolMapping.class)) {
				HangyeolMapping hangyeolMapping = method.getAnnotation(HangyeolMapping.class);
				String value = hangyeolMapping.value();
				System.out.println("Method : " + method.getName() + ", Value : " + value);
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