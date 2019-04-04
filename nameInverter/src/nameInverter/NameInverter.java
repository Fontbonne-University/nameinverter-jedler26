package nameInverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameInverter {

	String invertName(String name) {
		if(name == null || name.length() <= 0)
			return "";
		else
			return formatName(removeHonorifics(splitNames(name)));
	}

	ArrayList<String> splitNames(String name) {
		return new ArrayList<String>(Arrays.asList(name.trim().split("\\s+")));
	}

	String formatName(List<String> names) {
		if(names.size() == 1) {
			return names.get(0);
		} else {
			return formatMultiElementName(names);
		}
	}

	String formatMultiElementName(List<String> names) {
		String postNominal = "";
		if(names.size() > 2) {
			postNominal = getPostNominals(names);
		}
		String firstName = names.get(0);
		String lastName = names.get(1);
		return String.format("%s, %s %s", lastName, firstName, postNominal).trim();
	}

	List<String> removeHonorifics(List<String> names) {
		if(names.size() > 1 && isHonorific(names.get(0))) {
			names.remove(0);
		}
		return names;
	}

	String getPostNominals(List<String> names) {
		List<String> postNominals;
		postNominals = names.subList(2, names.size());
		String postNominal = "";
		for(String pn : postNominals) {
			postNominal += pn + " ";
		}
		return postNominal;
	}

	boolean isHonorific(String word) {
		return word.matches("Mr\\.|Mrs\\.");
	}
	
}
