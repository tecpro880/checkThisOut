import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.jay.pdf.formBeans.Address;
import org.jay.pdf.formBeans.PersonData;

public class PdfFormTry {
	public static void main(String[] args) throws Exception {
		PdfFormTry mytry = new PdfFormTry();
		List<PersonData> parsedData = mytry.parsePdfForms();
		mytry.showParsedData(parsedData);
	}

	private List<PersonData> parsePdfForms() throws Exception {
		System.out.println("# # PARSING # # # # # # # # # # #");
		String path = "resources/";
		String[] pdfFormFiles = { "OoPdfForm1.pdf", "OoPdfForm2.pdf" };

		List<PersonData> personsFromFormsParsing = new ArrayList<>();

		for (String pdfFormFile : pdfFormFiles) {

			PersonData person = new PersonData();
			Address address = new Address();

			PDDocument pdfDoc = PDDocument.load(new File(path + pdfFormFile));
			PDAcroForm acro = pdfDoc.getDocumentCatalog().getAcroForm();

			if (acro != null) {
				System.out.println("  # # # # # " + pdfFormFile + " # # # # #");
				List<PDField> pdfFields = acro.getFields();
				for (PDField pdfField : pdfFields) {
					String name = pdfField.getFullyQualifiedName();
					name = stripMeta(name);
					String value = pdfField.getValueAsString();
					value = stripMeta(value);
					switch (name) {
					case "Given Name":
						person.setGivenName(value);
						break;
					case "Family Name":
						person.setFamilyName(value);
						break;
					case "Address 1":
						address.setAddress1(value);
						break;
					case "House nr":
						address.setHouseNr(value);
						break;
					case "Address 2":
						address.setAddress2(value);
						break;
					case "Postcode":
						address.setPostcode(value);
						break;
					case "City":
						address.setCity(value);
						break;
					case "Country":
						address.setCountry(value);
						break;
					case "Height":
						person.setHeight(value);
						break;
					case "Gender":
						person.setGenter(value);
						break;
					case "Driving License":
						if (value.equals("Yes")) {
							person.setDrivingLicense(true);
						} else {
							person.setDrivingLicense(false);
						}
						break;
					case "Language 1":
						if (value.equals("Yes")) {
							person.setLanguage("Deutsch");
						}
						break;
					case "Language 2":
						if (value.equals("Yes")) {
							person.setLanguage("English");
						}
						break;
					case "Language 3":
						if (value.equals("Yes")) {
							person.setLanguage("Français");
						}
						break;
					case "Language 4":
						if (value.equals("Yes")) {
							person.setLanguage("Esperanto");
						}
						break;
					case "Language 5":
						if (value.equals("Yes")) {
							person.setLanguage("Latin");
						}
						break;
					case "Favourite Colour":
						person.setFavouriteColour(value);
						break;
					default:
						System.err.println("Not Expected - " + name + ":" + value);
						break;
					}
				}
				person.setAddress(address);

			}
			personsFromFormsParsing.add(person);
		}
		System.out.println("# # PARSING DONE # # # # # # # #");
		return personsFromFormsParsing;
	}

	private String stripMeta(String text) {
		if (text == null)
			return text;
		String[] metas = { " Text Box", " Combo Box", " Formatted Field", " List Box", " Check Box", "[", "]" };
		for (String meta : metas) {
			text = text.replace(meta, "");
		}
		return text;
	}

	private void showParsedData(List<PersonData> data) {
		System.out.println("= = SHOWING PARSED DATA = = = = = = =");
		if (data == null)
			return;

		for (PersonData person : data) {
			System.out.println("    = = = = = " + person.getGivenName() + " = = = = = ");
			System.out.println("Given Name: " + person.getGivenName());
			System.out.println("Family Name: " + person.getFamilyName());
			System.out.println("House nr: " + person.getAddress().getHouseNr());
			System.out.println("Address 1: " + person.getAddress().getAddress1());
			System.out.println("Address 2: " + person.getAddress().getAddress2());
			System.out.println("Postcode: " + person.getAddress().getPostcode());
			System.out.println("City: " + person.getAddress().getCity());
			System.out.println("Country: " + person.getAddress().getCountry());
			System.out.println("Height: " + person.getHeight());
			System.out.println("Gender: " + person.getGenter());
			System.out.println("Driving License: " + (person.isDrivingLicense() ? "Yes" :"No"));
			System.out.println("Language : " + person.getLanguage());
			System.out.println("Favourite Colour: " + person.getFavouriteColour());
		}
		System.out.println("= = SHOWING PARSED DATA DONE = = = = = = = = = = =");
	}

}
