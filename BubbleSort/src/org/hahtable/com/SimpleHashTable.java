package org.hahtable.com;

public class SimpleHashTable {

	private StoredEmployee[] hashtable;
	
	public SimpleHashTable() {
		hashtable = new StoredEmployee[10];
	}
	
	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		if(occupied(hashedKey)) {
			int stopedIndex = hashedKey;
			if(hashedKey == hashtable.length -1) {
				hashedKey = 0;
			} else {
				hashedKey++ ;
			}
			
			while(occupied(hashedKey) && hashedKey != stopedIndex) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		} 
		if(occupied(hashedKey)) {
			System.out.println("Sorry. there is already a employee at the position: "+hashedKey);
		} else {
			hashtable[hashedKey] = new StoredEmployee(key, employee);
		}
		
	}
	
	public Employee get(String key) {
		int hashKey = findKey(key);
		if(hashKey == -1) {
			return null;
		}
		return hashtable[hashKey].employee;
	}
	
	public Employee remove(String key) {
		int hashKey = findKey(key);
		if(hashKey == -1) {
			return null;
		} else {
			Employee employee = hashtable[hashKey].employee;
			
			hashtable[hashKey] = null;

			StoredEmployee[] oldHashtable = hashtable;			
			hashtable = new StoredEmployee[oldHashtable.length];
			for(int i=0; i < oldHashtable.length; i++) {
				if(oldHashtable[i] != null) {
					put(oldHashtable[i].key, oldHashtable[i].employee);
				}
			}
			
			return employee;
		}
	}
	
	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}
		
		
			int stopedIndex = hashedKey;
			if(hashedKey == hashtable.length -1) {
				hashedKey = 0;
			} else {
				hashedKey++ ;
			}
			
			while( hashtable[hashedKey] != null && hashedKey != stopedIndex && !hashtable[hashedKey].key.equals(key)) {
				hashedKey = (hashedKey + 1) % hashtable.length;
			}
		
		 if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			 return hashedKey;
		 } else {
			 return -1;
		 }
	}
	
	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}
	
	private boolean occupied(int index) {
		return (hashtable[index] != null);
	}
	
	public void printHashtable() {
		for(int i=0; i<hashtable.length; i++) {
			if(hashtable[i] == null) {
				System.out.println("empty");
			} else {
				System.out.println("Position: "+i+" : "+hashtable[i].employee);				
			}
		}
	}
}
