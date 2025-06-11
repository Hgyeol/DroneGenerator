package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.Set;

import org.reflections.Reflections;

import annotation.HangyeolController;
import annotation.HangyeolMapping;

public class ReflectionTest {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Reflections reflections = new Reflections("test");
		Set<Class<?>> haveHangyeolControllerClass = reflections.getTypesAnnotatedWith(HangyeolController.class);
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("=드론 제네레이터=");
			System.out.println("1. 드론 정보 리스트");
			System.out.println("2. 드론 등록");
			System.out.println("3. 드론 좌표 생성");
			System.out.println("4. 종료");
			System.out.print(">> ");
			
			String n = sc.nextLine();
			System.out.println(n);
			Outerloop: for(Class<?> c : haveHangyeolControllerClass) {
				System.out.println(c.getName());
				Method[] methods = c.getDeclaredMethods();
				for(Method method : methods) {
					if(method.isAnnotationPresent(HangyeolMapping.class)) {
						HangyeolMapping hangyeolMapping = method.getAnnotation(HangyeolMapping.class);
						String value = hangyeolMapping.value();
						System.out.println("value : " + value);
						if(n.equals(value)) {
							Object instance = c.getDeclaredConstructor().newInstance();
							System.out.println("======Running Method======");
							System.out.println("Method : " + method.getName() + ", Value : " + value);
							method.invoke(instance);
							break Outerloop;
						}
					}
				}
			}
		}
		
	}
}
//
//@HangyeolController
//class TestController {
//	String hg = "hangyeol";
//	Scanner sc = new Scanner(System.in);
//	
//	@HangyeolMapping(value="1")
//	public void showDroneList() {
//		System.out.println("dron1, dron2, dron3");
//	}
//	
//	@HangyeolMapping(value="2")
//	public void addDrone() {
//		System.out.print("드론 아이디 : ");
//		String droneId = sc.nextLine();
//		System.out.println(droneId + " 등록 완료!");
//	}
//}
//
//@HangyeolController
//class Test2Controller {
//	String hg = "hangyeol";
//	Scanner sc = new Scanner(System.in);
//	
//	@HangyeolMapping(value="3")
//	public void generateLocation() {
//		System.out.print("드론 아이디 : ");
//		String droneId = sc.nextLine();
//		System.out.println(droneId + " 좌표 생성 완료!");
//	}
//	
//	@HangyeolMapping(value="4")
//	public void end() {
//		System.exit(0);
//	}
//}
//
//class Test3Controller {
//	String hg = "hangyeol";
//	Scanner sc = new Scanner(System.in);
//	
//	@HangyeolMapping(value="2")
//	public void generateLocation() {
//		System.out.print("드론 아이디 : ");
//		String droneId = sc.nextLine();
//		System.out.println(droneId + " 좌표 생성 완료!");
//	}
//	
//	@HangyeolMapping(value="4")
//	public void end() {
//		System.exit(0);
//	}
//}