package org.main.group_assignemnt;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class LayoutController {

    @FXML
    private ImageView car;

    @FXML
    private ImageView maze01;

    @FXML
    private ImageView maze02;

    @FXML
    private ImageView robot;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tab01;

    @FXML
    private Tab tab02;


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
                    robot.setY(robot.getY() - 10);
                    break;
                case S:
                    robot.setY(robot.getY() + 10);
                    break;
                case A:
                    robot.setX(robot.getX() - 10);
                    break;
                case D:
                    robot.setX(robot.getX() + 10);
                    break;
                default:
                    break;
            }
        } else if (selectedTab == tab02) {
            switch (event.getCode()) {
                case W:
                    car.setY(car.getY() - 10);
                    break;
                case S:
                    car.setY(car.getY() + 10);
                    break;
                case A:
                    car.setX(car.getX() - 10);
                    break;
                case D:
                    car.setX(car.getX() + 10);
                    break;
                default:
                    break;
            }
        }
    }

}