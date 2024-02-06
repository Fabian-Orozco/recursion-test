public class Ejercicio4
{
    //campos de la clase
    private int[] vector; //declara un vector original.
    private int[] fuerzaV; //declara otro vector que almacenará la fuerza vecinal.

    //constructor que inicializa
    public Ejercicio4(){
        //vector = new int[]{3,1,2,0,5}; //deberia generar el vector = 1, 5, 1, 7, 0
        vector = new int[]{3,1,2,0}; //deberia generar el vector = 1, 5, 1, 2
        fuerzaV = new int[vector.length]; //debe tener el mismo tamaño del vector original
        deFuerzaVecinal(); //llama al método que genera el segundo vector
    }

    //metodos set (modificación)
    public void deFuerzaVecinal(){ //genera un vector con la fuerza vecinal de otro iterativamente
        for (int indice = 0 ; indice < vector.length ; indice++){ //recorre el vector original
            if( (indice > 0) && (indice < vector.length-1)){ //si no se encuentra de primero ni de último
                fuerzaV[indice] = vector[indice-1] + vector[indice+1]; //se coloca en el vectorF, la suma entre el valor anterior y el valor posterior.
            }   
            else if(indice == 0){ //si se encuentra en la primer posición
                fuerzaV[indice] = vector[indice+1]; //se coloca en el vectorF, el valor del siguiente elemento.
            }
            else if(indice == vector.length-1){ //si se encuentra en la útlima posición
                fuerzaV[indice] = vector[indice-1]; //se coloca en el vectorF, el valor del elemento anterior.
            }
        }
    }

    //metodos get (acceso)
    public String muestreVector(int v[]){ //muestra el vector pasado por parámetro
        String respuesta = "";
        for (int indice = 0 ; indice < v.length ; indice++){ //recorre cada elemento del vector
            respuesta += v[indice] + "   "; //agrega a respuesta el valor del elemento actual y deja 3 espacios.
        }
        return respuesta;
    }

    //metodo toString()
    public String toString(){ //imprime el vector inicial y el de fuerza vecinal
        String respuesta = "";
        respuesta += "Vector original:\n" + muestreVector(vector) + "\nFuerza vecinal:\n" + muestreVector(fuerzaV);
        return respuesta;
    }

    //unico controlador universal
    public static void main(String a[]){
        Ejercicio4 e4 = new Ejercicio4();
        System.out.println(e4.toString()); 
    }
}
