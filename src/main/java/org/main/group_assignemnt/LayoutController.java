package org.main.group_assignemnt;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.input.KeyEvent;
import javafx.event.ActionEvent;
import javafx.scene.paint.Color;

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
    void solveMaze(ActionEvent event) {


    }
    @FXML
    void movement(KeyEvent event) {
        Tab selectedTab = tabPane.getSelectionModel().getSelectedItem();
        ImageView character;
        ImageView maze;

        if (selectedTab == tab01) {
            character = characterImage01;
            maze = maze01;
        } else if (selectedTab == tab02) {
            character = characterImage02;
            maze = maze02;
        } else {
            return; // No valid tab selected
        }

        double newX = character.getX();
        double newY = character.getY();

        switch (event.getCode()) {
            case W: // Move Up
                newY -= 10;
                character.setRotate(0);
                break;
            case S: // Move Down
                newY += 10;
                character.setRotate(180);
                break;
            case A: // Move Left
                newX -= 10;
                character.setRotate(270);
                break;
            case D: // Move Right
                newX += 10;
                character.setRotate(90);
                break;
            default:
                return; // Ignore other keys
        }

        // Check if the next position is a valid white pixel before moving
        if (isWhitePixel(maze, (int) newX, (int) newY)) {
            character.setX(newX);
            character.setY(newY);
        }
    }


    private boolean isWhitePixel(ImageView maze, int x, int y) {
        Image mazeImage = maze.getImage();
        PixelReader pixelReader = mazeImage.getPixelReader();

        if (pixelReader == null || x < 0 || y < 0 || x >= mazeImage.getWidth() || y >= mazeImage.getHeight()) {
            return false; // Out of bounds
        }

        Color color = pixelReader.getColor(x, y);
        return color.getRed() > 0.9 && color.getGreen() > 0.9 && color.getBlue() > 0.9; // White pixel check
    }


}