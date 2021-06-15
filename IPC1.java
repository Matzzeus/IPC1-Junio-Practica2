import java.util.*;


public class IPC1{
    Scanner scanner = new Scanner(System.in);
    String nameMovie[]  = new String[30];
    String namecliente[] = new String[30];
    String categoriaPeli[] = new String[30];
    int anioPeli[] = new int [30];
    int idcliente [] = new int [30];
    int idpeliculas[] = new int [30];   
    int celularCliente[] = new int [30];
    int edadcliente[] = new int [30];
    boolean pelisPrestadaClien [] = new boolean[30];
    boolean disponiblepeli[] = new boolean[30];
    int posicionPelicula = 0; 
    int posicionCliente = 0;
    int cantidadCadaCategoria[] = new int [30];
    String cadaCategoria[] = new String[30];
    int cantidadCategorias = 0;

    public static void main (String[] args){
        IPC1 practica2 = new IPC1();      
    }
    public void reportes (){
        int opcion ;
        System.out.println("Reportes cantidad Categorias = 1 Filtrar por categoria = 2");
        opcion = scanner.nextInt();
        scanner.nextLine();
        
        
        
        
        if(opcion == 1){
            reporte1();
            System.out.println("");
        }
        else{
            if(opcion == 2){
                reporte2();
                System.out.println("");
            }
            else{
                System.out.println("La opcion ingresada no existe");
                System.out.println("");
            }

        }

    }
    public void reporte1(){
        System.out.println(".................Pelicualas.................");
        for (int i = 0; i < cantidadCategorias; i++) {
            System.out.print("Categoria: "+cadaCategoria[i] + "===== Cantidad Categorias: " + cantidadCadaCategoria[i]);
            System.out.println("");
        }
    }
    public void reporte2(){
        String categoria;
        System.out.println("Ingrese la categoria");
        categoria = scanner.nextLine();
        System.out.println("");
        System.out.println(".................Pelicualas Por Categoria.................");
        for (int i = 0; i < posicionPelicula; i++) {
            if(categoriaPeli[i].equals(categoria)){
                System.out.print("El nombre de la pelicula es: " + nameMovie[i]);  
                System.out.println(" ");
                System.out.print("El ID de la pelicula es: " + idpeliculas[i] );
                System.out.println(" ");
                System.out.print("El anio de la pelicula es: " + anioPeli[i]);
                System.out.println(" ");
                System.out.println("la categoria de la pelicula es: " + categoriaPeli[i]);
                
                if (disponiblepeli[i] == true ){
                    System.out.println("La pelicula  esta disponible, para usted");
                    System.out.println(" ");
                }
                else{
                    System.out.println("La pelicula  No esta disponible, para usted");
                    System.out.println(" ");
                }
            }   
        }
    }
    
   
    public IPC1 () {
            int menu;
            do {
            System.out.print(".................Bienvenido Usaurio.................");
            System.out.print("\n.................Menu Principal.................");
            System.out.println("");
            System.out.println("\nPréstamo de películas = 1");
            System.out.println("Devolución de películas = 2");
            System.out.println("Mostrar las películas = 3");
            System.out.println("Ordenar las películas de forma ascendente = 4");
            System.out.println("Ingreso de Películas = 5");
            System.out.println("Ingresar clientes nuevos = 6");
            System.out.println("Mostrar clientes = 7");
            System.out.println("Reportes = 8");
            System.out.println("salir de la aplicación = 9");
            System.out.println(".................Escoja una opcion.................");
            menu = scanner.nextInt();
            scanner.nextLine();
            
            switch(menu){
                case 1:
                alquilarMovie ();
                    break;
                case 2:
                devolverMovie ();
                    break;
                case 3:
                mostrarMovie ();
                    break;
                case 4:
                mostrarpelisOrdenadas();
                    break;
                case 5:
                GuardarPeli();
                    break;
                case 6:
                datosCliente ();
                    break;
                case 7:
                mostrarClientes ();
                    break;
                case 8:
                reportes ();
                    break;
                case 9:
                    System.out.println("Gracias por usar la aplicación");
                    break;
            }  
    }
    while ( menu != 9);
    }

    public  void datosCliente (   ){
        int edad, cell, id, opcion ;
        String name;
        Boolean PeliPrestada;
        System.out.println(".................Datos Cliente.................");
        do {
        System.out.println("Ingrese Nombre");
        name = scanner.nextLine();
        namecliente[ posicionCliente] = name; 

        System.out.println("Ingrese número de celular");
        cell = scanner.nextInt();
        celularCliente[posicionCliente] = cell;
        scanner.nextLine();

        System.out.println("Ingrese edad"); 
        edad = scanner.nextInt();
        edadcliente[posicionCliente] = edad;
        scanner.nextLine();
        
        int idBuscar = 0;
        do{
            idBuscar = 0;
        System.out.println("ingrese ID del cliente");
        id = scanner.nextInt() ;
        scanner.nextLine();
        for (int i = 0; i < posicionCliente; i++) {
            if ( id == idcliente[i]){
                idBuscar = 1;
                break;
            }
        }
    
    }    while ( idBuscar != 0);
        idcliente[posicionCliente] = id;

        posicionCliente ++;
        System.out.println(".................Datos Guardados.................");
        System.out.println("¿Desea ingresar otro clinete? = 1  ó ¿regresar al menu principal? = 2");
        opcion = scanner.nextInt();
        scanner.nextLine();
         
    } 
         while( opcion != 2);
        
    } 

