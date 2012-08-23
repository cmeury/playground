package eu.meury.subsets.client;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.http.client.URL;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

import eu.meury.subsets.shared.GenerateSubsets;
import eu.meury.subsets.shared.ListVerifier;

/**
 * The main entry-point which creates the UI and handles the widget events.
 *
 */
public class Subsets implements EntryPoint {

	@Override
	public void onModuleLoad() {
		// Create the text box where the set is typed in
		final TextBox inputSetBox = new TextBox();
		inputSetBox.setText("A, B, C");
		inputSetBox.setWidth("600px");
		inputSetBox.setTitle("Enter a comma separated list of characters");

		// Create the button to start the subsets generation
		final Button subsetsButton = new Button("Generate Subsets");
		subsetsButton.addStyleName("button");

		// Add the box and button to a first panel
		HorizontalPanel inputPanel = new HorizontalPanel();
		inputPanel.setWidth("100%");
		inputPanel.setHorizontalAlignment(HorizontalPanel.ALIGN_JUSTIFY);
		inputPanel.add(inputSetBox);
		inputPanel.add(subsetsButton);
		
		// Create a label for error display
		final Label errorLabel = new Label();

		// Create the text area to display the results and a download button
		final TextArea resultsTextArea = new TextArea();
		resultsTextArea.setHeight("100px");
		resultsTextArea.setWidth("800px");
		final Button downloadButton = new Button("Download Result");
		downloadButton.addStyleName("button");

		// Add the text area and the download button to a second panel
		VerticalPanel resultPanel = new VerticalPanel();
		resultPanel.add(resultsTextArea);
		resultPanel.add(downloadButton);
		
		// Create a panel for the final interface and add it to the root panel
		VerticalPanel interfacePanel = new VerticalPanel();
		interfacePanel.setSpacing(10);
		interfacePanel.add(inputPanel);
		interfacePanel.add(errorLabel);
		interfacePanel.add(resultPanel);
		RootPanel.get("interface").add(interfacePanel);
		
		// Focus the cursor on the name field when the app loads
		inputSetBox.setFocus(true);
		inputSetBox.selectAll();

		// Create a handler for the subsetsButton
		class GenerateSubsetHandler implements ClickHandler {
			@Override
			public void onClick(ClickEvent event) {
				errorLabel.setText("");
				String input = inputSetBox.getText();
				
				// Remove spaces and trim the string
				input = input.trim().replaceAll(" ", "");
				
				if (!ListVerifier.isInputSetValid(input)) {
					errorLabel.setText(ListVerifier.ERROR_TEXT);
					return;
				} else {
					errorLabel.setText("");
				}
				
				resultsTextArea.setText("Subsets: " + getSubsets(input));
			}


		}
		
		// Create a handler for the downloadButton
		class DownloadResultHandler implements ClickHandler {

			/**
			 * Upon clicking the button, open a new window and send the
			 * contents of the results text area to the download servlet.
			 * Will trigger a download action in most browser.
			 */
			@Override
			public void onClick(ClickEvent event) {
				Window.open("/download?list="+URL.encode(resultsTextArea.getText()), "_blank", "");
				
			}
			
		}

		// Create a handler for the inputSetBox
		class SubmitListener implements KeyPressHandler {

			/**
			 * When the user presse ENTER, simulate a click event
			 */
			@Override
			public void onKeyPress(KeyPressEvent event) {
				if(event.getCharCode() == KeyCodes.KEY_ENTER) {
					subsetsButton.click();
				}
			}
			
		}
		
		// Add handlers to the buttons and textboxes
		subsetsButton.addClickHandler(new GenerateSubsetHandler());
		downloadButton.addClickHandler(new DownloadResultHandler());
		inputSetBox.addKeyPressHandler(new SubmitListener());
	}

	/**
	 * This is a convenience method that takes the list of characters as a string,
	 * splits it to an array and converts it to a collection. It will then
	 * pass it on to the real function that performs the subset generation.
	 * 
	 * @param input trimmed, space-removed list of characters
	 * @return a list of all subsets
	 */
	public List<String> getSubsets(String input) {
		String[] parts = input.split(",");
		List<String> partsList = new ArrayList<String>();
		for(String s : parts) {
			partsList.add(s);
		}
		return GenerateSubsets.getSubsets(partsList);
	}
}
