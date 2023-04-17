/*
* A Java GUI App to check if
* Entered string is in order or no based on alphabetical order
*/


package com.example.StringOrder;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application
{
    private Group root;
    private Scene scene;
    private final Button [] btn=new Button[2];
    private final Label [] lbl=new Label[2];
    private TextField txt;
    public void start(Stage stage)
    {
        sceneDesign();
        stage.setScene(scene);
        stage.setTitle("String Order");
        stage.show();
    }
    public void labelDesign()
    {
        lbl[0]=new Label();
        lbl[0].setLayoutX(100);
        lbl[0].setLayoutY(100);
        lbl[0].setText("Enter Any Word : ");
        lbl[0].setFont(Font.font(20));
        lbl[1]=new Label();
        lbl[1].setLayoutX(100);
        lbl[1].setLayoutY(300);
        lbl[1].setText("Result is ");
        lbl[1].setFont(Font.font(20));
    }
    public void textFiledDesign()
    {
        txt = new TextField();
        txt.setLayoutX(100);
        txt.setLayoutY(150);
        txt.setMinWidth(230);
        txt.setMinHeight(30);
    }
    public void buttonDesign()
    {
        btn[0] = new Button("Check");
        btn[0].setLayoutX(100);
        btn[0].setLayoutY(230);
        btn[0].setTextFill(Paint.valueOf("black"));
        btn[0].setMinHeight(30);
        btn[0].setMinWidth(80);
        btn[0].setId("But");
        btn[0].setOnAction(e-> checkAction());
        btn[1] = new Button("Clear");
        btn[1].setLayoutX(250);
        btn[1].setLayoutY(230);
        btn[1].setTextFill(Paint.valueOf("black"));
        btn[1].setMinHeight(30);
        btn[1].setMinWidth(80);
        btn[1].setOnAction(e-> clearAction());
    }
    public void groupDesign()
    {
        root=new Group();
        root.getChildren().addAll(btn[0],btn[1],txt,lbl[0],lbl[1]);
    }
    public void sceneDesign()
    {
        labelDesign();
        textFiledDesign();
        buttonDesign();
        groupDesign();
        scene = new Scene(root, 500, 500);
        scene.setFill(Paint.valueOf("#008080"));
    }
    public void checkAction()
    {
        String res = Boolean.toString(isInOrder());
        lbl[1].setText("Result is "+ "" + res);
    }
    public void clearAction()
    {
        txt.setText("");
        lbl[1].setText("Result is");
    }
    public boolean isInOrder()
    {
        String stmt = txt.getText();
        boolean state=false;
        for (int i = 0;i<stmt.length()-1;i++)
        {
            if(stmt.charAt(i)==' '||stmt.charAt(i+1)==' ')
            {
                continue;
            }
            else if((int)stmt.charAt(i)<=(int)stmt.charAt(i+1))
            {
                state=true;
            }
            else
            {
                state=false;
                break;
            }
        }
        return state;
    }
    public static void main(String[] args)
    {
        launch();
    }
}