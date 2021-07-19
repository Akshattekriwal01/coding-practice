/* aonecode */
import java.util.regex.*;
public class reducePrice {
	
	public static void main(String[] args) {
		
			String input  = "sdfj laskdjf jksd %34  dsfj $23  sdj fds $2.79 hdska";
		    Pattern p = Pattern.compile("^\\$(([1-9]\\d{0,2}(,\\d{3})*)|(([1-9]\\d*)?\\d))(\\.\\d\\d)?$");
		    Matcher m = p.matcher(input); 
		    while(m.find()){
		        System.out.println(m.lookingAt());
		    }
		   
	    
	}
}
