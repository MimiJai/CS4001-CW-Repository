import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GadgetShop extends Application
{
    // Text fields
    // Text fields are used for user input
    // The user types values such as model, price, phone number, and duration here
    // The program reads these values when a button is clicked
    private final TextField modelField = new TextField();
    private final TextField priceField = new TextField();
    private final TextField weightField = new TextField();
    private final TextField sizeField = new TextField();
    private final TextField creditField = new TextField();
    private final TextField memoryField = new TextField();
    private final TextField phoneNumberField = new TextField();
    private final TextField durationField = new TextField();
    private final TextField downloadSizeField = new TextField();
    private final TextField displayNumberField = new TextField();

    // Text area and ArrayList
    // The text area is used to display messages and results to the user
    // It shows things like added gadgets or call information
    // The ArrayList is used to store all gadgets so they can be used later
    
    private final TextArea logArea = new TextArea();
    private final ArrayList<Gadget> gadgets = new ArrayList<>();

    @Override
    public void start(Stage stage)
    {
        Pane root = new Pane();

        // Labels and text fields
        // Labels show what each input box is for, like model or price.
        // Text fields are placed next to the labels so the user can enter the data.
        // Together they make it easier for the user to understand what to type.
        Label modelLabel = new Label("Model:");
        modelLabel.setLayoutX(20);
        modelLabel.setLayoutY(20);
        modelField.setLayoutX(140);
        modelField.setLayoutY(20);

        Label priceLabel = new Label("Price:");
        priceLabel.setLayoutX(20);
        priceLabel.setLayoutY(50);
        priceField.setLayoutX(140);
        priceField.setLayoutY(50);

        Label weightLabel = new Label("Weight:");
        weightLabel.setLayoutX(20);
        weightLabel.setLayoutY(80);
        weightField.setLayoutX(140);
        weightField.setLayoutY(80);

        Label sizeLabel = new Label("Size:");
        sizeLabel.setLayoutX(20);
        sizeLabel.setLayoutY(110);
        sizeField.setLayoutX(140);
        sizeField.setLayoutY(110);

        Label creditLabel = new Label("Initial credit:");
        creditLabel.setLayoutX(20);
        creditLabel.setLayoutY(140);
        creditField.setLayoutX(140);
        creditField.setLayoutY(140);

        Label memoryLabel = new Label("Initial memory:");
        memoryLabel.setLayoutX(20);
        memoryLabel.setLayoutY(170);
        memoryField.setLayoutX(140);
        memoryField.setLayoutY(170);

        Label phoneNumberLabel = new Label("Phone number:");
        phoneNumberLabel.setLayoutX(20);
        phoneNumberLabel.setLayoutY(200);
        phoneNumberField.setLayoutX(140);
        phoneNumberField.setLayoutY(200);

        Label durationLabel = new Label("Duration:");
        durationLabel.setLayoutX(20);
        durationLabel.setLayoutY(230);
        durationField.setLayoutX(140);
        durationField.setLayoutY(230);

        Label downloadSizeLabel = new Label("Download size:");
        downloadSizeLabel.setLayoutX(20);
        downloadSizeLabel.setLayoutY(260);
        downloadSizeField.setLayoutX(140);
        downloadSizeField.setLayoutY(260);

        Label displayNumberLabel = new Label("Display number:");
        displayNumberLabel.setLayoutX(20);
        displayNumberLabel.setLayoutY(290);
        displayNumberField.setLayoutX(140);
        displayNumberField.setLayoutY(290);

        // Log area
        logArea.setLayoutX(320);
        logArea.setLayoutY(20);
        logArea.setPrefWidth(330);
        logArea.setPrefHeight(300);
        logArea.setEditable(false);

        // Buttons
        Button addMobileButton = new Button("Add Mobile");
        addMobileButton.setLayoutX(20);
        addMobileButton.setLayoutY(340);

        Button addMP3Button = new Button("Add MP3");
        addMP3Button.setLayoutX(120);
        addMP3Button.setLayoutY(340);

        Button clearButton = new Button("Clear");
        clearButton.setLayoutX(210);
        clearButton.setLayoutY(340);

        Button displayAllButton = new Button("Display All");
        displayAllButton.setLayoutX(280);
        displayAllButton.setLayoutY(340);

        Button makeCallButton = new Button("Make A Call");
        makeCallButton.setLayoutX(380);
        makeCallButton.setLayoutY(340);

        Button downloadMusicButton = new Button("Download Music");
        downloadMusicButton.setLayoutX(500);
        downloadMusicButton.setLayoutY(340);
        
        Button searchButton = new Button("Search");
        
        // This button is my additional feature. 
        // It lets the user search for a gadget by typing the model name. 
        
        searchButton.setLayoutX(620);
        searchButton.setLayoutY(340);


        

        // Add Mobile button
        // This button is used to add a mobile phone to the system.
        // It takes the user-entered details (like model, price, and size).
        // Then it creates a new Mobile object using those details.
        // After that, it adds the mobile to the list of gadgets.
        // Finally, it displays a confirmation message that the mobile was added.
        addMobileButton.setOnAction(e ->
        {
            Mobile m = new Mobile(
                getModelInput(),
                getPriceInput(),
                getWeightInput(),
                getSizeInput(),
                getCreditInput()
            );
            gadgets.add(m);
            logArea.appendText("Added Mobile: " + m + System.lineSeparator());
        });

        // Add MP3 button
        // This button is used to add an MP3 player to the system.
        // It reads the user-entered information.
        // Then it creates a new MP3 object with that information.
        // The MP3 is added to the gadget list.
        // A message is displayed to let the user know it worked.
        addMP3Button.setOnAction(e ->
{
    try {
        MP3 m = new MP3(
            getModelInput(),
            getPriceInput(),
            getWeightInput(),
            getSizeInput(),
            getMemoryInput()
        );
        gadgets.add(m);
        logArea.appendText("Added MP3: " + m + System.lineSeparator());
    } catch (NumberFormatException ex) {
        logArea.appendText("Please enter valid values for MP3." + System.lineSeparator());
    }
});

        // Clear button
        // This button clears all the input boxes on the screen.
        // It removes any text the user has typed.
        // This helps the user start fresh without old values
        clearButton.setOnAction(e ->
        {
            modelField.clear();
            priceField.clear();
            weightField.clear();
            sizeField.clear();
            creditField.clear();
            memoryField.clear();
            phoneNumberField.clear();
            durationField.clear();
            downloadSizeField.clear();
            displayNumberField.clear();
        });

        //display all  button
        //This button shows all the gadgets saved in the system
        //Before showing them, it clears the text area so old information disappears
        //Then it goes through each gadget one by one
        //For every gadget, it shows its number in the list and its details using toString() 
        
        displayAllButton.setOnAction(e ->
        {
            logArea.clear();
            for (int i = 0; i < gadgets.size(); i++)
            {
                logArea.appendText("Display number: " + i + System.lineSeparator());
                logArea.appendText(gadgets.get(i).toString() + System.lineSeparator());
                logArea.appendText(System.lineSeparator());
            }
        });

        // Make A Call button
        //This button lets the user make a call using a mobile gadget
        //It reads the display number the user typed to find the correct gadget
        //If the number is valid, it checks whether that gadget is a Mobile
        //If it is a Mobile, it asks for the phone number and call duration, then makes the call and shows a message
        //If it’s not a Mobile, it shows an error message instead

        makeCallButton.setOnAction(e ->
{
    int displayNumber = getDisplayNumber();

    if (displayNumber != -1)
    {
        Gadget g = gadgets.get(displayNumber);

        if (g instanceof Mobile)
        {
            try {
                Mobile m = (Mobile) g;
                String phoneNumber = getPhoneNumberInput();
                int duration = getDurationInput();

                m.makeCall(duration);
                logArea.appendText("Call made to " + phoneNumber + " for " + duration + " minutes on gadget " + displayNumber + System.lineSeparator());
            } catch (NumberFormatException ex) {
                logArea.appendText("Call duration must be an integer." + System.lineSeparator());
            }
        }
        else
        {
            logArea.appendText("That gadget is not a mobile." + System.lineSeparator());
        }
    }
});

         // Download Music button
         // This button lets the user download music onto an MP3 player.
         // It gets the display number to find the correct gadget.
         // If the number is valid, it checks if the gadget is an MP3.
         // If it is an MP3, it uses the user-entered download size.
         // Then it downloads the music and updates the memory.
         // A message is shown to confirm the download.
         // If it is not an MP3, it shows an error message.
        downloadMusicButton.setOnAction(e ->
{
    int displayNumber = getDisplayNumber();

    if (displayNumber != -1)
    {
        Gadget g = gadgets.get(displayNumber);

        if (g instanceof MP3)
        {
            try {
                MP3 m = (MP3) g;
                int amount = getDownloadSizeInput();
                m.downloadMusic(amount);
                logArea.appendText("Download attempted on gadget " + displayNumber + System.lineSeparator());
            } catch (NumberFormatException ex) {
                logArea.appendText("Download size must be an integer." + System.lineSeparator());
            }
        }
        else
        {
            logArea.appendText("That gadget is not an MP3 player." + System.lineSeparator());
        }
    }
});
        
    // Search button
    // This checks all gadgets to see if any atch the model type in the Model box
    // If it finds one, it shows the details. IF not, it shows "Model not found"
    searchButton.setOnAction(e -> {
    String searchModel = modelField.getText().trim();

    if (searchModel.isEmpty()) {
        logArea.appendText("Please enter a model to search.\n");
        return;
    }

    boolean found = false;

    for (Gadget g : gadgets) {
        if (g.getModel().equalsIgnoreCase(searchModel)) {
            logArea.appendText("Found: " + g.toString() + "\n");
            found = true;
            break;
        }
    }

    if (!found) {
        logArea.appendText("Model not found.\n");
    }
});


        // Add everything to pane
        // Add all the components (labels, text fields, buttons and text area) to the pane.
        // This makes them appear on the screen.
        // Without this step, the user would not see anything in the window.
        root.getChildren().addAll(
            modelLabel, modelField,
            priceLabel, priceField,
            weightLabel, weightField,
            sizeLabel, sizeField,
            creditLabel, creditField,
            memoryLabel, memoryField,
            phoneNumberLabel, phoneNumberField,
            durationLabel, durationField,
            downloadSizeLabel, downloadSizeField,
            displayNumberLabel, displayNumberField,
            addMobileButton, addMP3Button, clearButton,
            displayAllButton, makeCallButton, downloadMusicButton,
            searchButton, 
            logArea
        );

        stage.setScene(new Scene(root, 680, 420));
        stage.setTitle("Gadget Shop");
        stage.show();
    }

    private String getModelInput()
    {
        return modelField.getText();
    }

    private double getPriceInput()
    {
        return Double.parseDouble(priceField.getText().trim());
    }

    private int getWeightInput()
    {
        return Integer.parseInt(weightField.getText().trim());
    }

    private String getSizeInput()
    {
        return sizeField.getText();
    }

    private double getCreditInput()
    {
        return Double.parseDouble(creditField.getText().trim());
    }

    private int getMemoryInput()
    {
        return Integer.parseInt(memoryField.getText().trim());
    }

    private String getPhoneNumberInput()
    {
        return phoneNumberField.getText();
    }

    private int getDurationInput()
    {
        return Integer.parseInt(durationField.getText().trim());
    }

    private int getDownloadSizeInput()
    {
        return Integer.parseInt(downloadSizeField.getText().trim());
    }

    private int getDisplayNumber()
    {
        int displayNumber = -1;

        try
        {
            displayNumber = Integer.parseInt(displayNumberField.getText().trim());

            if (displayNumber < 0 || displayNumber >= gadgets.size())
            {
                JOptionPane.showMessageDialog(null, "Display number is out of range.");
                displayNumber = -1;
            }
        }
        catch (NumberFormatException ex)
        {
            JOptionPane.showMessageDialog(null, "Display number must be an integer.");
        }

        return displayNumber;
    }

    public static void main(String[] args)
    {
        launch();
    }
}