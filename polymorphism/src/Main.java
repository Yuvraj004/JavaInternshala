public class Main {
	public static void main(String[] args) {
		System.out.println("Hello world!");
		//Polymorphism: one name but many forms
		//Runtime Polymorf: eg: method overriding
		//compile time polymorf: method overloading,constructor overloading
		//Method overriding: using same function in both parent and child class  and java will consider the method which is in child class
		//we want to run both the functions we use "super.Function()" in the child class so that the Function() in parent class also runs
		//Method overloading
		/*
		using the same function with different parameters,return type may vary .
		*/
/*
				overriding: 1.purpose to provide the specific implementation of the method of parent class within the child class
		2. Inheritance involved: at least two classes involved
		3. Exactly same method signature
		4. return type must be same
		5. run time polymorphism
		6. which method to call is decided in run time(JVM)

		Method Overloading

		->Purpose:to increase the readability of code
		->performed within a single class
		->same method name but different parameters
		->return type can be same or different
		->compile time polymorphism
		->which method to call is decided by compiler


		Runtime polymorphism: Upcasting
		Animal animal2= new Dog();  object created is of Dog type therefore it will use the functions of Dog class if there is
		any overriding
		wrong syntax: Dog da=new Animal(); =>child class cannot be referred to a parent class
		*/
		Remote remote = new Television();
		remote.powerOn();
		remote.volumeUp();
		remote.powerOff();

	}
}

interface Remote{
	void volumeUp();
	void  volumeDown();
	void powerOff();
	void powerOn();

}

class Television implements Remote{
	@Override
	public void volumeUp(){
		System.out.println("Volume up");

	}
	@Override
	public void volumeDown(){
		System.out.println("volume Down");

	}
	@Override
	public void powerOff(){
		System.out.println("power Off");

	}
	@Override
	public void powerOn(){
		System.out.println("power On");

	}




}
