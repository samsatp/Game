package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class GameViewManager {

    private AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;

    private static final int GAME_WIDTH = 600;
    private static final int GAME_HEIGHT = 800;

    private Stage menuStage;

    public GameViewManager(){

        initialStage();
        createListener();
        createBackButton();


    }


    public void createListener(){

        gameScene.setOnKeyPressed(e -> {

            if(e.getCode() == KeyCode.LEFT){

            }else if(e.getCode() == KeyCode.RIGHT){

            }

        });

        gameScene.setOnKeyReleased((e -> {

            if(e.getCode() == KeyCode.LEFT){

            }else if(e.getCode() == KeyCode.RIGHT){

            }

        }));

    }



    private void initialStage(){

        gamePane = new AnchorPane();
        gameScene= new Scene(gamePane, GAME_WIDTH, GAME_HEIGHT);
        gameStage = new Stage();
        gameStage.setScene(gameScene);

    }


    public void creatNewWindow(Stage menuStage){

        this.menuStage = menuStage;
        this.menuStage.hide();
        gameStage.show();

    }


    public void createBackButton(){

        Button backButton = new Button("BACK");
        backButton.setOnAction(e -> {
            menuStage.show();
            this.gameStage.close();
        });


        gamePane.getChildren().add(backButton);


    }
}
