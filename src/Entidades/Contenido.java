/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Random;

/**
 *
 * @author Administrator
 */
    
    public abstract class Contenido implements Comparable<Contenido>{
        
        protected Artista artista;
        protected String titulo;
        protected int duracion;
        protected int likes;
        
        protected static Random generadorLikes;
        
        static {
            generadorLikes = new Random();   
        }
        
        public Contenido(String titulo, int duracion, Artista artista){
            
            this.titulo = titulo;
            this.duracion = duracion;
            this.artista = artista;
        }
        
        public Contenido(String titulo, int duracion, String nombreArtista, String apellidoArtista, String paisArtista){
            
            this(titulo, duracion, new Artista(nombreArtista, apellidoArtista, paisArtista));      
        }
        
        public int getLikes(){
        if (this.likes == 0) {
        
            this.likes = generadorLikes.nextInt(1000000) + 1;
        }
        
        return this.likes;
        }
        
        private static String mostrar(Contenido c){
        
                return c.titulo + "-"
                        +c.artista.getArtista()
                        +"-"
                        +c.duracion
                        +" segundos";
        }
        
        public static boolean sonIguales(Contenido c1, Contenido c2){
            
            return c1.titulo.equals(c2.titulo)
                    && Artista.sonIguales(c1.artista, c2.artista);
        
        }
        
        @Override
        public boolean equals(Object obj){
            
            if(obj != null && obj instanceof Contenido){
                
                Contenido aux = (Contenido) obj;
                
                return Contenido.sonIguales(this, aux);
        
        }
            return false;
                    
        }
        
        @Override
        public String toString(){
            
            return this.titulo + " - "
                    +this.artista.getArtista()
                    +" - Likes:"
                    +this.getLikes();
        
        }
        
        @Override
        public int compareTo(Contenido otro){
            int comparaApellido =
                    this.artista.getApellido()
                    .compareTo(otro.artista.getApellido());
            
            if (comparaApellido == 0){
                
                int comparaNombre =
                        this.artista.getNombre()
                        .compareTo(otro.artista.getNombre());
            
            if (comparaNombre == 0){
                return this.titulo.compareTo(otro.titulo);
            }
                return comparaNombre;
            }
        return comparaApellido;
        }
        
    } 
    

