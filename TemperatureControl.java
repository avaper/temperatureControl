package p1;

/**
 * Clase Práctica 1, ejercicio 2
 */
public class TemperatureControl 
{
	private static boolean calentAtascado = true;
	private static boolean tempSubiendo	  = true;
	private static boolean valvAtascada	  = true;
	
	/**
	 *  Excepcion Calentador atascado
	 */
	public static class HeaterStuckOn extends Exception
	{
		private static final long serialVersionUID = 1L;
		
		public HeaterStuckOn() {}
		
		public HeaterStuckOn(String msg) 
		{
			super(msg);
		}
	}
	
	/**
	 *  Excepcion Temperatura sigue subiendo
	 */
	public static class TemperatureStillRising extends Exception
	{
		private static final long serialVersionUID = 1L;
		
		public TemperatureStillRising() {}
		
		public TemperatureStillRising(String msg) 
		{
			super(msg);
		}
	}
	
	/**
	 *  Excepcion Valvula atascada
	 */
	public static class ValveStuck extends Exception
	{
		private static final long serialVersionUID = 1L;
		
		public ValveStuck() {}
		
		public ValveStuck(String msg) 
		{
			super(msg);
		}
	}

	/**
	 * Enciende el calentador
	 */
	public static void heaterOn () 
	{
		System.out.println("Encendiendo el calentador\n");
	}
	
	/**
	 * Apaga el calentador
	 * 
	 * @throws HeaterStuckOn
	 */
	public static void heaterOff () throws HeaterStuckOn 
	{
		System.out.println("Apagando el calentador\n");		

		if(calentAtascado) throw new HeaterStuckOn("El calentador está atascado");
	}
	
	/**
	 * Aumenta el caudal del refrigerante
	 * 
	 * @throws TemperatureStillRising
	 */
	public static void increaseCoolant () throws TemperatureStillRising 
	{
		System.out.println("Aumentando el caudal del refrigerante\n");
		
		if(tempSubiendo) throw new TemperatureStillRising("La temperatura sigue subiendo");	
	}
	
	/**
	 * Abre la valvula de escape de gas
	 * 
	 * @throws ValveStuck
	 */
	public static void openValve () throws ValveStuck 
	{
		System.out.println("Abriendo valvula de escape de gas\n");

		if(valvAtascada) throw new ValveStuck("La valvula esta atascada");
	}
	
	/**
	 * Alarma
	 */
	public static void panic () 
	{
		System.out.println("ALARMA. Informando a los Servicios de Emergencia\n");
	}

	/**
	 * MAIN
	 * @param args
	 */
	public static void main(String[] args) 
	{
		heaterOn();
		
		try 
		{
			heaterOff();
		} 
		catch (HeaterStuckOn e) 
		{
			try 
			{
				System.out.println("\tNo se ha podido apagar el calentador\n");
				increaseCoolant();
			} 
			catch (TemperatureStillRising e1) 
			{
				try 
				{
					System.out.println("\tNo se ha podido aumentar el caudal del refrigerante\n");
					openValve();
				} 
				catch (ValveStuck e2) 
				{
					System.out.println("\tNo se ha podido cerrar la valvula de escape de gas\n");
					panic();
				}
			}
		}		
	}
}



