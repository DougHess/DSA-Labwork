
public class Package<T> extends Item<T> {

	private T sender;
	private T reciever;
	private T amount;
	
	
	public Package(T weight, T name, T sender, T reciever, T amount) {
		super(weight, name);
		this.sender=sender;
		this.reciever=reciever;
		this.amount=amount;
	}


	public T getSender() {
		return sender;
	}


	public T getReciever() {
		return reciever;
	}


	public T getAmount() {
		return amount;
	}
	
}