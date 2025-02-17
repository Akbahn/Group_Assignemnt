module org.main.group_assignemnt {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.main.group_assignemnt to javafx.fxml;
    exports org.main.group_assignemnt;
}