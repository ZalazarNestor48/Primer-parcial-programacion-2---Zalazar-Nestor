/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Administrator
 */
public class BibliotecaStreaming {
        private int capacidad;
        private ArrayList<Contenido> contenidos;
        
         public BibliotecaStreaming() {

        this.capacidad = 3;
        this.contenidos = new ArrayList<>();
    }
    
        public BibliotecaStreaming(int capacidad) {

        this.capacidad = capacidad;
        this.contenidos = new ArrayList<>();
    }
        
        private boolean sonIguales(Contenido c) {

        for (Contenido aux : this.contenidos) {

            if (aux.equals(c)) {

                return true;
            }
        }

        return false;
    }
       
         public void agregar(Contenido c) {

        if (this.contenidos.size() < this.capacidad) {

            if (!this.sonIguales(c)) {

                this.contenidos.add(c);

                System.out.println("Contenido agregado.");
            } else {

                System.out.println("El contenido ya existe.");
            }

        } else {

            System.out.println("No hay más lugar.");
        }
    }
         
         private int getDuracionCanciones() {

        int acumulador = 0;

        for (Contenido aux : this.contenidos) {

            if (aux instanceof Cancion) {

                acumulador +=
                        ((Cancion) aux).getDuracionConPublicidad();
            }
        }

        return acumulador;
    }
         
         private int getDuracionPodcasts() {

        int acumulador = 0;

        for (Contenido aux : this.contenidos) {

            if (aux instanceof Podcast) {

                acumulador +=
                        ((Podcast) aux).getDuracionConPublicidad();
            }
        }

        return acumulador;
    }
           
         private int getDuracionTotal() {

        return this.getDuracionCanciones()
                + this.getDuracionPodcasts();
    }
         
          private int getDuracionContenido(TipoContenido tipo) {

        switch (tipo) {

            case CANCIONES:
                return this.getDuracionCanciones();

            case PODCASTS:
                return this.getDuracionPodcasts();

            case TODOS:
                return this.getDuracionTotal();
        }

        return 0;
    }
           private void ordenar() {

        Collections.sort(this.contenidos);
    }
           
    @Override
    public String toString() {

        this.ordenar();

        String retorno = "";

        retorno += "Cantidad contenidos: "
                + this.contenidos.size()
                + "\n\n";

        for (Contenido aux : this.contenidos) {

            retorno += aux.toString() + "\n";
        }

        retorno += "\nDuración canciones: "
                + this.getDuracionContenido(TipoContenido.CANCIONES);

        retorno += "\nDuración podcasts: "
                + this.getDuracionContenido(TipoContenido.PODCASTS);

        retorno += "\nDuración total: "
                + this.getDuracionContenido(TipoContenido.TODOS);

        return retorno;
    }
}

