/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;


/**
 *
 * @author Administrator
 */
public class Cancion extends Contenido implements Publicitable {
       
    private GeneroMusical generoMusical;
    private CalidadAudio calidadAudio;
    
    public Cancion(String titulo, int duracion, Artista artista, GeneroMusical generoMusical, CalidadAudio calidadAudio){
        
        super(titulo, duracion, artista);
        
        this.generoMusical = generoMusical;
        this.calidadAudio = calidadAudio;
    
    }
    
    @Override
    public int getDuracionConPublicidad(){
        
        switch (this.calidadAudio){
            
            case BAJA:
                return this.duracion + 30;
                
            case MEDIA:
                return this.duracion + 20;
                
            case ALTA:
                return this.duracion;
        }
        return this.duracion;
    }
    
    @Override
    public String toString(){
        
        return super.toString()
                +" - Genero: "
                + this.generoMusical
                +" - Calidad: "
                + this.calidadAudio
                +" - Duracion con publicidad: "
                + this.getDuracionConPublicidad();
    }
    
    @Override
    public boolean equals(Object obj){
        
        if (super.equals(obj) && obj instanceof Cancion){
            
            Cancion aux =(Cancion) obj;
            
            return this.generoMusical == aux.generoMusical;
        }
        
        return false;
    }
    
}
