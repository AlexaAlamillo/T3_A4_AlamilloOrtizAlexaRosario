
class Nodo{
	private int dato;
	private Nodo nodoSiguiente;
	public Nodo(int dato) {
		super();
		this.dato = dato;
		
	}
	public int getDato() {
		return dato;
	}
	public void setDato(int dato) {
		this.dato = dato;
	}
	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(Nodo modoSiguiente) {
		this.nodoSiguiente = modoSiguiente;
	}
	@Override
	public String toString() {
		return "Nodo [dato=" + dato + ", modoSiguiente=" + nodoSiguiente + "]";
	}
	
}
/*
 * Operaciones para listas enlazadas
 * 1)Crear 
 * 2)Agregar
 * 2.1) Agregar a inicio
 * 2.2)Al final
 * 2.3)En posicion especifica(
 * 3)Eliminar
 * 3.1)eliminar al inicio
 * 3.2) eliminar al final
 * 3.3) Posicion especifica
 * 4)MostrarDatos(recorrer)
 * 
 */
class ListaEnlazada{
	Nodo nodoInicio; 
	Nodo nodoFin;
	
	//1) crear
	public ListaEnlazada() {
		nodoFin = nodoInicio = null;
	}
	//2)Agregar al inicio
	public void agregarElementoAlInicio(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if(nodoInicio== null) {
			
			System.out.println("La lista esta vacia");
			
			nodoInicio = nodoFin = nuevoNodo;//Esto ayuda a cambiar la referencia de nodoInicio
			
		}else {//Ya existen nodos (Elementos)
			//Agregar nodo al inicio
			System.out.println("Se agrego el nodo al inicio");
			
			nuevoNodo.setNodoSiguiente(nodoInicio);
			 nodoInicio = nuevoNodo ;
		}
	}
	
	//Agregar al final
	
	public void agregarAlFinal(int dato) {
		Nodo nuevoNodo = new Nodo(dato);
		if(nodoInicio== null) {
			
			System.out.println("La lista esta vacia");
			
			nodoInicio = nodoFin = nuevoNodo;//Esto ayuda a cambiar la referencia de nodoInicio
			
		}else {
			System.out.println("Se agrego al final");
			
			nodoFin.setNodoSiguiente(nuevoNodo);
			
			nodoFin = nuevoNodo;
		}
		
		
	}
	//Recorrer y mostrar elementos
	public void mostrarElementos() {
		Nodo nodoActual = nodoInicio;
		while(nodoActual!=null) {
			System.out.print("["+nodoActual.getDato()+"] ==>");
			nodoActual = nodoActual.getNodoSiguiente();
			System.out.println();
			
		}
	}
	//eliminar al inicio
	public void eliminarAlInicio() {
		
		if(nodoInicio==null) {
			System.out.println("La lista esta vacia");
		}else {
			System.out.println("Se elimino el primer nodo");
			nodoInicio=nodoInicio.getNodoSiguiente();
			
		}
	
	}
	//Eliminar al final
	public void eliminarAlFinal() {
		Nodo nodoAnterior ;
		
		if(nodoInicio == null) {
			System.out.println("La lista esta vacia");
		}else {
			System.out.println("Se elimino al final");
			nodoAnterior = nodoInicio;
			while(nodoAnterior.getNodoSiguiente()!= nodoFin) {
				nodoAnterior = nodoAnterior.getNodoSiguiente();
			}
			nodoAnterior.setNodoSiguiente(null);
			nodoFin =nodoAnterior;
		}
		
	}
	
	//Eliminar en posicion especifica 
	public void eliminarEnPosicionEspecifica(int posicion){
		if(nodoInicio == null) {
			System.out.println("La lista esta vacia ");
		}else if(posicion<0) {
			System.out.println("La posicion no existe");
		}else if(posicion==0){
			System.out.println("Se elimino el primer nodo");
			nodoInicio=nodoInicio.getNodoSiguiente();
			
		}else {
			Nodo nodoActual = nodoInicio;
			Nodo nodoAnterior = null;
			int contador =0;
			 while(nodoActual != null && contador < posicion) {
		            nodoAnterior = nodoActual;
		            nodoActual = nodoActual.getNodoSiguiente();
		            contador++;
		        }
			 if(nodoActual == null) {
		            System.out.println("La posición no existe");
		            
		        } else {
		        	System.out.println("La posicion se elimino");

		            nodoAnterior.setNodoSiguiente(nodoActual.getNodoSiguiente());

		            if(nodoActual == nodoFin) {
		                nodoFin = nodoAnterior;
		            }

		        }
			
		}
		
		
	}
	
	//eliminar datoEspecifico
	public void eliminarDatoEspecifico(int datoBuscado) {
		if(nodoInicio ==null) {
			System.out.println("Lista  vacia");
			
		}else if(datoBuscado==nodoInicio.getDato()) {
			System.out.println("Dato encontrado en el primer NODO");
			nodoInicio=nodoInicio.getNodoSiguiente();
			
		}else {
			Nodo nodoAnterior , nodoPosterior;
			nodoAnterior = nodoInicio;
			nodoPosterior = nodoInicio.getNodoSiguiente();
			while(datoBuscado!=nodoPosterior.getDato()&& nodoPosterior.getNodoSiguiente()!=null) {
				nodoAnterior = nodoPosterior;
				nodoPosterior = nodoPosterior.getNodoSiguiente();
				if(datoBuscado==nodoPosterior.getDato()){
					nodoAnterior.setNodoSiguiente(nodoPosterior.getNodoSiguiente());
					nodoPosterior = nodoPosterior.getNodoSiguiente();
					System.out.println("Se elimino el dato");
					
				}else {
					System.out.println("Dato no encontrado");
				}
				
			}
			
		}
		
	}
	
}



public class PruebaListaSimplementeEnlazada {
	public static void main (String [] args) {
		Nodo nodo = new Nodo(7);
		ListaEnlazada le= new ListaEnlazada();
		le.mostrarElementos();
		le.agregarElementoAlInicio(7);
		System.out.println("Recorriendo lista cuando no esta vacia ");
		le.mostrarElementos();
		le.agregarAlFinal(1);
		le.agregarElementoAlInicio(9); 
		le.mostrarElementos();
		le.agregarElementoAlInicio(5);
		le.mostrarElementos();
		le.agregarAlFinal(8);
		le.agregarAlFinal(10);
		le.mostrarElementos();
		le.eliminarDatoEspecifico(5);
		le.eliminarDatoEspecifico(9);
		le.mostrarElementos();
		le.eliminarAlInicio();
		le.mostrarElementos();
		le.eliminarAlFinal();
		le.mostrarElementos();
		le.eliminarDatoEspecifico(8);
		le.agregarAlFinal(11);
		le.eliminarAlInicio();
		le.mostrarElementos();
		le.eliminarEnPosicionEspecifica(0);
		le.mostrarElementos();
	}

}
