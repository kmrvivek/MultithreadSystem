package org.java.code;

public class ImmutableDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		Address add = new Address();
		add.setStreet("chandni");
		EmployeeDemo demo = new EmployeeDemo(1, add);
		System.out.println(demo);
		add.setStreet("Rajiv");
		System.out.println(demo);
	}

}

 final class EmployeeDemo{
    private final int id;
    private final Address address;
    
    public EmployeeDemo(int id, Address address) throws CloneNotSupportedException
    {
        this.id = id;
       /* Address add = new Address();
        add.setStreet(address.getStreet());*/
        this.address= address.clone();
        
    }
    public int getId(){
        return id;
    }
    public Address getAddress() throws CloneNotSupportedException{
    	  return address.clone();
    }
    
	@Override
	public String toString() {
		return "EmployeeDemo [id=" + id + ", address=" + address + "]";
	}    
    
}
 
 class Address implements Cloneable{
	 
	    private String street;
	  	    
	    public String getStreet(){
	        return street;
	    }
	    public void setStreet(String street){
	        this.street = street;
	    }
	    

	    @Override
	    public Address clone() throws CloneNotSupportedException {
	        return (Address) super.clone();
	    }

	    
		@Override
		public String toString() {
			return "Address [street=" + street + "]";
		}
		
	}


