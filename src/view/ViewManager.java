package view;

import Model.MySubscene;
import Model.SpaceRunnerButton;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ViewManager {

    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private static final int menu_button_start_x = 100;
    private static final int menu_button_start_y = 150;

    private MySubscene HelpSubscene;
    private MySubscene StartSubscene;
    private MySubscene ScoreSubscene;

    private MySubscene sceneToHide;

    List<SpaceRunnerButton> menuButton;


    public ViewManager() {

        menuButton = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 800,600);
        mainStage= new Stage();
        mainStage.setScene(mainScene);
        mainStage.setResizable(false);
        mainStage.setHeight(600); mainStage.setWidth(800);
        mainStage.setTitle("Game Of The Year");

        createButton();
        createBackground();
        createSubScene();

    }

    private void showSubScene(MySubscene subScene){
        if(sceneToHide != null){
            sceneToHide.moveSubscene();
        }
        subScene.moveSubscene();
        sceneToHide=subScene;

    }

    public void createSubScene(){
        StartSubscene = new MySubscene();
        mainPane.getChildren().add(StartSubscene);

        HelpSubscene = new MySubscene();
        mainPane.getChildren().add(HelpSubscene);

        ScoreSubscene = new MySubscene();
        mainPane.getChildren().add(ScoreSubscene);

    }


    public Stage getMainStage(){
        return this.mainStage;
    }

    private void addMenuButton(SpaceRunnerButton button){
        button.setLayoutX(menu_button_start_x);
        button.setLayoutY(menu_button_start_y + menuButton.size()*100);
        menuButton.add(button);
        mainPane.getChildren().add(button);
    }


    private void createButton(){
        createStartButton();
        createScoreButton();
        createHelpButton();
        createExitButton();

    }

    private void createStartButton(){
        SpaceRunnerButton startButton = new SpaceRunnerButton("START");
        addMenuButton(startButton);
        startButton.setOnAction(e -> {
            showSubScene(StartSubscene);
        });
    }

    private void createScoreButton(){
        SpaceRunnerButton scoreButton = new SpaceRunnerButton("SCORES");
        addMenuButton(scoreButton);
        scoreButton.setOnAction(e -> {
            showSubScene(ScoreSubscene);
        });
    }

    private void createHelpButton(){
        SpaceRunnerButton helpButton = new SpaceRunnerButton("HELP");
        addMenuButton(helpButton);

        helpButton.setOnAction(e -> {
            showSubScene(HelpSubscene);
        });

    }

    private void createExitButton(){
        SpaceRunnerButton exitButton = new SpaceRunnerButton("EXIT");
        addMenuButton(exitButton);
        exitButton.setOnAction(e -> {
            mainStage.close();
        });
    }


    private void createBackground(){

        Image backgroubdImage = new Image("view/res/background.png"
                ,800,600,false,false);
        BackgroundImage background = new BackgroundImage(backgroubdImage
                , BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,null);
        mainPane.setBackground(new Background(background));

    }

}
