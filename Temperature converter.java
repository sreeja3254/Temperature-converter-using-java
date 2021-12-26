package application;
import javafx.scene.Scene; 
import javafx.application.Application; 
import javafx.geometry.Insets; 
import javafx.event.EventHandler;  
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 
import javafx.scene.input.MouseEvent; 
import javafx.scene.control.ToggleGroup;
public class Main extends Application { 
   @Override 
   public void start(Stage stage) {      
   Label l1=new Label("Enter the temparature ");
   TextField tf1=new TextField();
   ToggleGroup gr1 = new ToggleGroup();
   ToggleGroup gr2 = new ToggleGroup();
   Label l2=new Label("Choose the option that u want to convert from ");
   RadioButton r1=new RadioButton("Celsius");
   RadioButton r2=new RadioButton("Kelvin");
   RadioButton r3=new RadioButton("Farenheit");
   r1.setToggleGroup(gr1);
   r2.setToggleGroup(gr1);
   r3.setToggleGroup(gr1);
   Label l3=new Label("Choose the option that u want to convert to");
   RadioButton r4=new RadioButton("Celsius");
   RadioButton r5=new RadioButton("Kelvin");
   RadioButton r6=new RadioButton("Farenheit");
   r4.setToggleGroup(gr2);
   r5.setToggleGroup(gr2);
   r6.setToggleGroup(gr2);
   Button b1=new Button("CALCULATE");
   Button b2=new Button("CLEAR");b2.setId("b2");
   Label l4=new Label("RESULT");
   Label l5=new Label("TEMPERATURE CONVERTER");
   //l5.setPadding();
   l5.setTranslateX(10);l5.setTranslateY(-25);l5.setId("l5");
   TextField tf2=new TextField();
   HBox h1=new HBox(10);
   HBox h2=new HBox(10);
   HBox h3=new HBox(60);
   b1.setOnMouseClicked(new EventHandler<MouseEvent >() {
	   @Override
	   public void handle(MouseEvent event) {
	   Double temp;
	   if(r1.isSelected() && r5.isSelected()) {
		   temp=Double.parseDouble(tf1.getText())+273.15;
		   tf2.setText(String.valueOf(temp));}
	   else if(r1.isSelected() && r6.isSelected()) {
		   temp=(Double.parseDouble(tf1.getText())*1.8)+32;
		   tf2.setText(String.valueOf(temp));}
	   else if(r2.isSelected() && r4.isSelected()) {
		   temp=Double.parseDouble(tf1.getText())-273.15;
		   tf2.setText(String.valueOf(temp));}
	   else if(r2.isSelected() && r6.isSelected()) {
		   temp=(Double.parseDouble(tf1.getText())-273.15)*1.8+32;
		   tf2.setText(String.valueOf(temp));}
	   else if(r3.isSelected() && r4.isSelected()) {
		   temp=(Double.parseDouble(tf1.getText())-32)/1.8;
		   tf2.setText(String.valueOf(temp));}
	   else if(r3.isSelected() && r5.isSelected()) {
		   temp=(((Double.parseDouble(tf1.getText())-32)*5)/9)+273.15;
		   tf2.setText(String.valueOf(temp));}
	   } });
   b2.setOnMouseClicked(new EventHandler<MouseEvent>(){
	   public void handle(MouseEvent event) {
		   tf1.setText(null);tf2.setText(null);
		   RadioButton rb1=(RadioButton) gr1.getSelectedToggle();rb1.setSelected(false);
		   RadioButton rb2=(RadioButton) gr2.getSelectedToggle();rb2.setSelected(false); }
   });
   VBox v1=new VBox(10);
   v1.setPadding(new Insets(250,250,400,550));
   h1.getChildren().addAll(l1,tf1);
   h2.getChildren().addAll(l4,tf2);
   h3.getChildren().addAll(b1,b2);
   v1.getChildren().addAll(l5,h1,l2,r1,r2,r3,l3,r4,r5,r6,h3,h2);
   //setting ids
   l1.setId("l1");
   l2.setId("l2"); l3.setId("l3");l4.setId("l4");
   r1.setId("r1");r2.setId("r2");r3.setId("r3");
   r4.setId("r4");r5.setId("r5");r6.setId("r6");
   tf1.setId("tf1");tf2.setId("tf2");b1.setId("b1");
   tf1.setPrefWidth(140); tf2.setPrefWidth(140);
   tf1.setPrefHeight(35);b1.setPrefWidth(150);b2.setPrefWidth(100);
   tf2.setPrefHeight(35);b1.setPrefHeight(35);b2.setPrefHeight(35);
   v1.setId("VBOX");h1.setId("HBOX");
   Scene scene = new Scene(v1,700,700);
   stage.setTitle("Temparature Converter");
  scene.getStylesheets().add("practice.css");
   stage.setScene(scene);
   stage.show();
   }
	   public static void main(String args[]){ 
		      launch(args); 
		   } }