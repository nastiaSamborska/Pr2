package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private TextField resultText;

    @FXML
    private TextField x1Text;

    @FXML
    private TextField x2Text;

    @FXML
    private TextField x3Text;

    @FXML
    private TextField x4Text;

    @FXML
    private TextField xText;

    @FXML
    private TextField y1Text;

    @FXML
    private TextField y2Text;

    @FXML
    private TextField y3Text;

    @FXML
    private TextField y4Text;

    @FXML
    private TextField yText;

    @FXML
    private Button countButton;

    @FXML
    private Button clearButton;


    @FXML
    void initialize() {
        countButton.setOnAction((event) -> {
        try {
            int x1 = Integer.parseInt(this.x1Text.getText());
            int y1 = Integer.parseInt(this.y1Text.getText());
            int x2 = Integer.parseInt(this.x2Text.getText());
            int y2 = Integer.parseInt(this.y2Text.getText());
            int x3 = Integer.parseInt(this.x3Text.getText());
            int y3 = Integer.parseInt(this.y3Text.getText());
            int x4 = Integer.parseInt(this.x4Text.getText());
            int y4 = Integer.parseInt(this.y4Text.getText());

            int result1 = (x1 - x2) * (y3 - y4) - (y1 - y2) * (x3 - x4);
            if (result1 == 0){
                resultText.setText("0");
                throw new ArithmeticException("Division by zero");
            }

            int x = ((x1 * y2 - y1 * x2) * (x3 - x4) - (x1 - x2) * (x3 * y4 - y3 * x4)) / result1;
            int y = ((x1 * y2 - y1 * x2) * (y3 - y4) - (y1 - y2) * (x3 * y4 - y3 * x4)) / result1;

            xText.setText(Integer.toString(x));
            yText.setText(Integer.toString(y));
            resultText.setText("1");

        } catch (NumberFormatException | ArithmeticException ex){
            this.x1Text.setTooltip(new Tooltip("Incorrect value"));
            this.y1Text.setTooltip(new Tooltip("Incorrect value"));
            this.x2Text.setTooltip(new Tooltip("Incorrect value"));
            this.y2Text.setTooltip(new Tooltip("Incorrect value"));
            this.x3Text.setTooltip(new Tooltip("Incorrect value"));
            this.y3Text.setTooltip(new Tooltip("Incorrect value"));
            this.x4Text.setTooltip(new Tooltip("Incorrect value"));
            this.y4Text.setTooltip(new Tooltip("Incorrect value"));
        }

        });

        clearButton.setOnAction((event) -> {
            xText.clear();
            yText.clear();
            x1Text.clear();
            y1Text.clear();
            x2Text.clear();
            y2Text.clear();
            x3Text.clear();
            y3Text.clear();
            x4Text.clear();
            y4Text.clear();
            resultText.clear();

        });
    }
}
