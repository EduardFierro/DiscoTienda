/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pojo.Album;
import pojo.Artista;

/**
 *
 * @author Eduard Fierro
 */
public class LogicaCrudArtista {
    private List<Artista> listaArtista;
    private Artista artista;
    private Album album;
    private List<Album> listaAlbum;
    public LogicaCrudArtista(List<Artista> lista, Artista artista) {
        this.listaArtista = lista;
        this.artista = artista;
    }
    
    public void eliminarArtista(){
        if(validarAlbum())
        listaArtista.remove(artista);
    }

    public List<Artista> getLista() {
        return listaArtista;
    }

    public void setLista(List<Artista> lista) {
        this.listaArtista = lista;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public List<Album> getListaAlbum() {
        return listaAlbum;
    }

    public void setListaAlbum(List<Album> listaAlbum) {
        this.listaAlbum = listaAlbum;
    }
    
    public boolean validarAlbum(){
        if(listaAlbum== null){
            listaAlbum = new ArrayList<>();
        }
        if(listaAlbum.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }
    public void LecturaFichero(){
        try{
            File archivo = new File ("C:/Users/Pavilion 15/Documents/NetBeansProjects/2020-1/mavenproject2/TiendaCanciones/album.txt");
            FileReader lector = new FileReader(archivo);
            BufferedReader br = new BufferedReader(lector);
            String linea = br.readLine();
            String palabra[] = linea.split(";");
            for(int i=0;i<palabra.length;i++){
                String bufer[] = palabra[i].split(",");
                album = new Album(bufer[0], bufer[1]);
                if(bufer[1].equals(artista.getNombre()))
                listaAlbum.add(album);
            }
        }
        catch(FileNotFoundException e){
             System.out.print("se revento en lectura fichero" );
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
