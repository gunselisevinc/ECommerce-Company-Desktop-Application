package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import javafx.event.ActionEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    @FXML
    private Tab phoneTab;
    @FXML
    private Tab computerTab;
    @FXML
    private ComboBox<String> phoneModelComboBox;
    @FXML
    private ComboBox<String>  phoneBrandComboBox;
    @FXML
    private ComboBox<String>  computerModelComboBox;
    @FXML
    private ComboBox<String>  computerBrandComboBox;
    @FXML
    private Button getProductsButton;
    @FXML
    private Button sortPriceButton;
    @FXML
    private Button compareButton;
    @FXML
    private TableView<Object> productListView;
    @FXML
    private TableColumn<Object,Float> priceColumn;
    @FXML
    private TableColumn<Object,String> featureColumn;
    @FXML
    private TableColumn<Object,String> productColumn;
    @FXML
    private TableView<Object> compareTable;
    @FXML
    private TableColumn<Object,String> computerBrand;
    @FXML
    private TableColumn<Object,Float> computerPrice;
    @FXML
    private TableColumn<Object,String> computerScreenSize;
    @FXML
    private TableColumn<Object,String> computerModel;
    @FXML
    private TableColumn<Object,String> screenResolution;
    @FXML
    private TableColumn<Object,String> processor;
    @FXML
    private TableColumn<Object,String> memory;
    @FXML
    private TableColumn<Object,String> storageCapacity;
    
    ArrayList<Computers> allComputers = new ArrayList<>();
    ArrayList<Phones> allPhones = new ArrayList<>();
    ArrayList<Product> allproducts = new ArrayList<>();
    Product myProduct2;
    public void getProductsButtonPressed(ActionEvent event) throws IOException, ParseException {
        productListView.getItems().clear();
        //System.out.println(phoneBrandComboBox.getValue());
        String url="http://localhost:8080/";
        if(computerTab.isSelected())
            url+="getAllComputer";
        else
            url+="getAllPhone";
        String response ="";
        HttpURLConnection connection= (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        int responseCode  =connection.getResponseCode();
        //System.out.println(responseCode);
        if(responseCode == 200){
            Scanner scanner = new Scanner(connection.getInputStream());
            //System.out.println("while e girmek uzereyim");
            //System.out.println(scanner.hasNextLine());
            boolean x = scanner.hasNextLine();
            while (scanner.hasNextLine())
            {
                //System.out.println("while icerisindeyim");
                response += scanner.nextLine();
                response += "\n";
            }
            //System.out.println("while ciktim");
            scanner.close();
        }
        //System.out.println(responseCode);
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(response);
        JSONArray array =(JSONArray) obj;
        String productList ="";

        if(computerTab.isSelected()) {
            String selectedBrand = computerBrandComboBox.getValue();
            String selectedModel = computerModelComboBox.getValue();
            if(selectedBrand==null)
                selectedBrand = "no";
            if(selectedModel==null)
                selectedModel="no";
            for (int i = 0; i < array.size(); i++) {
                JSONObject temp = (JSONObject) array.get(i);
                if((selectedBrand.equals(temp.get("computerBrand"))) || selectedModel.equals(temp.get("computerModel"))) {
                    Product myProduct = new Product();
                    Computers c1 = new Computers();
                    c1.setComputerBrand((String) temp.get("computerBrand"));
                    c1.setComputerModel((String) temp.get("computerModel"));
                    c1.setComputerPrice((Double) temp.get("computerPrice"));
                    c1.setComputerScreenSize((String) temp.get("computerScreenSize"));
                    c1.setMemory((String) temp.get("memory"));
                    c1.setProcessor((String) temp.get("processor"));
                    c1.setScreenResolution((String) temp.get("screenResolution"));
                    c1.setStorageCapacity((String) temp.get("storageCapacity"));
                    allComputers.add(c1);
                    myProduct.setProductColumn((String) temp.get("computerBrand"));
                    String memory = (((String) (temp.get("memory"))).replaceAll("[^0-9]", ""));
                    String storage = (((String) (temp.get("storageCapacity"))).replaceAll("[^0-9]", ""));
                    int intmemory = Integer.parseInt(memory);
                    int intstorage = Integer.parseInt(storage);
                    String text = "";
                    if (intmemory >= 16)
                        text += "Large Memory, ";
                        //myProduct.setFeatureColumn("Large Memory");
                    else
                        text += "Small Memory, ";
                    //myProduct.setFeatureColumn("Small Memory");
                    if (intstorage >= 1 && intstorage <= 100)
                        text += "Large Storage";
                    else
                        text += "Small Storage";
                    myProduct.setFeatureColumn(text);
                    myProduct.setPriceColumn((Double) temp.get("computerPrice"));
                    allproducts.add(myProduct);
                }
                //productList += temp.get("computerBrand")+" "+temp.get("computerModel")+" "+temp.get("computerPrice");
                //productList += "\n";
            }

            //System.out.println(productList);
            ObservableList<Object> products = FXCollections.observableArrayList(allproducts);


            productListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            productColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("productColumn"));
            featureColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("featureColumn"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Object, Float>("priceColumn"));
            productListView.setItems(products);
        }

        else if(phoneTab.isSelected()) {
            String selectedBrand = phoneBrandComboBox.getValue();
            String selectedModel = phoneModelComboBox.getValue();
            if(selectedBrand==null)
                selectedBrand = "no";
            if(selectedModel==null)
                selectedModel="no";
            for (int i = 0; i < array.size(); i++) {

                JSONObject temp = (JSONObject) array.get(i);

                //System.out.println(selectedBrand);
                //System.out.println(selectedModel);
                if((selectedBrand.equals(temp.get("phone_brand"))) || selectedModel.equals(temp.get("phone_model"))) {
                    //System.out.println("if deyimmm");
                    Product myProduct = new Product();
                    Phones p1 = new Phones();
                    p1.setComputerBrand((String) temp.get("phone_brand"));
                    p1.setComputerModel((String) temp.get("phone_model"));
                    p1.setComputerPrice((Double) temp.get("price"));
                    p1.setComputerScreenSize((String) temp.get("phone_screenSize"));
                    p1.setScreenResolution((String) temp.get("phone_internalMemory"));
                    allPhones.add(p1);

                    myProduct.setProductColumn((String) temp.get("phone_model"));
                    String memory = (((String) (temp.get("phone_internalMemory"))).replaceAll("[^0-9]", ""));
                    String screen = (((String) (temp.get("phone_screenSize"))));
                    int intmemory = Integer.parseInt(memory);
                    double doublescreen = Double.parseDouble(screen);
                    String text = "";
                    if (intmemory >= 128)
                        text += "Large Storage, ";
                        //myProduct.setFeatureColumn("Large Memory");
                    else
                        text += "Small Storage, ";
                    //myProduct.setFeatureColumn("Small Memory");
                    if (doublescreen >= 6.0)
                        text += "Large Screen";
                    else
                        text += "Small Screen";
                    myProduct.setFeatureColumn(text);
                    myProduct.setPriceColumn((Double) temp.get("price"));
                    allproducts.add(myProduct);
                }
                //productList += temp.get("computerBrand")+" "+temp.get("computerModel")+" "+temp.get("computerPrice");
                //productList += "\n";
            }

            //System.out.println(productList);

            ///////////////////////limit burdan sonra listeye cekiyor////////////////////////////////////////////////////
            ObservableList<Object> products = FXCollections.observableArrayList(allproducts);
            productListView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            productColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("productColumn"));
            featureColumn.setCellValueFactory(new PropertyValueFactory<Object, String>("featureColumn"));
            priceColumn.setCellValueFactory(new PropertyValueFactory<Object, Float>("priceColumn"));
            productListView.setItems(products);
            allproducts.clear();
        }
    }



    public void funButtonPressed(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("HOCAM HI !");
        alert.setHeaderText("Hocam Please Inspect Our Codes Detailly");
        alert.setContentText("We have written this project on high level and very dynamic. I hope we get good grade ! Love you hocam Kolay Gelsin :) Hocam btw if you have problem on running the code, please ask for demo ");
        alert.show();
    }

    public void compareButtonPressed(ActionEvent event1){
        

        System.out.println(allComputers);
        System.out.println(allPhones);
        if(computerTab.isSelected()) {
            ObservableList<Object> computers = FXCollections.observableArrayList(allComputers);
            computerBrand.setCellValueFactory(new PropertyValueFactory<Object, String>("computerBrand"));
            computerPrice.setCellValueFactory(new PropertyValueFactory<Object, Float>("computerPrice"));
            computerScreenSize.setCellValueFactory(new PropertyValueFactory<Object, String>("computerScreenSize"));
            computerModel.setCellValueFactory(new PropertyValueFactory<Object, String>("computerModel"));
            screenResolution.setCellValueFactory(new PropertyValueFactory<Object, String>("screenResolution"));
            processor.setCellValueFactory(new PropertyValueFactory<Object, String>("processor"));
            memory.setCellValueFactory(new PropertyValueFactory<Object, String>("memory"));
            storageCapacity.setCellValueFactory(new PropertyValueFactory<Object, String>("storageCapacity"));
            compareTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            compareTable.setItems(computers);
        }
        else{
            ObservableList<Object> phones = FXCollections.observableArrayList(allPhones);
            computerBrand.setCellValueFactory(new PropertyValueFactory<Object, String>("computerBrand"));
            computerScreenSize.setCellValueFactory(new PropertyValueFactory<Object, String>("computerScreenSize"));
            computerModel.setCellValueFactory(new PropertyValueFactory<Object, String>("computerModel"));
            screenResolution.setCellValueFactory(new PropertyValueFactory<Object, String>("screenResolution"));
            screenResolution.setText("Internal Memory");
            processor.setCellValueFactory(new PropertyValueFactory<Object, String>("computerPrice"));
            processor.setText("Price");
            memory.setCellValueFactory(new PropertyValueFactory<Object, String>("memory"));
            memory.setText("");
            storageCapacity.setCellValueFactory(new PropertyValueFactory<Object, String>("storageCapacity"));
            storageCapacity.setText("");
            computerPrice.setCellValueFactory(new PropertyValueFactory<Object, Float>("ali"));
            computerPrice.setText("");
            compareTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
            compareTable.setItems(phones);

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        if(true) {
            String url1 = "http://localhost:8080/";
            if (computerTab.isSelected())
                url1 += "getAllComputer";
            else
                url1 += "getAllPhone";
            String response = "";
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) new URL("http://localhost:8080/getAllComputer").openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            int responseCode = 0;
            try {
                responseCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (responseCode == 200) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(connection.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean x = scanner.hasNextLine();
                while (scanner.hasNextLine()) {
                    response += scanner.nextLine();
                    response += "\n";
                }
                scanner.close();
            }

            JSONParser parser = new JSONParser();
            Object obj = null;
            try {
                obj = parser.parse(response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONArray array = (JSONArray) obj;
            ArrayList<String> computermodelcombo = new ArrayList<>();
            ArrayList<String> computerbrandcombo = new ArrayList<>();


            for (int i = 0; i < array.size(); i++) {
                JSONObject temp = (JSONObject) array.get(i);
                computermodelcombo.add((String) temp.get("computerModel"));
                computerbrandcombo.add((String) temp.get("computerBrand"));
            }

            computerBrandComboBox.getItems().addAll(computerbrandcombo);
            computerModelComboBox.getItems().addAll(computermodelcombo);
        }

        if(true) {
            String url1 = "http://localhost:8080/";
            if (computerTab.isSelected())
                url1 += "getAllComputer";
            else
                url1 += "getAllPhone";
            String response = "";
            HttpURLConnection connection = null;
            try {
                connection = (HttpURLConnection) new URL("http://localhost:8080/getAllPhone").openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                connection.setRequestMethod("GET");
            } catch (ProtocolException e) {
                e.printStackTrace();
            }
            int responseCode = 0;
            try {
                responseCode = connection.getResponseCode();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (responseCode == 200) {
                Scanner scanner = null;
                try {
                    scanner = new Scanner(connection.getInputStream());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                boolean x = scanner.hasNextLine();
                while (scanner.hasNextLine()) {
                    response += scanner.nextLine();
                    response += "\n";
                }
                scanner.close();
            }
            JSONParser parser = new JSONParser();
            Object obj = null;
            try {
                obj = parser.parse(response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            JSONArray array = (JSONArray) obj;
            ArrayList<String> phonemodelcombo = new ArrayList<>();
            ArrayList<String> phonebrandcombo = new ArrayList<>();

            for (int i = 0; i < array.size(); i++) {
                JSONObject temp = (JSONObject) array.get(i);
                phonemodelcombo.add((String) temp.get("phone_model"));
                phonebrandcombo.add((String) temp.get("phone_brand"));
            }

            phoneBrandComboBox.getItems().addAll(phonebrandcombo);
            phoneModelComboBox.getItems().addAll(phonemodelcombo);
        }

    }

}
