package controllers.SwitchScenesControllers;
import io.ProductBaseReader;
import io.YourProductBaseIO;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.util.List;
import java.util.stream.Collectors;

public class EditPaneController {

    @FXML
    private AnchorPane editPaneController;
    @FXML
    private Label carbohydratesPieCharLabelController;
    @FXML
    private Button addProductToListViewButtonController;
    @FXML
    private Label fatPieCharLabelController;
    @FXML
    private PieChart pieChartController;
    @FXML
    private Label proteinsPieCharLabelController;
    @FXML
    private TextField weightTextFieldController;
    @FXML
    private ListView<String> productsBaseListView;
    @FXML
    private Button searchButtonController;
    @FXML
    private TextField searchTextFieldController;
    @FXML
    private Button changeListViewButtonController;
    private List<String> listview;
    private static final String CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT = "personal products";
    private static final String CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT = "product base";
    private static final String ADD_BUTTON_FILE_PATH = "/img/add-button.jpg";

    public void initialize() {
        setAllImages();
        listview = ProductBaseReader.readProductBase();
        addProductToListView(listview);
        setTextFieldOnlyNumeric(weightTextFieldController);
        changeListView();
        searchProduct();
    }
    public PieChart getPieChartController() {
        return pieChartController;
    }
    public Label getProteinsPieCharLabelController() {
        return proteinsPieCharLabelController;
    }
    public Label getCarbohydratesPieCharLabelController() {
        return carbohydratesPieCharLabelController;
    }
    public Label getFatPieCharLabelController() {
        return fatPieCharLabelController;
    }

    public ListView<String> getProductsBaseListView() {
        return productsBaseListView;
    }
    public Button getAddProductToListViewButtonController() {
        return addProductToListViewButtonController;
    }

    public TextField getWeightTextFieldController() {
        return weightTextFieldController;
    }

    public Button getChangeListViewButtonController() {
        return changeListViewButtonController;
    }

    private void setAllImages() {
        setImage(addProductToListViewButtonController);
    }
    private void setImage(Button button) {
        ImageView imageView = new ImageView(getClass().getResource(ADD_BUTTON_FILE_PATH).toExternalForm());
        button.setGraphic(imageView);
    }
    private void setTextFieldOnlyNumeric(TextField textField) {
        textField.textProperty().addListener((observableValue, oldValue, newValue) -> {
            if (textField.getText()!=null && newValue.length()>0) {
                if (String.valueOf(newValue.charAt(0)).matches("\\D")) {
                    textField.setText("");
                }
                else if (!(String.valueOf(newValue.charAt(newValue.length()-1)).matches("\\D")) || newValue.charAt(newValue.length()-1)=='.') {
                    if (newValue.charAt(newValue.length()-1)=='.' && newValue.charAt(newValue.length()-2)=='.') {
                        textField.setText(oldValue);
                    }
                    else if (newValue.length()>1 && newValue.substring(0,newValue.length()-2).contains(".")) textField.setText(oldValue);
                }
                else {
                    textField.setText(oldValue);
                }
            }
        });
    }
   private void addProductToListView(List<String> list) {
       productsBaseListView.getItems().clear();
       productsBaseListView.getItems().addAll(list);
   }
   private void searchProduct() {
        if (changeListViewButtonController.getText().equals(CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT)) searchProductInList();
        else if (changeListViewButtonController.getText().equals(CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT)) searchProductInList();
   }
   private void searchProductInList() {
       searchTextFieldController.addEventHandler(KeyEvent.ANY, keyEvent -> {
                   if (searchTextFieldController == null) addProductToListView(listview);
                   else if (searchTextFieldController.getText().equals("")) addProductToListView(listview);
                   else addProductToListView(listview.stream().filter(s -> s.toLowerCase().contains(searchTextFieldController.getText())).collect(Collectors.toList()));
               }
       );}
    private void changeListView() {
        changeListViewButtonController.addEventFilter(MouseEvent.MOUSE_CLICKED,mouseEvent -> {
            if (changeListViewButtonController.getText().equals(CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT))
                setListView(YourProductBaseIO.readProductBase(),CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT);
            else if (changeListViewButtonController.getText().equals(CHANGE_TO_MAIN_PRODUCT_BASE_BUTTON_TEXT))
                setListView(ProductBaseReader.readProductBase(),CHANGE_TO_YOUR_PRODUCTS_BASE_BUTTON_TEXT);
        });
    }
    private void setListView(List<String> listView, String buttonText) {
        this.listview = listView;
        addProductToListView(listview);
        changeListViewButtonController.setText(buttonText);
    }
}