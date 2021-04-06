
public class Item<T> {

	protected T color;
	protected T name;
	
	public Item(T color, T name) {
		this.name=name;
		this.color=color;
	}

	public T getcolor() {
		return color;
	}

	public T getName() {
		return name;
	}

	public void setWeight(T color) {
		this.color = color;
	}

	public void setName(T name) {
		this.name = name;
	}
	public String toString() {
		String s = (String)name + " " +color;
		return s;
	}
}
