package fr.univ_amu.iut.exercice6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Exercice 6 - Palette de couleurs (capstone).
 *
 * <p>Dernier exercice du TP : synthèse des concepts vus jusqu'ici (layout, boutons, événements,
 * mise à jour d'un label) sur une petite application autonome.
 *
 * <h3>Comportement attendu</h3>
 *
 * <pre>
 * ┌──────────────────────────────┐
 * │ [Rouge] [Vert] [Bleu]        │  ← HBox de 3 boutons
 * ├──────────────────────────────┤
 * │                              │
 * │     (zone de couleur)        │  ← Pane "#zone" dont le fond change
 * │                              │
 * ├──────────────────────────────┤
 * │ Rouge: 0  Vert: 0  Bleu: 0   │  ← Label "#compteurs"
 * └──────────────────────────────┘
 * </pre>
 *
 * <p>Chaque clic sur un bouton :
 *
 * <ul>
 *   <li>change la couleur de fond de la zone centrale ;
 *   <li>incrémente le compteur correspondant dans le label du bas.
 * </ul>
 *
 * <p>Les trois compteurs sont indépendants : cliquer "Rouge" n'affecte pas les compteurs "Vert" et
 * "Bleu".
 */
public class Palette extends Application {

  private int compteur_rouge = 0;
  private int compteur_vert = 0;
  private int compteur_bleu = 0;

  @Override
  public void start(Stage primaryStage) {
    // TODO exercice 6 : implémenter la palette décrite dans la Javadoc.
    //
    // Stratégie conseillée :
    //
    // 1. Créer un BorderPane comme racine.
    //
    // 2. Top : un HBox avec trois boutons "Rouge", "Vert", "Bleu".
    // Donne-leur les ids "btn-rouge", "btn-vert", "btn-bleu" - les tests
    // les retrouvent via robot.lookup("#btn-rouge") etc.
    //
    // 3. Center : un Pane avec l'id "zone", taille minimale 300×200.
    // Change sa couleur via setStyle("-fx-background-color: red;") etc.
    //
    // 4. Bottom : un Label avec l'id "compteurs", texte initial
    // "Rouge: 0 Vert: 0 Bleu: 0".
    //
    // 5. Trois entiers compteur_rouge, compteur_vert, compteur_bleu
    // (ou trois variables d'instance). Chaque clic incrémente le bon
    // compteur et reformate le texte du label.
    //
    // 6. Attention au format du texte du label : les tests vérifient la
    // présence exacte des substrings "Rouge: 2", "Vert: 0", "Bleu: 1"
    // après une séquence de clics.
    BorderPane root = new BorderPane();
    HBox box = new HBox(10);
    Button red = new Button("Rouge");
    Button green = new Button("Vert");
    Button blue = new Button("Bleu");
    red.setId("btn-rouge");
    green.setId("btn-vert");
    blue.setId("btn-bleu");
    box.getChildren().addAll(red, green, blue);
    root.setTop(box);
    Pane pane = new Pane();
    pane.setId("zone");
    pane.minWidth(200);
    pane.minHeight(300);
    root.setCenter(pane);
    Label compteurs = new Label("Rouge: 0 Vert: 0 Bleu: 0");
    compteurs.setId("compteurs");
    root.setBottom(compteurs);
    red.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: red;");
          compteur_rouge += 1;
          compteurs.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    green.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: green;");
          compteur_vert += 1;
          compteurs.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    blue.setOnAction(
        e -> {
          pane.setStyle("-fx-background-color: blue;");
          compteur_bleu += 1;
          compteurs.setText(
              "Rouge: " + compteur_rouge + " Vert: " + compteur_vert + " Bleu: " + compteur_bleu);
        });
    Scene maScene = new Scene(root);
    primaryStage.setScene(maScene);
    primaryStage.setWidth(200);
    primaryStage.setHeight(300);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
