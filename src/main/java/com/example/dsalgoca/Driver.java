package com.example.dsalgoca;


import controller.SystemAPI;
/*
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
*/


public class Driver /* extends Application */ {

    private SystemAPI systemAPI = new SystemAPI();

   /*  @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Driver.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
*/
    public static void main(String[] args) {
        new Driver();
    }

    public Driver(){
        // launch();
    System.out.println("Hello");
    }
}