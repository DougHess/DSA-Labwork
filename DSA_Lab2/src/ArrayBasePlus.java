
	public class ArrayBasePlus extends ListArrayBased{

		protected Object[] newItems;
		

		public void add(int index, Object item) {
			 
			if(numItems == items.length) {
				newItems = new Object[items.length*2]; 
				int i=0;
				for(Object p: items) {
					 newItems[i++]=p;
					 System.out.println(i);
				}
			items = newItems;
			//System.out.println(items.length);
			}
			super.add(index, item);
		}
		
		public void reverse() {
			Object[] reverseList = new Object[items.length];
			int j=0;
			for(int i = items.length-1; i>=0 ; i--) {
				reverseList[j++]=items[i];
			}
			items=reverseList;
			
		}
		
		public String toString() {
			return items.toString();
		}

			
			
			 
		}