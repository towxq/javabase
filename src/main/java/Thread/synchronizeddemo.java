package Thread;

public class synchronizeddemo {

}

class Account{
	String holderName;
	float amount;
	Account(String name,float amt){
		holderName = name;
		amount = amt;
	}
	
	public synchronized void deposit(float amt){
		amount+=amt;
	}
	
	public synchronized void withdraw(float amt){
		amount -= amt;
	}
	
	public float checkBalance(){
		return amount;
	}
}