module pl.polsl.lab.javafx_calculation {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens pl.polsl.lab.javafx_calculation to javafx.fxml;
    exports pl.polsl.lab.javafx_calculation;
}
