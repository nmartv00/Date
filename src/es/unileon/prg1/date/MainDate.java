package es.unileon.prg1.date;


public class MainDate {


	public static void main(String[] args){
		
		Date today;
		Date anotherDate; 
		try{
			today = new Date(9, 10, 2017);
			anotherDate = new Date(14, 1, 2017);
			System.out.println(today.toString());
			System.out.println("Es " + today.seasonOfMonth() + "");
			System.out.println("Los años son iguales " + today.isSameYear(anotherDate));
			System.out.println("El mes es el mismo " + today.isSameMonth(anotherDate));
			System.out.println("El dia es el mismo " + today.isSameDay(anotherDate));
			System.out.println("Es la misma fecha " + today.isSame(anotherDate));
			System.out.println("Quedan " + today.monthLeft() + " meses para terminar el año");
			System.out.println("Estas son las fechas que quedan para terminar el mes " + anotherDate.datesUntilEndMonth());
			System.out.println("Han pasado " + today.daysFirstDay() + " dias desde que empezo el año");
			System.out.println("Hoy es " + today.dayOfWeek(2));
		}catch(DateException e){
			System.out.println(e.getMessage());
		}

	}


}
