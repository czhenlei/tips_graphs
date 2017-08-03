package annotations_example;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotationInject {
	public static Object getBean(Object obj){
		try {
			//获得类的属性
			Field field[] = obj.getClass().getDeclaredFields();
			
			for(Field ff : field){
				//获得属性上的注解
				DogAnnotation da = ff.getAnnotation(DogAnnotation.class);
				
				if(da != null){
					System.err.println("注入" + ff.getName() + "属性" + " " + da.value());
                    // 反射调用public set方法,如果为访问级别private,那么可以直接使用属性的set(obj,value);
                    obj.getClass().getMethod("set" + ff.getName().substring(0, 1).toUpperCase() + ff.getName().substring(1), new Class[] { String.class }).invoke(obj, da.value());
				}
			}
			// 获得所有方法
            Method m[] = obj.getClass().getDeclaredMethods();
            for (Method mm : m) {
                // 获得类的方法注解
            		DogAnnotation da1 = mm.getAnnotation(DogAnnotation.class);
                if (da1 != null) {
                    System.err.println("注入" + mm.getName() + "方法" + " " + da1.role());
                    mm.invoke(obj, da1.role());
                }
            }
            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}
