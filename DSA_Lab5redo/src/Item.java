
public class Item<T> {

	protected T weight;
	protected T name;
	
	public Item(T weight, T name) {
		this.name=name;
		this.weight=weight;
	}
	public T getweight() {
		return weight;
	}
	public T getName() {
		return name;
	}
	
}
