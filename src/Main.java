import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.clockIn;
import model.even;

import java.awt.event.InputEvent;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import static javafx.scene.input.MouseButton.PRIMARY;
import static javafx.scene.input.MouseButton.SECONDARY;

public class Main extends Application {
    @FXML
    private MenuBar menubar;


    @FXML
    private TableColumn<clockIn, String> datecol;


    @FXML
    private TableView<clockIn> clockinTableview;

    @FXML
    private Button clockInButton;

    @FXML
    private Button deleteClockInButton;

    @FXML
    private TableView<even> eventTableview;

    @FXML
    private TableColumn<clockIn, String> clockin;

    @FXML
    private ImageView image;

    private ObservableList<clockIn> data1 = FXCollections.observableArrayList();
    private ObservableList<even> data2 = FXCollections.observableArrayList();

    @FXML
    void handleClockIn(ActionEvent event) throws IOException {
        if (clockinTableview.getItems().size() == 0) {
            String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            data1.add(new clockIn(0, time));
            BufferedWriter br=new BufferedWriter(new FileWriter(new File("src/record/log.txt"),true));
            br.write("0"+","+time+"\n");
            br.close();
            clockinTableview.refresh();
        } else {
            int number = clockinTableview.getItems().get((clockinTableview.getItems().size() - 1)).getNumber();
            number++;
            String time=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
            data1.add(new clockIn(number,time));
            BufferedWriter br=new BufferedWriter(new FileWriter(new File("src/record/log.txt"),true));
            br.write(number+","+time+"\n");
            br.close();
        }


    }

    @FXML
    void handleDelete(ActionEvent event) throws IOException {
        if (clockinTableview.getItems().size() > 0) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Dialog");
            alert.setHeaderText("Look, a Confirmation Dialog");
            alert.setContentText("Are you ok with this?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                clockinTableview.getItems().remove(clockinTableview.getItems().size() - 1);
            } else {
            }

            BufferedReader bufferedReader=new BufferedReader(new FileReader(new File("src/record/log.txt")));
            String line="";
            ArrayList<String> list=new ArrayList<>();
            while (((line=bufferedReader.readLine())!=null)){
                list.add(line);
            }
            bufferedReader.close();
            new File("src/record/log.txt").delete();
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(new File("src/record/log.txt"),true));
            for (int i = 0; i < list.size() - 1; i++) {
                bufferedWriter.write(list.get(i)+"\n");
            }
            bufferedWriter.close();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("没有数据");
            alert.showAndWait();
        }
    }


    @FXML
    void initialize() {
        datecol.setCellValueFactory(new PropertyValueFactory("number"));
        clockin.setCellValueFactory(new PropertyValueFactory("date"));
        clockinTableview.setItems(data1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file=new File("src/image");
                File[] fileArr=file.listFiles();
                int index=0;
                while (true){
                   if(index==fileArr.length){
                       index=index-fileArr.length;
                   }
                   image.setImage(new Image(fileArr[index].toURI().toString()));
                   index++;
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/main.fxml"));
        primaryStage.setTitle("Date");
        primaryStage.setScene(new Scene(root, 800, 476));
        primaryStage.centerOnScreen();
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}