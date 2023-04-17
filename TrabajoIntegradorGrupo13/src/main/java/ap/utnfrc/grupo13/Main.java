package ap.utnfrc.grupo13;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  throws IOException{
        if (args.length == 2 ) {
            System.out.println("Pronosticos Deportivos");
            System.out.println("----------------------");

            //Ronda ronda1 = new Ronda();
            //String archivo = "resultados.csv";
            //creo un arrayList de partidos para guardar los partidos que voy creando
            //ArrayList<Partido> partidos = new ArrayList();

            //cargo el archivo resultados ingresado como argumento y con la funcion cuento la cantidad de  partidos
            String rutaArchivoResultados = args[0];

            int cantPartidosResultado = contarPartidos(rutaArchivoResultados);

            //Ahora cargo las lineas del archivo resultados en un array de String
            String[] lineasArchResultados = cargarPartidos(rutaArchivoResultados, (cantPartidosResultado));

            //array que va a contener todos los partidos de una ronda(para la primer entrega solo hay una ronda)
            Partido[] partidosRonda = new Partido[cantPartidosResultado];

            for (int i = 0; i < cantPartidosResultado; i++) {

                //Ahora divido en partes mas pequeñas cada linea del array lineasArchResultados
                // utilizando un delimitador , y cada parte la cargo en el array camposLinea
                String[] camposLineaArchResultados = lineasArchResultados[i].split(",");

                //ahora asigno a cada variable el valor que corresponde del array
                String nombreEquipo1 = camposLineaArchResultados[0];

                //convierto a int los goles porque desde al achivo vienen como String y
                // luego debo instanciar partido y los atributos goles de la clase son integer
                int cantGolesEquipo1 = Integer.parseInt(camposLineaArchResultados[1]);
                int cantGolesEquipo2 = Integer.parseInt(camposLineaArchResultados[2]);
                String nombreEquipo2 = camposLineaArchResultados[3];

                //creo los nuevo objetos equipo1 y equipo2 con los valores correspondientes
                Equipo equipo1 = new Equipo(nombreEquipo1, "Equipo 1");
                Equipo equipo2 = new Equipo(nombreEquipo2, "Equipo 2");

                //creo un objeto partido con los datos de la linea actual del array
                //camposLineaArchResultados(que contiene las lineas del archivo resultados)
                Partido partido = new Partido(equipo1, equipo2, cantGolesEquipo1, cantGolesEquipo2 );

                //agregro el partido a la coleccion de partidos
                //partidos.add(partido);

                //agrego el partido al array de partidos para una ronda para luego instanciar la ronda
                partidosRonda[i] = partido;


            }

            //creo la instancia de la primer y unica ronda con todos los partidos
            Ronda ronda = new Ronda("1", partidosRonda);

            //Pronostico rondap1 = new Pronostico();
            //cargo el archivo pronostico ingresado como argumento y con la funcion cuento la cantidad de  partidos
            String rutaArchivoPronostico = args[1];
            int cantPartidosPronostico = contarPartidos(rutaArchivoPronostico);

            System.out.println("La ronda 1 tuvo " + cantPartidosPronostico + " partidos");

            //Ahora cargo las lineas del archivo pronostico en un array de String
            String[] lineasArchPronostico = cargarPartidos(rutaArchivoPronostico, (cantPartidosPronostico));

            //ahora cargo los partidos de la unica ronda en el array partidosRondaActual
            Partido[] partidosRondaActual = ronda.getPartidos();

            //creo un array objetos pronostico para ir agregando los pronosticos que voy a ir creando al recorrer
            //el array camposLineaArchPronostico
            Pronostico[] pronosticos = new Pronostico[cantPartidosPronostico];
            int totalPuntos = 0;
            //for (int i = 0; i < s2 ; i++)
            for (int i = 0; i < cantPartidosPronostico; i++) {

                //creo una variable de tipo ResultadoEnun
                //(las clases enum son clases especiales que guardan valores constantes)
                ResultadoEnum resultado = null;

                String[] camposLineaArchPronostico = lineasArchPronostico[i].split(",");

                String nombreEquipo1Pronostico = camposLineaArchPronostico[0];
                Equipo equipo = new Equipo(nombreEquipo1Pronostico, "Equipo 1");
                String ganaEquipo1 = camposLineaArchPronostico[1].trim();
                String empate = camposLineaArchPronostico[2].trim();
                String ganaEquipo2 = camposLineaArchPronostico[3].trim();
                String nombreEquipo2Pronostico = camposLineaArchPronostico[4];


                //verifico que pronosticó la persona y lo cargo en resultado (que es un objeto enum)
                if (ganaEquipo1.equals("X"))
                {
                    resultado = ResultadoEnum.GANADOR;
                }
                else if (empate.equals("X"))
                {
                    resultado = ResultadoEnum.EMPATE;
                }
                else if (ganaEquipo2.equals("X"))
                {
                    resultado = ResultadoEnum.PERDEDOR;
                }

                //creo el objeto pronostico con los datos correspondientes
                Pronostico pronostico = new Pronostico(partidosRondaActual[i], equipo, resultado);
                //guardo el pronostico en el array de pronosticos
                pronosticos[i] = pronostico;

            }

            //Sumo los puntos obtenidos por la unica persona que participa
            for( int i = 0 ; i < pronosticos.length; i++)
            {
                totalPuntos += pronosticos[i].puntos();
            }
            System.out.println("puntaje total: "+ totalPuntos);
        }
        else{
            System.out.println("Debe proporcionar la ruta al archivo de resultados y al archivo de pronosticos");
        }
    }

    public static int contarPartidos(String nombreArchivo) throws IOException {
        int resultado = 0;
        Path f = Paths.get(nombreArchivo);
         if (Files.exists(f) && Files.isReadable(f)) {
            Scanner miEscaner = new Scanner(f);
            int conPartidos = 0;
            while (miEscaner.hasNextLine()) {
                miEscaner.nextLine();
                conPartidos++;
            }
            resultado = conPartidos;
        }
        return resultado;
    }

    public static String[] cargarPartidos(String nombreArchivo, int contPartidos) throws IOException {

        String[] resultado = new String[contPartidos];
        Path f = Paths.get(nombreArchivo);
        if (Files.exists(f) && Files.isReadable(f)) {
            Scanner miEscaner = new Scanner(f);
            int x = 0;
            for (int i = 0; i < contPartidos; i++) {
                String linea = miEscaner.nextLine();
                resultado[x] = linea;
                x++;
            }
        } else {
            resultado = null;
        }
        return resultado;
    }

}