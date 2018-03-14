import java.util.Scanner;
public class Maquina_Expendedora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Declaración de variables y declaración del escaner (1)
		Scanner teclado = new Scanner(System.in);
		String[] productos = { "Doritos", "Lays", "Oreo", "Lubricante","KitKat", "Emanems", "Chicles Orbirt","Pipas con sal" };
		int[] stock = { 10, 10, 10, 10, 10, 10, 10, 10 };
		int[] precio = { 65, 100, 90, 350,100, 150, 50, 100 };
		int opcion, monedas, contador = 0, recaudacion = 0;
		final int CODIGO_TECNICO = 981276450;
		//Final de la declaración de variables (1)
		//Empezamos con el menú de la maquina (2)
		boolean compra = true;
		do {
			System.out.println("MAQUINA EXPENDEDORA");
			System.out.println("Elija un producto");
			mostrarProductos(productos, precio);
			opcion = teclado.nextInt();
			//Mostramos los productos de la maquina (2)
			//Elegimos un producto y introducimos las monedas
			if (opcion <= productos.length && opcion > 0) {
				System.out.println("Tiene "+stock[opcion-1] + " uds disponibles");
				if (stock[opcion-1] > 0) {
					System.out.println(
							" Introduzca el dinero, Solo admite monedas de 5 cent, 10 cent, 20 cent, 50 cent, 1€, 2€");
					//Menu de las moneda y bucle del dinero 
					do {
						monedas = teclado.nextInt();
						switch (monedas) {
						case 1:
							contador += 100;
							break;
						case 2:
							contador += 200;
							break;
						case 5:
							contador += 5;
							break;
						case 10:
							contador += 10;
							break;
						case 20:
							contador += 20;
							break;
						case 50:
							contador += 50;
							break;
						default:
							System.out.println("Moneda no aceptada");
						}
						// comprobamos el dinero, llamando al metodo
					} while (!comprobarDinero(precio[opcion - 1], contador));
					contador = 0;
					stock[opcion-1] -= 1;
					recaudacion += precio[opcion -1];

				} else {

					System.out.println(" Producto no disponible ");
				}
				// es el primer else
			} else {
				if (opcion == CODIGO_TECNICO) {
					//bucle del menu del tecnico 
					do {
						menuTecnico();
						opcion = teclado.nextInt();
						switch (opcion) {
						case 1:
							mostrarStock(productos, stock);
							break;
						case 2:
							System.out.println("La recaudacion de hoy es: "+recaudacion+" cent");
							break;
						case 3:
							System.out.println("La recaudacion de hoy era: "+recaudacion+" cent");
							recaudacion = 0;
							break;
						case 4:
							System.out.println("Apagando Maquina...");
							compra = false;
							break;
						case 5:
							System.out.println("Reiniciando Maquina...");
							break;
						default:
							System.out.println("Opcion incorrecta");

						}
					} while (opcion > 0 & opcion < 4);
				} else {
					System.out.println("Opcion incorrecta");

				}
			}
		} while (compra);

	}// Fin del primer public static

	public static void mostrarProductos(String[] productos, int[] precio) {
		System.out.println("-> Productos: ");
		for (int i = 0; i < productos.length; i++) {
			System.out.println((i + 1) + "- " + productos[i] + " ----> " + precio[i] + " cents.");
		}
	}

	public static boolean comprobarDinero(int precio, int contador) {
		if (contador >= precio) {
			System.out.println("Aqui tiene su producto, su cambio es " + (contador - precio) + " centimos");
			return true;
		} else {
			System.out.println("Faltan " + (precio - contador) + " centimos");
			return false;
		}
	}

	public static void menuTecnico() {
		System.out.println("||| MENU TECNICO |||");
		System.out.println("1. Comprobar stock");
		System.out.println("2. Comprobar recaudacion");
		System.out.println("3. Extraer recaudacion");
		System.out.println("4. Apagar Maquina");
		System.out.println("5. Reiniciar Maquina");
	}
	
	public static void mostrarStock(String[] productos, int[] stock) {
		System.out.println("-> Stock: ");
		for (int i = 0; i < productos.length; i++) {
			System.out.println((i + 1) + "- " + productos[i] + " ----> " + stock[i] + " Unidades.");
		}
				
			}

}
