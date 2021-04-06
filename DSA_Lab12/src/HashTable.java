
public class HashTable<K, V> implements HashTableInterface<K,V> {
  private ChainNode[] table;     // hash table
  private int length= 0;         // number of entries (number of (key,value) associations)

  public HashTable() {
    table = new ChainNode[3];
  }  // end default constructor

// table operations
  public boolean tableIsEmpty() {
    return length==0;
  }  // end tableIsEmpty

  public int tableLength() {
    return length;
  }  // end tableLength = number of (key,value) associations in the HashTable


//implement the following 5 methods

// if key is not already in HashTable inserts association (key,value) and returns true
// if key is already in the HashTable it does not get re-inserted and returns false
public boolean tableInsert(K key, V value) //not the best implementation but working
{
	boolean result = false;
	ChainNode n = new ChainNode(key, value, null);
	int index = hashCode(key);
	if (table[index]==null) {
		table[index]=n;
		result = true;
	}
	else {
		ChainNode curr = table[index];
		boolean match=false;
		while(curr.getNext()!=null) {
			if (curr.getKey().equals(key)) {
				match=true;
			}
			curr=curr.getNext();
		}
		if (curr.getKey().equals(key)) {
			match=true;
		}
		if (match==false) {
		curr.setNext(n);
		result = true;
		}
	}
	if (result==true) {
		length++;
	}
	return result;
}

// if key is in HashTable deletes the key and its association from the HashTable and returns true
// if key is not in the HashTable returns false
public boolean tableDelete(K searchKey) // 
{
	boolean result =false;
	if (!tableIsEmpty()) {
		ChainNode curr =new ChainNode(null,null,null);
		int i = hashCode(searchKey);
		curr=table[i];
		if (curr.getKey().equals(searchKey)) {
			result = true;
			table[i]=curr.getNext();
		}
		while (curr.getNext()!=null) {
			if (curr.getNext().getKey().equals(searchKey)) {
					curr.setNext(curr.getNext().getNext());
					result = true;
					break;
			}
			curr=curr.getNext();
		}
		if (result==true) {
		length--;
		}
	}
	return result;
}

//returns the value associated with searchKey in the HashTable or null if the serchKey is not in the HashTable 
public V tableRetrieve(K searchKey)
{
	ChainNode curr=new ChainNode(null, null, null);
	V result = null;
	if (!tableIsEmpty()) {
		for (int i = 0;i <table.length;i++) {
			curr = table[i];
			while(curr!=null) {
				if (curr.getKey().equals(searchKey)) {
					result = (V) curr.getValue();
					break;
				}
				curr=curr.getNext();
			}
		}
	}
	return result;
}

// returns the integer hashCode computed using Horner's rule - assumes K is String 
public int hashCode(K key) 
{
	int result=0;;
	char[] kkey = ((String) key).toCharArray();
	for(int i =0;i<kkey.length;i++) {
		int rank=kkey[i]-'A'+1;
		int power = rank<<(5*(kkey.length-i-1));
		result += power;
	}
	return result%table.length;
}

//display all (key,value) associations in the HashTable
public String toString() 
{
	String result="";
	for (int i = 0; i<table.length; i++) {
		ChainNode curr = table[i];
		while(curr!=null) {
			result += "["+i+"] Key = ";
			result += curr.getKey();
			result += " value = ";
			result += curr.getValue()+"\n";
			curr= curr.getNext();
		}
	}
	return result;
}


}  // end HashTable
