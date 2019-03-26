package it.polito.tdp.parole;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {

	Parole elenco = new Parole();

	@FXML // ResourceBundle that was given to the FXMLLoader
	private ResourceBundle resources;

	@FXML // URL location of the FXML file that was given to the FXMLLoader
	private URL location;

	@FXML // fx:id="txtParola"
	private TextField txtParola; // Value injected by FXMLLoader

	@FXML // fx:id="txtResult"
	private TextArea txtResult; // Value injected by FXMLLoader

	@FXML
	private Button btnReset;

	@FXML // fx:id="btnInserisci"
	private Button btnInserisci; // Value injected by FXMLLoader

	@FXML
    private Button btnCancella;
	
	@FXML
	private TextArea txtPerfomances;
	
	@FXML
    void doCancella(ActionEvent event) {
		if(txtResult.getSelectedText().equals("")){
			txtPerfomances.clear();
			txtPerfomances.setText("Seleziona una Parola!");
		}
		else{
			String selected = txtResult.getSelectedText();
			
			double start = System.nanoTime();
			elenco.removeParola(selected);
			double stop = System.nanoTime();
			
			txtResult.clear();
			String result = "" ;
			for(String p: elenco.getElenco())
				result += p + "\n" ;
			txtResult.setText(result);
			
			txtPerfomances.clear();
			txtPerfomances.setText("[REMOVE]: " + (stop - start) / 1e9 + " seconds");
		}
    }
	
	@FXML
	void doInsert(ActionEvent event) {

		double start = System.nanoTime();
		elenco.addParola( txtParola.getText() );
		double stop = System.nanoTime();

		txtResult.clear();
		String result = "" ;
		for(String p: elenco.getElenco())
			result += p + "\n" ;
		txtResult.setText(result);
		
		txtPerfomances.clear();
		txtPerfomances.setText("[INSERT]: " + (stop - start) / 1e9 + " seconds");
		
		txtParola.clear();

	}

	@FXML
	void doReset(ActionEvent event) {
		elenco.reset();
		txtResult.clear();
	}

	@FXML // This method is called by the FXMLLoader when initialization is
			// complete
	void initialize() {
		assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtPerfomances != null : "fx:id=\"txtPerfomances\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnCancella != null : "fx:id=\"btnCancella\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";
	}
}
