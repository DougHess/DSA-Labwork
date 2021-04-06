
public class Item <KT extends Comparable<? super KT>> extends KeyedItem<KT> {
	private String name;
	private int assocint;
	private boolean assocboolean;

	public Item(KT name) {
		super(name);
		this.name=(String) name;
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAssocint() {
		return assocint;
	}

	public void setAssocint(int assocint) {
		this.assocint = assocint;
	}

	public boolean isAssocboolean() {
		return assocboolean;
	}

	public void setAssocboolean(boolean assocboolean) {
		this.assocboolean = assocboolean;
	}

}
