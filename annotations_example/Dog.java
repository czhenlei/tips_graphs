package annotations_example;

public class Dog {
	@DogAnnotation(value = "Lumia")
	private String name;
	private String Property;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void say() {
		System.out.println("小狗:汪汪汪汪.....");
	}
	
	@DogAnnotation(role = "水陆两栖战士")
	public void setProperty(String Property) {
		this.Property = Property;
	}
	
	public String getProperty() {
		return (this.Property);
	}
	public static void main(String[] args) {
		Dog dogInstance = (Dog) AnnotationInject.getBean(new Dog());
		
		System.out.println("name:" + dogInstance.getName());
		System.out.print("action:");
		dogInstance.say();
		System.out.println("role:" + dogInstance.getProperty());
	}
}
