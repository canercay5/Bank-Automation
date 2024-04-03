package CanerBank;

public abstract class APerson {
    public long tckno;
    public int password;
    public String name;
    public String surname;
    public String birth;
    public String adress;
    public String telefon;
    
    public void getFeaturs() {
    	System.out.println("Benim özelliklerim sırasıyla"
    			+ "tckno, password, name, surname, birth, address, telefon.");
    }
}