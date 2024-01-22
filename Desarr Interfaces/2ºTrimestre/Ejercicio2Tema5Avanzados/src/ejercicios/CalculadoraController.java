package ejercicios;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculadoraController {

    @FXML
    private TextField display;

    private double result = 0;
    private String operator = "";
    private boolean start = true;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (start) {
            display.setText("");
            start = false;
        }

        String value = ((Button) event.getSource()).getText();
        if (value.matches("[0-9.]")) {
            display.appendText(value);
        } else {
            if (!"=".equals(value)) {
                if (!operator.isEmpty()) {
                    return;
                }
                operator = value;
                result = Double.parseDouble(display.getText());
                display.setText("");
            } else {
                if (operator.isEmpty()) {
                    return;
                }
                calculate(Double.parseDouble(display.getText()));
                operator = "";
                start = true;
            }
        }
    }

    private void calculate(double number) {
        switch (operator) {
            case "+":
                result += number;
                break;
            case "-":
                result -= number;
                break;
            case "*":
                result *= number;
                break;
            case "/":
                if (number == 0) {
                    display.setText("Error");
                    return;
                }
                result /= number;
                break;
        }
        display.setText(String.valueOf(result));
    }
}
