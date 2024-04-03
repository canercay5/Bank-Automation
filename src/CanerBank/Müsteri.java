package CanerBank;

public class Müsteri extends GenelMüsteri{
	public String type;
	
    public void getFeaturs() {
    	System.out.println("Benim özelliklerim sırasıyla"
    			+ "tckno, password, name, surname, birth, address, telefon, balance,type");
    }
}
