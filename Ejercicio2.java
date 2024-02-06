public class Ejercicio2
{
    //campos de la clase
    private int[][]matriz; //declara la matriz de manera global

    //constructor que inicializa
    public Ejercicio2(){
        //inicializamos la matriz
        matriz = new int[][]{ {1,2,3,4} , {4,5,6,7} , {7,8,9,10} , {8,4,15,2} }; //Suma debería dar: 95
        //Otras opciones:
        //matriz = new int[][]{ {0,1,1} , {2,1,1} , {3,2,1} }; //Suma debería de dar: 12
        //matriz = new int[][]{ {1,2,3} , {4,5,6} , {7,8,9} }; //Suma debería de dar: 45
    }

    //metodos set (modificación)
    //Opcion 1. (con un solo método).
    public int sumeCeldas(int control){ //suma todas las celdas de una matriz, recursivamente.
        int suma = 0;
        if(control == (matriz.length*matriz.length)){ //si llegó al final de la matriz
            return suma;   //pare, retorne la suma.
        }
        else{
            suma += matriz[control/matriz.length][control%matriz.length] + sumeCeldas(++control);
        }
        return suma;
    }

    //opción 2 (con dós métodos) hecha por si el enunciado rechaza la opción 1.
    public int sumeC(int fila, int columna){ //suma las columnas recursivamente mientras no se desborde
        if(columna == matriz.length){ //si se desborda las columnas
            return 0;                //no retorne nada, pare.
        }
        else{   //si sigue dentro y faltan columnas 
            //retorne la actual y avance de columna
            return matriz[fila][columna] + sumeC(fila,++columna);
        }
    }

    //continuación de opción 2 (con dós métodos) hecha por si el enunciado rechaza la opción 1.
    public int sumeF(int fila, int columna){ //suma las columnas recursivamente y salta de fila cuando sea necesario.
        int suma = 0;
        if(fila == matriz.length){ //si se desborda las filas
            return suma;    //ya terminó de recorrer la matriz, pare y retorne ya la suma.
        }
        else{   //sume la fila actual, salte de línea a la siguiente fila.
            suma += sumeC(fila,columna) + sumeF(++fila,columna);
        }
        return suma;
    }
    
    //No se evalúa en el enunciado pero sobraba tiempo y queda bien.
    public String muestreMatriz(int control){ //muestra la matriz completa
        String respuesta = "";
        if(control == (matriz.length*matriz.length)){ //si llegó al final de la matriz
            return respuesta;   //pare, retorne la respuesta.
        }
        else{
            if((control%matriz.length) == 0){ //si está al final de la fila
                //salte, imprima la celda actual y avance
                respuesta += "\n" + matriz[control/matriz.length][control%matriz.length] + muestreMatriz(++control);
            }
            else{ //está en una columna intermedia
                //tabule, imprima la celda y avance.
                respuesta += "\t" + matriz[control/matriz.length][control%matriz.length] + muestreMatriz(++control);
            }
        }
        return respuesta;
    }

    //unico controlador universal
    public static void main(String a[]){
        Ejercicio2 e2 = new Ejercicio2();
        //opción 1 (con un método)
        System.out.println("Opción 1:\nSuma de celdas: " + e2.sumeCeldas(0)); 
        //opción 2 (con dós métodos) hecha por si el enunciado rechaza la opción 1. 
        //Ambas opciones funcionan.
        System.out.println("Opción 2:\nSuma de celdas: " + e2.sumeF(0,0)); 
        System.out.println("\nMatriz: " + e2.muestreMatriz(0));
    }
}
