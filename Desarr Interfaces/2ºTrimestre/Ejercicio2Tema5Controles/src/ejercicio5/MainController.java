package ejercicio5;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private MenuBar menuBar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Manejar eventos para las opciones del menú "File"
        Menu fileMenu = getMenuByName("File");
        MenuItem newMenuItem = createMenuItem("New");
        MenuItem printMenuItem = createMenuItem("Print");
        MenuItem propertiesMenuItem = createMenuItem("Properties");

        fileMenu.getItems().addAll(newMenuItem, printMenuItem, propertiesMenuItem);

        // Manejar eventos para las opciones del menú "Edit"
        Menu editMenu = getMenuByName("Edit");
        MenuItem undoMenuItem = createMenuItem("Undo");
        MenuItem redoMenuItem = createMenuItem("Redo");

        editMenu.getItems().addAll(undoMenuItem, redoMenuItem);

        // Añadir una nueva categoría "View" y opciones
        Menu viewMenu = new Menu("View");
        MenuItem zoomInMenuItem = createMenuItem("Zoom In");
        MenuItem zoomOutMenuItem = createMenuItem("Zoom Out");
        MenuItem toggleFullscreenMenuItem = createMenuItem("Toggle Fullscreen");

        viewMenu.getItems().addAll(zoomInMenuItem, zoomOutMenuItem, toggleFullscreenMenuItem);

        // Agregar la categoría "View" al menú principal
        menuBar.getMenus().add(viewMenu);
    }

    // Método para manejar eventos de las opciones del menú
    @FXML
    private void handleMenuItemAction(ActionEvent event) {
        MenuItem menuItem = (MenuItem) event.getSource();
        String category = getCategory(menuItem);
        String option = menuItem.getText();
        System.out.println("Categoría seleccionada: " + category);
        System.out.println("Opción seleccionada: " + option);

        // Puedes personalizar el mensaje en la consola o realizar acciones específicas aquí.
        // Por ejemplo, mostrar un cuadro de diálogo de información:
        showAlert("Opción Seleccionada", "Categoría: " + category, "Opción: " + option);
    }

    // Método para buscar una categoría por nombre en el menú
    private Menu getMenuByName(String name) {
        for (Menu menu : menuBar.getMenus()) {
            if (menu.getText().equals(name)) {
                return menu;
            }
        }
        return null;
    }

    // Método para crear un nuevo MenuItem y manejar su evento
    private MenuItem createMenuItem(String name) {
        MenuItem menuItem = new MenuItem(name);
        menuItem.setOnAction(this::handleMenuItemAction);
        return menuItem;
    }

    // Método para obtener la categoría de un MenuItem
    private String getCategory(MenuItem menuItem) {
        for (Menu menu : menuBar.getMenus()) {
            for (MenuItem item : menu.getItems()) {
                if (item == menuItem) {
                    return menu.getText();
                }
            }
        }
        return null;
    }

    // Método para mostrar un cuadro de diálogo de información
    private void showAlert(String title, String header, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
