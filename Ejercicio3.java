public class Ejercicio3
{
    //campos de la clase
    private int[] vector;
    private int[] fuerzaV;

    //constructor que inicializa
    public Ejercicio3(){
        //inicializamos el vector inicial. 
        vector = new int[]{3,1,2,0,5}; //deberia generar el vector = 1, 5, 1, 7, 0
        //Otra opción:
        //vector = new int[]{3,1,2,0}; //deberia generar el vector = 1, 5, 1, 2
        
        //asignamos la longitud al vector que contendrá la fuerzaVecinal
        fuerzaV = new int[vector.length]; //debe tener el mismo tamaño del vector original
        deFuerzaVecinal(0); //llama al método que genera el segundo vector con el indice iniciado en 0.
    }

    //metodos set (modificación)
    public int[] deFuerzaVecinal(int indice){ ///genera un vector con la fuerza vecinal de otro recursivamente
        if(indice == vector.length){ //si se desborda (ya no hay más elementos)
            return fuerzaV; //retorne el vector.
        }
        else{
            if( (indice > 0) && (indice < vector.length-1)){ //si el elemento actual no se encuentra de primero ni de último
                fuerzaV[indice] = vector[indice-1] + vector[indice+1]; //se coloca en el vectorFV, la suma entre el valor anterior y el valor posterior.
                deFuerzaVecinal(++indice); //se llama de nuevo al método(recursividad) pero para que evalúe el siguiente elemento.
            }   
            else if(indice == 0){ //si se encuentra en la primer posición
                fuerzaV[indice] = vector[indice+1]; //se coloca en el vectorFV, el valor del siguiente elemento.
                deFuerzaVecinal(++indice); //se llama de nuevo al método(recursividad) pero para que evalúe el siguiente elemento.
            }
            else if(indice == vector.length-1){ //si se encuentra en la útlima posición
                fuerzaV[indice] = vector[indice-1]; //se coloca en el vectorFV, el valor del elemento anterior.
                deFuerzaVecinal(++indice); //se llama de nuevo al método(recursividad) pero para que evalúe el siguiente elemento.
            }
        }
        return fuerzaV;
    }

    //metodos get (acceso)
    public String muestreVector(int v[]){ //muestra el vector pasado por parámetro
        String respuesta = "";
        for (int indice = 0 ; indice < v.length ; indice++){ //recorre cada elemento del vector
            respuesta += v[indice] + "   "; //agrega a respuesta el valor del elemento actual y y deja 3 espacios.
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
        Ejercicio3 e3 = new Ejercicio3();
        System.out.println(e3.toString()); 
    }
}
