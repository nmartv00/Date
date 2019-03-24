package es.unileon.prg1.date;

/**
//@version 1
//@author Prog1
**/

public class Date {

	private int day;
	private int month;
	private int year;

	//constructor de nueva fecha con parametros por default
	public Date(){
		this.day = 1;
		this.month = 1;
		this.year = 2017;
	}

	//constructor de nueva fecha con parametros especificos
	public Date(int day, int month, int year) throws DateException{
		this.year = year;
		if(month < 1 || month > 12){
			throw new DateException("Mes "+month+ " no valido. Valores posibles entre 1 y 12");
		}else{
			this.month = month;
		}
	
		if(isDayOfMonth(month, day)){

			this.day = day;
		}else{
			throw new DateException("Dia " + day + " no valido. Valores no posibles para el mes de " + getMonthName(this.month));
		}
	}

	//constructos de nuevas fechas aleatorias
	public Date(int year){
		this.year = year;
		this.day = (int)(Math.random() * 32);
		this.month = (int)(Math.random() * 13);
	}

	//metodo que nos devuelve si un mes tiene el dia especificado
	private boolean isDayOfMonth(int month, int day){

		return (daysOfMonth(month) > day) && (day > 0);
	}

	//metodo que devuelve los dias que tiene cada mes
	public int daysOfMonth(int month){
		int number = 0;

		switch(month){
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12: number = 31;
				 break;
			case 4:
			case 6:
			case 9:
			case 11: number = 30;
				 break;
			case 2: number = 28;
				break;
			default: number = -1;
		}

		return number;

	}
	
	//metodo que devuelve el nombre del mes especificado
	public String getMonthName(int month){
	
		String mes = "";

		switch(month){
			case 1: mes = "Enero";
				break;
			case 2: mes = "Febrero";
				break;
			case 3: mes = "Marzo";
				break;
			case 4: mes = "Abril";
				break;
			case 5: mes = "Mayo";
				break;
			case 6: mes = "Junio";
				break;
			case 7: mes = "Julio";
				break;
			case 8: mes = "Agosto";
				break;
			case 9: mes = "Septiembre";
				break;
			case 10: mes = "Octubre";
				break;
			case 11: mes = "Noviembre";
				break;
			case 12: mes = "Diciembre";
				break;
		}
		System.out.println("Numero de dias del mes " + mes);
		return mes;

	}

	//metodo que devuelve la estacion del mes pasado por parametro
	public String seasonOfMonth(){
		String season = "";
	
		switch(this.month){
			case 1:
			case 2: 
			case 12: season = "Invierno";
				break;
			case 3:
			case 4:
			case 5: season = "Primavera";
				break;
			case 6:
			case 7:
			case 8: season = "Verano";
				break;
			case 9:
			case 10:
			case 11: season = "Otoño";
				break;
		}

		return season;
	}


	//metodo que devuelve si es el mismo año de dos fechas especificas
	public boolean isSameYear(Date anotherDate){
		

		return this.year == anotherDate.getYear();
	}

	//metodo que devuelve si es el mismo mes de dos fechas especificas
	public boolean isSameMonth(Date anotherDate){
			
		return this.month == anotherDate.getMonth();
	}

	//metodo que devuelve si es el mismo dia de dos fechas especificas
	public boolean isSameDay(Date anotherDate){
			
		return this.day == anotherDate.getDay();
	}

	//metodo que devuelve si son la misma fecha dos fechas especificas
	public boolean isSame(Date anotherDate){
			
		return this.day == anotherDate.getDay() && this.month == anotherDate.getMonth() && this.year== anotherDate.getYear();
	}

	//metodo que devuelve el año de la fecha con la que se llama al metodo
	public int getYear(){
		return this.year;
	}

	//metodo que devuelve el mes de la fecha con la que se llama al metodo
	public int getMonth(){
		return this.month;
	}

	//metodo que devuelve el dia de la fecha con la que se llama al metodo
	public int getDay(){
		return this.day;
	}

	//metodo que devuelve los meses que quedan para terminar el año desde la fecha con la que llamamos al metodo
	public int monthLeft(){

		int suma = 0;
		for(int i = this.month; i <=12; i++){
			suma++;
		}
	
		return suma;
	}

	//metodo que devuelve las fechas que quedan para terminar el mes desde la fecha con la que llamamos al metodo
	public String datesUntilEndMonth(){

		int dia = this.getDay();
		int monthDays = this.daysOfMonth(this.getMonth());
		String salida = "";
		for(int i = dia; i < monthDays; i++){
			dia++;
			this.day = dia;
			salida = salida + this.toString() + "\n";
		}
		return salida;
	}

	//metodo que devuelve los dias que llevamos desde el primer dia del año hasta la fecha con la que llamamos al metodo
	public int daysFirstDay(){

		int suma = this.getDay();
		int mes = this.getMonth();

		for(int i = 1; i < mes; i++){
			suma = suma + this.daysOfMonth(i);
		}

		return suma;
	}

	//metodo que devuelve el numero de intentos para que aleatoriamente se genere la misma fecha que le pedimos
	public int numIntentos(Date anotherDate){

		int intentos = 0;
		Date randomDate = new Date(anotherDate.getYear());
		while(!anotherDate.isSame(randomDate)){
			randomDate = new Date(anotherDate.getYear());
			intentos++;
		}

		System.out.println("El numero de intentos es: " + intentos);
		
		return intentos;
	}

	//metodo que devuelve el numero de intentos para que aleatoriamente se genere la misma fecha que le pedimos
	public int numIntentos2(Date anotherDate){

		int intentos = 0;
		Date randomDate = new Date(anotherDate.getYear());
		do{
			randomDate = new Date(anotherDate.getYear());
			intentos++;
		}while(!anotherDate.isSame(randomDate));
			
		System.out.println("El numero de intentos es: " + intentos);
		
		return intentos;
	}

	//metodo que devuelve el dia de la semana de la fecha
	public String dayOfWeek(int day){

		int dias = this.daysFirstDay();
		int diaSemana = 0;
		String dayWeek = "";
		if(dias%7 == 0){
			diaSemana = day;
		}else{
			diaSemana = day+(dias%7)-1;
		}
		
		switch(diaSemana){
			case 1: dayWeek = "Lunes";
				break;
			case 2: dayWeek = "Martes";
				break;
			case 3: dayWeek = "Miercoles";
				break;
			case 4: dayWeek = "Jueves";
				break;
			case 5: dayWeek = "Viernes";
				break;
			case 6: dayWeek = "Sabado";
				break;	
			case 7: dayWeek = "Domingo";
				break;
		}
		
		return dayWeek;
	}

	//metodo que devuelve la fecha en una cadena
	public String toString(){

		StringBuffer salida = new StringBuffer();
		
		salida.append("Año: " + this.year);
		salida.append(", Mes: " + this.month);
		salida.append(", Dia: " + this.day);

		return salida.toString();
	}

}
