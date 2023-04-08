public class Reactangle {
	float length;
	float  breadth;

	public float getBreadth() {
		return breadth;
	}

	public float getLength() {
		return length;
	}

	public void setBreadth(float breadth) {
		this.breadth = breadth;
	}

	public void setLength(float length) {
		this.length = length;
	}
	public float perimeter(){
		return 2*(this.length+this.breadth);
	}

	public float area(){
		System.out.println("Area: ");
		return (this.length*this.breadth);
	}
}
