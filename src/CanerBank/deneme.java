package CanerBank;

class BB{
	BB(){
		System.out.println("BB.cons");
	}
	void f() {
		System.out.println("BB.f");
	}
	void g() {
		System.out.println("BB.g");
	}
	void h() {
		f();g();
		System.out.println("BB.h");
	}
}

class CC extends BB{
	void f() {
		System.out.println("CC.f");
	}
	void g() {
		System.out.println("CC.g");
	}
}


public class deneme {

	public static void main(String[] args) {
		BB cc = new CC();
		cc.h();
	}

}
