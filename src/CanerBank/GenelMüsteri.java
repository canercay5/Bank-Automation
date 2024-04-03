package CanerBank;

public abstract class GenelMüsteri extends APerson {
	public int balance;
	
    public void getFeaturs() {
    	System.out.println("Benim özelliklerim sırasıyla"
    			+ "tckno, password, name, surname, birth, address, telefon, balance");
    }
}
