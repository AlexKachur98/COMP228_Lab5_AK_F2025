package application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * @author Alex
 * @since 2025-10-29
 * @purpose Center region for the BorderPane. Builds the Employment Application
 *          form using a GridPane (labels + inputs) per the lab screenshot.
 *          Clicking the Send button prints "Application Sent" to the console.
 */
public class EmploymentForm extends GridPane {

	/** Constructs and lays out the employment form UI. */
	public EmploymentForm() {
		// GridPane fundamentals from Weeks 7–8
		setAlignment(Pos.TOP_LEFT);
		setPadding(new Insets(12));
		setHgap(8);
		setVgap(8);
		setStyle("-fx-border-color: red");

		// Two columns: label + input (input column grows)
		ColumnConstraints cLabel = new ColumnConstraints();
		ColumnConstraints cInput = new ColumnConstraints();
		cInput.setHgrow(Priority.ALWAYS);
		getColumnConstraints().addAll(cLabel, cInput);

		// Title
		Label title = new Label("Employment Application Form Example");
		title.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");
		add(title, 0, 0, 2, 1);

		// Names
		TextField tfFirst = new TextField();
		TextField tfLast = new TextField();
		add(new Label("First name *"), 0, 1);
		add(tfFirst, 1, 1);
		add(new Label("Last name *"), 0, 2);
		add(tfLast, 1, 2);

		// Email
		TextField tfEmail = new TextField();
		add(new Label("Email *"), 0, 3);
		add(tfEmail, 1, 3);

		// Portfolio
		TextField tfSite = new TextField("http://");
		add(new Label("Portfolio website"), 0, 4);
		add(tfSite, 1, 4);

		// Position
		TextField tfPosition = new TextField();
		add(new Label("Position you are applying for *"), 0, 5);
		add(tfPosition, 1, 5);

		// Salary + Start (nested GridPane)
		GridPane salaryRow = new GridPane();
		salaryRow.setHgap(8);
		TextField tfSalary = new TextField();
		TextField tfStart = new TextField();
		salaryRow.add(new Label("Salary requirements"), 0, 0);
		salaryRow.add(tfSalary, 1, 0);
		salaryRow.add(new Label("When can you start?"), 2, 0);
		salaryRow.add(tfStart, 3, 0);
		var sC0 = new ColumnConstraints();
		var sC1 = new ColumnConstraints();
		sC1.setHgrow(Priority.ALWAYS);
		var sC2 = new ColumnConstraints();
		var sC3 = new ColumnConstraints();
		sC3.setHgrow(Priority.ALWAYS);
		salaryRow.getColumnConstraints().addAll(sC0, sC1, sC2, sC3);
		add(salaryRow, 0, 6, 2, 1);

		// Phone + Fax (nested GridPane)
		GridPane phoneRow = new GridPane();
		phoneRow.setHgap(8);
		TextField tfPhone = new TextField();
		TextField tfFax = new TextField();
		phoneRow.add(new Label("Phone *"), 0, 0);
		phoneRow.add(tfPhone, 1, 0);
		phoneRow.add(new Label("Fax"), 2, 0);
		phoneRow.add(tfFax, 3, 0);
		var pC0 = new ColumnConstraints();
		var pC1 = new ColumnConstraints();
		pC1.setHgrow(Priority.ALWAYS);
		var pC2 = new ColumnConstraints();
		var pC3 = new ColumnConstraints();
		pC3.setHgrow(Priority.ALWAYS);
		phoneRow.getColumnConstraints().addAll(pC0, pC1, pC2, pC3);
		add(phoneRow, 0, 7, 2, 1);

		// Relocate radios
		ToggleGroup relocate = new ToggleGroup();
		RadioButton rbYes = new RadioButton("Yes");
		RadioButton rbNo = new RadioButton("No");
		RadioButton rbNs = new RadioButton("Not sure");
		rbYes.setToggleGroup(relocate);
		rbNo.setToggleGroup(relocate);
		rbNs.setToggleGroup(relocate);
		rbYes.setSelected(true);
		GridPane relRow = new GridPane();
		relRow.setHgap(12);
		relRow.add(new Label("Are you willing to relocate?"), 0, 0);
		relRow.add(rbYes, 1, 0);
		relRow.add(rbNo, 2, 0);
		relRow.add(rbNs, 3, 0);
		add(relRow, 0, 8, 2, 1);

		// Last company
		TextField tfCompany = new TextField();
		add(new Label("Last company you worked for"), 0, 9);
		add(tfCompany, 1, 9);

		// Comments
		TextArea taNotes = new TextArea();
		taNotes.setPrefRowCount(5);
		add(new Label("Reference / Comments / Questions"), 0, 10);
		add(taNotes, 1, 10);

		// Submit
		Button btnSend = new Button("Send Application");
		btnSend.setOnAction(e -> System.out.println("Application Sent"));
		add(btnSend, 0, 11);
		GridPane.setHalignment(btnSend, HPos.LEFT);
	}
}
