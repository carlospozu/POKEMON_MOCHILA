package com.example.pokemon;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class HelloControllerCombate  {

   public static Pokemon pokemonPagina1;
    public Label curar;
    public Label atacar;


    PokemonMalo aleatorio;
    PokemonMalo m1 = new PokemonMalo("Mewtwo", 80, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\mewtwo.png"));
    PokemonMalo m2 = new PokemonMalo("Dragonite", 73, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\draqonite.png"));
    PokemonMalo m3 = new PokemonMalo("Gyarados", 90, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\gyarados.png"));
    PokemonMalo m4 = new PokemonMalo("Rayquaza", 80, 100, 100, new File("src\\main\\java\\com\\example\\pokemon\\fotos\\rayquaza.jpg"));

    float lifeMalo;
    float vidaBarraMalo;
    float life;
    float vidaBarra;


    @FXML
    ImageView fotoMuerto;
    @FXML
    Label nombreMuerto;

    @FXML
    Label nombrePokemon;
    @FXML
    Label nivelPokemon;
    @FXML
    ProgressBar vidaPokemon;
    @FXML
    Label vidaNumPokemon;
    @FXML
    ImageView pokemonBueno;

    @FXML
    Label nombreEnemy;
    @FXML
    Label nivelEnemy;
    @FXML
    Label vidaNumEnemy;
    @FXML
    ProgressBar vidaEnemy;
    @FXML
    ImageView PokemonMalo;
    @FXML
    ImageView fondo;
    @FXML
    BorderPane ataques;
    @FXML
    AnchorPane menuSalir;



Pokemon pokemonSeleccionado;

    @FXML
    public void initialize(Pokemon pokemonSeleccionado) {


        this.pokemonSeleccionado=pokemonSeleccionado;
        Random r = new Random();
        int n = r. nextInt(5)+1;


        switch (n) {
            case 1 -> aleatorio = m1;
            case 2 -> aleatorio = m2;
            case 3 -> aleatorio = m3;
            case 4 -> aleatorio = m4;
        }

        lifeMalo = aleatorio.vidaRestante;
        vidaBarraMalo = (lifeMalo/aleatorio.vida);
        Image fotomalo = new Image(aleatorio.foto.toURI().toString());
        PokemonMalo.setImage(fotomalo);
        nombreEnemy.setText(aleatorio.nombre);
        nivelEnemy.setText(String.valueOf(aleatorio.nivel));
        vidaEnemy.setProgress(vidaBarraMalo);
        vidaNumEnemy.setText(String.valueOf(aleatorio.vida));

        life = pokemonSeleccionado.vidaRestante;
        vidaBarra= (life/pokemonSeleccionado.vida);
        Image fotobueno = new Image(pokemonSeleccionado.fotodetras.toURI().toString());
        pokemonBueno.setImage(fotobueno);
        nombrePokemon.setText(pokemonSeleccionado.nombre);
        nivelPokemon.setText(String.valueOf(pokemonSeleccionado.nivel));
        vidaPokemon.setProgress(vidaBarra);
        vidaNumPokemon.setText(String.valueOf(pokemonSeleccionado.vidaRestante));
        ataques.setVisible(false);

        Image fondo1 = new Image("src/main/java/com/example/pokemon/fotos/fondo.png");
        fondo.setImage(fondo1);
    }

    public void ataque() {
        ataques.setVisible(true);

    }

    public void curar(MouseEvent mouseEvent) {
        Random g = new Random();
        int a = g. nextInt(76)+25;
        life = life+a;
        if (life>pokemonSeleccionado.vida){
            life = pokemonSeleccionado.vida;
        }
        vidaBarra= (life/pokemonSeleccionado.vida);
        vidaPokemon.setProgress(vidaBarra);
        vidaNumPokemon.setText(String.valueOf(life));

        Random h = new Random();
        int b = h. nextInt(76)+25;
        lifeMalo = lifeMalo+b;
        if (lifeMalo>aleatorio.vida){
            lifeMalo = aleatorio.vida;
        }
        vidaBarraMalo= (lifeMalo/aleatorio.vida);
        vidaEnemy.setProgress(vidaBarraMalo);
        vidaNumEnemy.setText(String.valueOf(lifeMalo));

    }

    public void atacarSeguro(MouseEvent mouseEvent) {
        if (!(lifeMalo <= 0 || life <= 0)){
            lifeMalo = lifeMalo-20;
            vidaBarraMalo= (lifeMalo/aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo>0){
                life = life-20;
                vidaBarra= (life/pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf(life));
            }
            else {
                menu();
            }
        }

    }

    public void atacarArriesgado(MouseEvent mouseEvent) {
        if (!(lifeMalo <= 0 || life <= 0)){
            Random c = new Random();
            int a = c. nextInt(26)+10;
            lifeMalo = lifeMalo-a;
            vidaBarraMalo= (lifeMalo/aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo>0){
                Random d = new Random();
                int b = d. nextInt(26)+10;
                life = life-b;
                vidaBarra= (life/pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf(life));
            }
            else {
                menu();
            }
        }

    }

    public void atacarMuyArriesgado(MouseEvent mouseEvent) {
        if (!(lifeMalo <= 0 || life <= 0)){
            Random e = new Random();
            int a = e. nextInt(51);
            lifeMalo = lifeMalo-a;
            vidaBarraMalo= (lifeMalo/aleatorio.vida);
            vidaEnemy.setProgress(vidaBarraMalo);
            vidaNumEnemy.setText(String.valueOf(lifeMalo));
            if (lifeMalo>0){
                Random f = new Random();
                int b = f. nextInt(51);
                life = life-b;
                vidaBarra= (life/pokemonSeleccionado.vida);
                vidaPokemon.setProgress(vidaBarra);
                vidaNumPokemon.setText(String.valueOf((life)));
            }
            else {
                menu();
            }
        }

    }

    public void cancelar(MouseEvent mouseEvent) {
        ataques.setVisible(false);
    }

    public void salirBoton(MouseEvent mouseEvent) {
        System.exit(0);
    }

    public void continuarBoton(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Ventana1.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 663, 400);
        stage.setTitle("ESCOGE POKEMON");
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
    }

    public void pokemonPasado(HelloController helloController){
        Pokemon pokemon = pokemonPagina1;
    }

    public void menu(){
        menuSalir.setVisible(true);
        if (lifeMalo<=0){
            Image fotomuerto = new Image(aleatorio.foto.toURI().toString());
            fotoMuerto.setImage(fotomuerto);
            nombreMuerto.setText(aleatorio.nombre);
        }
        else{
            Image fotomuerto1 = new Image(pokemonSeleccionado.foto.toURI().toString());
            fotoMuerto.setImage(fotomuerto1);
            nombreMuerto.setText(pokemonSeleccionado.nombre);
        }
    }

}



