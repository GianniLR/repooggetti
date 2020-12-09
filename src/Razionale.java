/*FARE SOMMA-ADDIZIONE-SOTTRAZIONE-MOLTIPLICAZIONE E POW SIA STATICI 
CREANDO UN NUOVO RELAZIONALE E NON STATICI SOSTITUENDO R1 CON IL RISULTATO*/
public class Razionale {
	private int numeratore;
	private int denominatore;
	
	//costruttore
	public Razionale (int numeratore, int denominatore) {
		this.numeratore=numeratore;
		this.denominatore=denominatore;
	}
	//set e get
	public int getNumeratore() {
		return numeratore;
	}


	public void setNumeratore(int numeratore) {
		this.numeratore = numeratore;
	}


	public int getDenominatore() {
		return denominatore;
	}


	public void setDenominatore(int denominatore) {
		this.denominatore = denominatore;
	}


	//visualizza
	public String toString() {
		if(denominatore==1)
		{
			return ""+numeratore;
		}
		return numeratore+"/"+denominatore;
	}
		
	//Potenza
	public void pow(int pot) {
		if(pot==0)
		{
			numeratore=1;
			denominatore=1;
		}
		else {
			
			for (int i = 1; i < pot; i++) {
				this.numeratore = numeratore * numeratore;
				this.denominatore = denominatore * denominatore;
			}

		}
	}
	
	public static Razionale powS(Razionale raz, int pot) {
		Razionale ris=new Razionale(raz.getNumeratore(),raz.getDenominatore());
		
		ris.pow(pot);
		return ris;
	}
	
	//Moltiplicazione
	public void mol(Razionale r) {
		this.numeratore=this.numeratore*r.getNumeratore();
		this.denominatore=this.denominatore*r.getDenominatore();
		
	}
	
	public static Razionale molS(Razionale raz1, Razionale raz2) {
		Razionale ris=new Razionale(1,1);
		
		ris.setNumeratore((raz1.getNumeratore()*raz2.getNumeratore()));
		ris.setDenominatore((raz1.getDenominatore()*raz2.getDenominatore()));
		
		return ris;
	}
	
	//Somma
	public void som(Razionale r2) {
		int d=(this.denominatore*r2.getDenominatore());
		
		this.numeratore=(d/this.denominatore)*this.numeratore;
		r2.numeratore=(d/r2.denominatore)*r2.numeratore;
		int somNum=numeratore+r2.numeratore;
		this.numeratore=somNum;
		this.denominatore=d;
		
	}
	
	public static Razionale somS(Razionale raz1, Razionale raz2) {
		Razionale ris=new Razionale(raz1.getNumeratore(),raz1.getDenominatore());
		ris.som(raz2);		
		return ris;
	}
	
	//Divisione (basta scambiare numeratore e denominatore del seconodo relazione e richiamare mol
	public void div(Razionale r) {
		int temp=r.getNumeratore();
		r.setNumeratore(r.getDenominatore());
		r.setDenominatore(temp);
		mol(r);
	}
	
	public static Razionale divS(Razionale r1, Razionale r2) {
		Razionale copia= new Razionale(r1.getNumeratore(), r1.getDenominatore());
		copia.mol(inv(r2));
		return copia;
	}
	
	public static Razionale inv(Razionale r2) {
		return new Razionale(r2.getDenominatore(), r2.getNumeratore());
	}
	
	//Sottrazione (numeratore per -1)
	public static Razionale  cambiaSegno(Razionale r) {
		return new Razionale(r.getNumeratore()-1,r.getNumeratore()-1);
	}
	
	public void sott (Razionale r) {
		this.numeratore=this.numeratore*(-1);
		this.denominatore=this.denominatore*(-1);
		som(r);
	}
	
	public static Razionale sottS(Razionale r1, Razionale r2) {
		Razionale copia= new Razionale(r1.getNumeratore(), r1.getDenominatore());
		copia.som(cambiaSegno(r2));
		return copia;
	}
	
	
	//Main
	public static void main(String[] args) {
		Razionale r1=new Razionale(1,2);
		
		
		Razionale r2=new Razionale(1,2);
		
		System.out.println("Razionale r1: "+r1);
		
		//Potenze
		r1.pow(3);
		System.out.println("Potenza Non statico: "+r1);
		r1.setNumeratore(1);
		r1.setDenominatore(2);
		System.out.println("Potenza Statico: "+Razionale.powS(r1,3));
		
		System.out.println("------------------------------");

		//Moltiplicazione
		r1.mol(r2);
		System.out.println("Moltiplicazione Non statico: "+r1);
		r1.setNumeratore(1);
		r1.setDenominatore(2);
		System.out.println("Moltiplicazione Statico: "+Razionale.molS(r1,r2));
	
		
		System.out.println("------------------------------");
		
		//Somma
		r1.som(r2);
		System.out.println("Somma Non statico: "+r1);
			System.out.println("Razionale r2: "+r2);
		r1.setNumeratore(1);
		r1.setDenominatore(2);
		System.out.println("Somma Statico: "+Razionale.somS(r1,r2));
		
		System.out.println("------------------------------");
		
		//Sottrazione
		r1.sott(r2);
		System.out.println("Sottrazione Non statico: " + r1);
		r1.setNumeratore(1);
		r1.setDenominatore(2);
		System.out.println("Sottrazione Statico: "+Razionale.sottS(r1,r2));
		
		System.out.println("------------------------------");
		
		//Divisione
		System.out.println("Divisione Non statico: " + divS(r1,r2));
		r1.setNumeratore(1);
		r1.setDenominatore(2);
		
		
		
		
	}

}
