package org.main.group_assignemnt;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;

public class LayoutController {

    @FXML
    private Button ChangeBtn;

    @FXML
    private Button autoSolveBtn;

    @FXML
    private MenuItem carSelect;

    @FXML
    private Button changeBtn;

    @FXML
    private ImageView characterImage01;

    @FXML
    private ImageView characterImage02;

    @FXML
    private ImageView maze01;

    @FXML
    private ImageView maze02;

    @FXML
    private MenuButton menuSelect;

    @FXML
    private MenuItem robotSelect;

    @FXML
    private Tab tab01;

    @FXML
    private Tab tab02;

    @FXML
    private TabPane tabPane;


    @FXML
    void changeCharacters(ActionEvent event) {
        System.out.println("Selected: " + menuSelect.getText()); // Debugging

        String imagePath = null;

        if (menuSelect.getText().equals(carSelect.getText())) {
            System.out.println("Switching to Car");
            imagePath = "/org/main/group_assignemnt/Images/car.png"; // Classpath-relative
        } else if (menuSelect.getText().equals(robotSelect.getText())) {
            System.out.println("Switching to Robot");
            imagePath = "/org/main_group_assignemnt/Images/robot.png"; // Classpath-relative
        } else {
            System.out.println("No matching selection found.");
        }

        if (imagePath != null) {
            java.net.URL imageUrl = getClass().getResource(imagePath);
            if (imageUrl == null) {
                System.out.println("Error: Image not found at " + imagePath);
            } else {
                characterImage01.setImage(new Image(imageUrl.toExternalForm()));
                System.out.println("Image loaded successfully!");
            }
        }
    }




    @FXML
    void selectCar(ActionEvent event) {
        menuSelect.setText(carSelect.getText());
        System.out.println("Car selected");
    }

    @FXML
    void selectRobot(ActionEvent event) {
        menuSelect.setText(robotSelect.getText());
        System.out.println("Robot selected");
    }



    @FXML
    public void initialize() {
        tabPane.setOnKeyPressed(event -> movement(event));
    }


    @FXML
    void movement(KeyEvent event) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        if (selectedTab == tab01) {
            switch (event.getCode()) {
                case W:
                    characterImage01.setY(characterImage01.getY() - 10);
                    characterImage01.setRotate(0);

                    break;
                case S:
                    characterImage01.setY(characterImage01.getY() + 10);
                    characterImage01.setRotate(180);
                    break;
                case A:
                    characterImage01.setX(characterImage01.getX() - 10);
                    characterImage01.setRotate(270);
                    break;
                case D:
                    characterImage01.setX(characterImage01.getX() + 10);
                    characterImage01.setRotate(90);
                    break;
                default:
                    break;
            }
        } else if (selectedTab == tab02) {
            switch (event.getCode()) {
                case W:
                    characterImage02.setY(characterImage02.getY() - 10);
                    characterImage02.setScaleY(1);
                    characterImage02.setRotate(270);
                    break;
                case S:
                    characterImage02.setY(characterImage02.getY() + 10);
                    characterImage02.setScaleY(1);
                    characterImage02.setRotate(90);
                    break;
                case A:
                    characterImage02.setX(characterImage02.getX() - 10);
                    characterImage02.setScaleY(-1);
                    characterImage02.setRotate(180);
                    break;
                case D:
                    characterImage02.setX(characterImage02.getX() + 10);
                    characterImage02.setScaleY(1);
                    characterImage02.setRotate(0);
                    break;
                default:
                    break;
            }
        }
    }

}