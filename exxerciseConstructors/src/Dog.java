public class Dog {
	private String breed;
	private int size;
	private String color;
	public Dog(){
		System.out.println("default constructor...");
	}
	public Dog(String b,int s,String c){
		this.breed=b;
		this.color=c;
		this.size=s;
		System.out.println("Dog has the following paramterized attributes");
		System.out.println(breed);
		System.out.println(color);
		System.out.println(size);
	}

	public String getBreed() {
		return breed;
	}

	public int getSize() {
		return size;
	}

	public String getColor() {
		return color;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
