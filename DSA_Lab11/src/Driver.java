
public class Driver {

	public static <T> void main(String args[]) {
		MyBinarySearchTree<Item<String>, ?> ahri = new MyBinarySearchTree();
		Item a = new Item("apple");
		Item b = new Item("orange");
		Item c = new Item("grape");
		Item d = new Item("pear");
		ahri.insert(a);
		ahri.insert(b);
		ahri.insert(c);
		ahri.insert(d);
		System.out.println(ahri.retrieve("apple"));
	}
}