        public  void GuardarPeli () {
        int idpeli, anio,  opcion;
        String nombrePelicula, categoria;
        Boolean DisponibleP;

        do {
        System.out.println("ingrese Nombre de Pelicula");
        nombrePelicula = scanner.nextLine();
        
        nameMovie [ posicionPelicula] =  nombrePelicula;

        int idBuscar = 0;
        do {
        idBuscar = 0;
        System.out.println("ingrese id de la Pelicula");
        idpeli = scanner.nextInt() ;
        scanner.nextLine();
        for (int i = 0; i < posicionPelicula; i++) {
            if ( idpeli == idpeliculas[i]){
                idBuscar = 1;
                break;
            }
        }
    
    }    while ( idBuscar != 0);
        idpeliculas[posicionPelicula] = idpeli;

        System.out.println("ingrese año de la Pelicula");
        anio = scanner.nextInt();
        scanner.nextLine();
        anioPeli[posicionPelicula] = anio;

        System.out.println("Categoria"); 
        categoria = scanner.nextLine();
        categoriaPeli [posicionPelicula] = categoria;

        boolean encontrado = false;
        for (int i = 0; i < cantidadCategorias; i++) {
            if(categoria.equals(cadaCategoria[i])){
                cantidadCadaCategoria[i] = cantidadCadaCategoria[i] + 1;
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            cadaCategoria[cantidadCategorias] = categoria;
            cantidadCadaCategoria[cantidadCategorias] = 1;
            cantidadCategorias++;
        }

        disponiblepeli[posicionPelicula] = true;
    
        posicionPelicula ++;
        System.out.println(".................Datos Guardados.................");
        System.out.println("¿Desea ingresar otra Pelicula? = 1  ó ¿regresar al menu principal? = 2");
        opcion = scanner.nextInt();
        scanner.nextLine();
         
        }

        while ( opcion != 2 );

        }

        public  void   mostrarClientes (){
            int exit; 
            System.out.println(".................Clientes Registrados.................");
            do {
            for ( int i = 0 ; posicionCliente > i; i ++ ){
            System.out.println("el nombre del clinetes es: " + namecliente[i]);
            
            System.out.println("El numero del clinete es: " + celularCliente[i]);
            System.out.println(" El ID del clinete es: " + idcliente [i] );
            System.out.println("La edad del clinete es:" + celularCliente[i]);
                System.out.println();
            }
            System.out.println(".................Datos Guardados.................");
            System.out.println("¿Desea ingresar otra Pelicula? = 1  ó ¿regresar al menu principal? = 2");
            exit = scanner.nextInt();
            scanner.nextLine();
        }
        while ( exit != 2);
        }


        public  void mostrarMovie (){
            int opcion;
            do {
            System.out.println(".................Pelicualas Registradas.................");
            for (int i = 0; i < posicionPelicula ; i++ ){
            System.out.print("El nombre de la pelicula es: " + nameMovie[i]);  
            System.out.println(" ");
            System.out.print("El ID de la pelicula es: " + idpeliculas[i] );
            System.out.println(" ");
            System.out.print("El anio de la pelicula es: " + anioPeli[i]);
            System.out.println(" ");
            System.out.println("la categoria de la pelicula es: " + categoriaPeli[i]);
            
            if (disponiblepeli[i] == true ){
                System.out.println("La pelicula  esta disponible, para usted");
                System.out.println(" ");
            }
            else{
            System.out.println("La pelicula  No esta disponible, para usted");
            System.out.println(" ");
            }
        }
        System.out.println("Para regresar al menú = 'Presione cualquier letre'  ó volver a ver el listado de peliculas = 2");
        opcion = scanner.nextInt();
        scanner.nextLine();
        }
        while ( opcion != 2);

        }

        public  void oredenar(){
            for (int i = 0 ; i < posicionPelicula - 1; i++) {
                for (int j =  i + 1; j < posicionPelicula; j++) {
                    int comparacion = nameMovie[i].compareToIgnoreCase(nameMovie[j]);
                    if ( comparacion > 0){
                        String auxi;
                        auxi = nameMovie[i];
                        nameMovie[i] = nameMovie[j];
                        nameMovie [j] = auxi;
                        String auxiCate;
                        auxiCate = categoriaPeli[i];
                        categoriaPeli[i] = categoriaPeli[j];
                        categoriaPeli[j] = auxiCate;

                        int auxiId;
                        auxiId = idpeliculas[i];
                        idpeliculas[i] = idpeliculas[j];
                        idpeliculas[j]= auxiId;

                        int auxianio;
                        auxianio = anioPeli[i];
                        anioPeli[i] = anioPeli[j];
                        anioPeli[j] = auxianio;
                    }

                }
                
            }

        }
        public void mostrarpelisOrdenadas(){
        for (int i = 0; i < posicionPelicula; i++) {
            System.out.println(nameMovie[i] + " ===== " + idpeliculas[i] + " ===== " + anioPeli[i] + " ===== " + categoriaPeli[i]); 
        }

        }

        public void alquilarMovie (){

        }

        public static void devolverMovie (){


        }

    }
