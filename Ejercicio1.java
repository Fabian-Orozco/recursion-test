public class Ejercicio1
{
    //campos de la clase
    private int[] vector; //declara un vector original.

    //constructor que inicializa
    public Ejercicio1(){
        //inicializa el vector.
        vector = new int[]{2,4,6,1,7,8}; //inicializamos el vector. Suma debería dar 8
        //Otra prueba:
        //vector = new int[]{3,6,9,2}; //inicializamos el vector. Suma debería dar: 12
    }

    public int obtengaSumaImpar(int indice){ //método que obtiene la suma de todos los elementos impares de un vector
        int suma = 0; //variable que almacenará la suma de todos los elementos impares del vector, la cual será retornada
        if(indice == vector.length){ //se desborda
            return suma; //retorna la suma si llega al final del vector.
        }
        else{
            if((vector[indice] % 2) != 0){ //es impar
                suma += vector[indice] + obtengaSumaImpar(++indice); //sume el el valor de la posición actual, avance y evalúe(recursividad).
            }
            else{ //es par
                suma += obtengaSumaImpar(++indice); //avance de posición y evalúe(recursividad).
            }
        }
        return suma;
    }

    //metodos get (acceso)
    public void muestreVector(){ //muestra el vector pasado por parámetro
        System.out.println("Vector: " );
        for (int indice = 0 ; indice < vector.length ; indice++){ //recorre cada elemento del vector
            System.out.print(vector[indice] + "   "); //agrega a respuesta el valor del elemento actual y y deja 3 espacios.
        }
        System.out.println("\n");
    }

    //unico controlador universal
    public static void main(String a[]){
        Ejercicio1 e1 = new Ejercicio1();
        e1.muestreVector();
        System.out.println("Suma de impares: " + e1.obtengaSumaImpar(0));
    }
}
